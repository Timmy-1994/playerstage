package com.playerstage.playerstage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.playerstage.playerstage.mappers.*;
import com.playerstage.playerstage.models.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.HttpMethod;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.*;

@Slf4j
@Component
public class ProductAcessingApplication implements ApplicationRunner {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CategoriesMapper categoriesMapper;

    @Autowired
    PrdouctsShipmentsIntermediaryMapper prdouctsShipmentsIntermediaryMapper;

    @Autowired
    ProductImagesMapper productImagesMapper;

    @Autowired
    ProductModelsMapper productModelsMapper;

    @Autowired
    ProductsCategoriesIntermediaryMapper productsCategoriesIntermediaryMapper;

    @Autowired
    ProductsMapper productsMapper;

    @Autowired
    ShipmentsMapper shipmentsMapper;

    private static final long limit = 30;
    private static final String shopid = "23056754";

    @Override
    public void run(ApplicationArguments args) throws Exception {

        try {

            Categories categories = new Categories();
            CategoriesExample categoriesExample = new CategoriesExample();
            PrdouctsShipmentsIntermediary prdouctsShipmentsIntermediary = new PrdouctsShipmentsIntermediary();
            ProductImages productImages = new ProductImages();
            ProductModels productModels = new ProductModels();
            Products products =  new Products();
            ProductsCategoriesIntermediary productsCategoriesIntermediary = new ProductsCategoriesIntermediary();
            Shipments shipments  = new Shipments();
            ShipmentsExample shipmentsExample = new ShipmentsExample();

            int page = 0;

            String PRODUCT_LIST = "https://shopee.tw/api/v4/search/search_items";
            String PRODUCT_DETAIL = "https://shopee.tw/api/v4/item/get";
            String PRODUCT_SHIPMENT = "https://shopee.tw/api/v4/pdp/get_shipping";
            String PRODUCT_IMAGE = "https://cf.shopee.tw/file";

            HttpHeaders headers = new HttpHeaders();
            headers.set("User-Agent", "Googlebot");
            HttpEntity<?> reqEntity = new HttpEntity<>(headers);

            while(true){

                log.info("[ fetch item_ids from {} ,current page is {}]",PRODUCT_LIST,page);
                ResponseEntity<String> productListResEntity = restTemplate.exchange(
                    UriComponentsBuilder.fromHttpUrl(PRODUCT_LIST)
                        .queryParam("by", "pop")
                        .queryParam("entry_point", "ShopByPDP")
                        .queryParam("limit", limit)
                        .queryParam("match_id", shopid)
                        .queryParam("order", "desc")
                        .queryParam("page_type", "shop")
                        .queryParam("scenario", "PAGE_OTHERS")
                        .queryParam("version", "2")
                        .queryParam("page", page)
                        .queryParam("newest", limit*page)
                        .toUriString(),
                    HttpMethod.GET,
                    reqEntity,
                    String.class
                );

                if (productListResEntity.getStatusCodeValue() != 200) {
                    throw new Exception("request fail");
                }

                JSONArray listArray = JSONObject.fromObject(productListResEntity.getBody()).getJSONArray("items");

                // crawler products done
                if(listArray.isEmpty()){
                    break;
                }

                for (Object object : listArray) {

                    JSONObject productBasicJsonObj = JSONObject.fromObject(object).getJSONObject("item_basic");
                    String itemid = productBasicJsonObj.getString("itemid");

                    log.info("[ fetch item_id = {} 's detail from {} ]" ,itemid,PRODUCT_DETAIL);
                    ResponseEntity<String> productDetailResEntity = restTemplate.exchange(
                        UriComponentsBuilder.fromHttpUrl(PRODUCT_DETAIL)
                            .queryParam("itemid", itemid)
                            .queryParam("shopid", shopid)
                            .toUriString(),
                        HttpMethod.GET,
                        reqEntity,
                        String.class
                    );

                    JSONObject detailDataJsonObj = JSONObject.fromObject(productDetailResEntity.getBody()).getJSONObject("data");
                    
                    // hadle saving products
                    UUID productUuid = UUID.randomUUID();

                    products.setUuid(productUuid);
                    products.setName(detailDataJsonObj.getString("name"));
                    products.setBrand(detailDataJsonObj.getString("brand"));
                    products.setIsPreOrder(detailDataJsonObj.getBoolean("is_pre_order"));
                    products.setRating((float) detailDataJsonObj.getJSONObject("item_rating").getDouble("rating_star"));
                    products.setDescription(detailDataJsonObj.getString("description"));
                    products.setModelName(detailDataJsonObj.getJSONArray("tier_variations").getJSONObject(0).getString("name"));
                    products.setOriginItemId(itemid);
                    products.setSold(detailDataJsonObj.getInt("sold"));

                    log.info("[ fetch item_id = {} 's shipement from {} ]" ,itemid,PRODUCT_SHIPMENT);
                    ResponseEntity<String> shipmentsResEn = restTemplate.exchange(
                        UriComponentsBuilder.fromHttpUrl(PRODUCT_SHIPMENT)
                            .queryParam("itemid", itemid)
                            .queryParam("shopid", shopid)
                            .toUriString(),
                        HttpMethod.GET,
                        reqEntity,
                        String.class
                    );

                    JSONObject shipmentsDataJsonObj = JSONObject.fromObject(shipmentsResEn.getBody()).getJSONObject("data");

                    int producShippingMiniSpend = 0;
                    JSONObject freeShippingJsonObj = shipmentsDataJsonObj.getJSONObject("product_info").getJSONObject("free_shipping");
                    
                    if(!freeShippingJsonObj.isNullObject()){
                        Object minSpendJsonObject = freeShippingJsonObj.get("min_spend");
                        if(!(minSpendJsonObject instanceof JSONNull)){
                            // log.info("[minSpendJsonObject.toString()] {}", Integer.valueOf(prductInfoJsonObj.toString()));
                            producShippingMiniSpend = Integer.valueOf(minSpendJsonObject.toString())/10000;
                        }
                    }

                    products.setFreeShippingMiniSpend(producShippingMiniSpend);

                    productsMapper.insert(products);

                    // hadle saving Shipments
                    for(Object o : shipmentsDataJsonObj.getJSONArray("ungrouped_channel_infos")){
                        JSONObject shipJSONObj = JSONObject.fromObject(o);
                        String shipName = shipJSONObj.getString("name");
                        UUID shipUuid = UUID.randomUUID();
                        
                        // query exist shipment
                        shipmentsExample.createCriteria().andNameEqualTo(shipName);
                        List<Shipments> shipmentList = shipmentsMapper.selectByExample(shipmentsExample);
                        
                        if(shipmentList.size()==1){ 
                            shipUuid = shipmentList.get(0).getUuid();
                        }else{
                            shipments.setUuid(shipUuid);
                            shipments.setName(shipName);
                            shipments.setMaxPrice(shipJSONObj.getInt("max_price")/10000);
                            shipments.setMinPrice(shipJSONObj.getInt("min_price")/10000);
                            
                            JSONObject channelDeliveryInfoJsonObj = shipJSONObj.getJSONObject("channel_delivery_info");
                            int setEstimatedMinDays = channelDeliveryInfoJsonObj.get("estimated_delivery_time_max") instanceof JSONNull ? 0 : channelDeliveryInfoJsonObj.getInt("estimated_delivery_time_max");
                            int setEstimatedMaxDays = channelDeliveryInfoJsonObj.get("estimated_delivery_time_min") instanceof JSONNull ? 0 : channelDeliveryInfoJsonObj.getInt("estimated_delivery_time_min");
                            
                            shipments.setEstimatedMinDays(setEstimatedMinDays);
                            shipments.setEstimatedMaxDays(setEstimatedMaxDays);
                            shipmentsMapper.insert(shipments);
                        }

                        prdouctsShipmentsIntermediary.setProductsId(productUuid);
                        prdouctsShipmentsIntermediary.setShipmentsId(shipUuid);
                        prdouctsShipmentsIntermediaryMapper.insert(prdouctsShipmentsIntermediary);

                    }

                    // saving Categories
                    for(Object o : detailDataJsonObj.getJSONArray("categories")){
                        JSONObject cateJSONObj = JSONObject.fromObject(o);
                        String cateName = cateJSONObj.getString("display_name");
                        UUID cateUUID = UUID.randomUUID();

                        categoriesExample.createCriteria().andNameEqualTo(cateName);
                        List<Categories> cateList = categoriesMapper.selectByExample(categoriesExample);

                        if(cateList.size()==1){
                            cateUUID = cateList.get(0).getUuid();
                        }else{
                            categories.setName(cateName);
                            categories.setUuid(cateUUID);
                            categoriesMapper.insert(categories);
                        }

                        productsCategoriesIntermediary.setCategoriesId(cateUUID);
                        productsCategoriesIntermediary.setProductsId(productUuid);
                        productsCategoriesIntermediaryMapper.insert(productsCategoriesIntermediary);

                    }

                    // save models
                    JSONObject tierVariationsJsonObj = detailDataJsonObj.getJSONArray("tier_variations").getJSONObject(0);
                    JSONArray tierVariationsJsonOptionsArr = tierVariationsJsonObj.getJSONArray("options");
                    Map<String,String> optionsImageHash = new HashMap<String,String>();
                    for (int i = 0; i < tierVariationsJsonOptionsArr.size(); i++) {
                        String key = tierVariationsJsonOptionsArr.get(i).toString();
                        if(key.isEmpty()){
                            continue;
                        }
                        optionsImageHash.put(
                            key,
                            tierVariationsJsonObj.getJSONArray("images").get(i).toString()
                        );
                    }
                    
                    for(Object o : detailDataJsonObj.getJSONArray("models")){
                        JSONObject modelJsonObj = JSONObject.fromObject(o);
                        productModels.setUuid(UUID.randomUUID());
                        productModels.setName(modelJsonObj.getString("name"));
                        productModels.setPrice(modelJsonObj.getInt("price")/10000);
                        Float discount = (float) (modelJsonObj.getInt("price")/(modelJsonObj.getInt("price_before_discount")==0?1:modelJsonObj.getInt("price_before_discount")));
                        productModels.setDiscount(discount);
                        productModels.setTotalStock(modelJsonObj.getInt("stock"));
                        productModels.setPromoteStock(0);
                        productModels.setProductsId(productUuid);
                        
                        String imageHash = optionsImageHash.get(productModels.getName());
                        if(imageHash != null){
                            productModels.setImageHash(imageHash);
                        }
                        
                        productModelsMapper.insert(productModels);
                    }

                    // save images
                    String coverImgHash = detailDataJsonObj.getString("image");
                    for(Object o : detailDataJsonObj.getJSONArray("images")){
                        
                        String imageHash = o.toString();

                        Path path = Paths.get("upload");
                        if(!Files.exists(path)){
                            Files.createDirectory(path);
                        }
                        
                        saveImage(PRODUCT_IMAGE+"/"+imageHash,"upload/"+imageHash+".jpg");
                        
                        productImages.setIsCover(coverImgHash == imageHash);
                        productImages.setProductsId(productUuid);
                        productImages.setImageHash(imageHash);
                        productImagesMapper.insert(productImages);
                    }
                    Thread.sleep(1000);
                }                

                page+=1;
                Thread.sleep(1000);
            }



        } catch (Exception e) {
            log.error(e.toString());
        }

    }
    
    public static void saveImage(String imageUrl, String destinationFile) throws IOException {
        URL url = new URL(imageUrl);
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(destinationFile);

        byte[] b = new byte[2048];
        int length;

        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }

        is.close();
        os.close();
    }
}
