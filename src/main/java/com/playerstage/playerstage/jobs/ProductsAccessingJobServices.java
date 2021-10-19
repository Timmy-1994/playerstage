package com.playerstage.playerstage.jobs;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.playerstage.playerstage.jobs.dto.*;
import com.playerstage.playerstage.mappers.*;
import com.playerstage.playerstage.models.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;


@Slf4j
@Service
public class ProductsAccessingJobServices {
    
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
        
    @Value("${PRODUCTS_ACCESSING_SHOP_ID}")
    private String SHOP_ID;
    
    @Value("${PRODUCTS_ACCESSING_LIST_URL}")
    private String PRODUCT_LIST;
    
    @Value("${PRODUCTS_ACCESSING_DETAIL_URL}")
    private String PRODUCT_DETAIL;
    
    @Value("${PRODUCTS_ACCESSING_SHIPMENT_URL}")
    private String PRODUCT_SHIPMENT;
    
    @Value("${PRODUCTS_ACCESSING_IMAGE_URL}")
    private String PRODUCT_IMAGE;

    @Autowired
    RestTemplate restTemplate;
    
    private final byte limit = 30;

    private final HttpHeaders headers = new HttpHeaders();

    private final HttpEntity<?> reqEntity = new HttpEntity<>(headers);
    
    private CategoriesExample categoriesExample = new CategoriesExample();

    private PrdouctsShipmentsIntermediary prdouctsShipmentsIntermediary = new PrdouctsShipmentsIntermediary();

    private ProductImages productImages = new ProductImages();

    private ProductModels productModels = new ProductModels();

    private Products products = new Products();

    private ProductsExample productsExample = new ProductsExample();

    private ProductsCategoriesIntermediary productsCategoriesIntermediary = new ProductsCategoriesIntermediary();

    private Shipments shipments = new Shipments();

    private Categories categories = new Categories();

    private ShipmentsExample shipmentsExample = new ShipmentsExample();

    {
        headers.set("User-Agent", "Googlebot");
    }

    public List<ItemBasic> getProductList(int page){
        try{
            String url = UriComponentsBuilder.fromHttpUrl(PRODUCT_LIST)
                .queryParam("by", "pop")
                .queryParam("entry_point", "ShopByPDP")
                .queryParam("limit", limit)
                .queryParam("match_id", SHOP_ID)
                .queryParam("order", "desc")
                .queryParam("page_type", "shop")
                .queryParam("scenario", "PAGE_OTHERS")
                .queryParam("version", "2")
                .queryParam("page", page)
                .queryParam("newest", limit*page)
                .toUriString();

            log.info("getProductList request URL {}", url);

            ResponseEntity<String> resEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                reqEntity,
                String.class
            );
            
            JSONArray itemsJsonArr = JSONObject.fromObject(resEntity.getBody()).getJSONArray("items");
            
            if(itemsJsonArr.size()==0){
                log.info("\ngetProductList result is empty , exit\n");
                return List.of();
            }

            List<ItemBasic> res = new ArrayList<ItemBasic>();

            ObjectMapper objectMapper = new ObjectMapper();

            for(Object o : itemsJsonArr){   
                ItemBasic i = objectMapper.readValue(JSONObject.fromObject(o).getJSONObject("item_basic").toString(), ItemBasic.class);
                res.add(i);
            }

            return res;

        }catch(Exception e){
            log.error("current page : {} ",page);
            e.printStackTrace();
            return List.of();
        }
    }

    public ProductDetail getProductDetail(String itemId){

        try{

            // if itemid repeat , ignore it
            productsExample.createCriteria().andOriginItemIdEqualTo(itemId);
            List<Products> productList = productsMapper.selectByExample(productsExample);
            productsExample.clear();

            if(productList.size()>0){
                log.warn("itemid {} repeat , ignore it", itemId);
                return null;
            }

            String url = UriComponentsBuilder.fromHttpUrl(PRODUCT_DETAIL)
                .queryParam("itemid", itemId)
                .queryParam("shopid", SHOP_ID)
                .toUriString();

            log.info("getProductDetail request URL {}", url);

            ResponseEntity<String> resEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                reqEntity,
                String.class
            );

            JSONObject resJsonObj = JSONObject.fromObject(resEntity.getBody()).getJSONObject("data");

            ObjectMapper objectMapper = new ObjectMapper();

            ProductDetail result = objectMapper.readValue(resJsonObj.toString(), ProductDetail.class);
            
            return result;

        }catch(Exception e){
            log.warn("getProductDetail fail itemId : {}", itemId);
            e.printStackTrace();
            return null;
        }
    }

    @Transactional(
        rollbackFor = Exception.class,
        timeout = 6000
    )
    public void saveProducts(ProductDetail detail){
        final UUID productUUID = UUID.randomUUID();
        final String itemId = String.valueOf(detail.getItemid());

        try{
            products.setUuid(productUUID);
            products.setName(detail.getName());
            products.setBrand(Optional.ofNullable(detail.getBrand()).orElse(""));
            products.setIsPreOrder(detail.getIsPreOrder());
            
            products.setRating((float) detail.getItemRating().getRatingStar());
            products.setDescription(detail.getDescription());
            products.setOriginItemId(itemId);
            products.setSold(detail.getSold());
            products.setEdited(false);

            productsMapper.insert(products);
            
        }catch(Exception e){
            log.error("products save fail \nitemid {} \nproductUUID {} \n{}",itemId,productUUID);
            e.printStackTrace();
            throw(e);
        }

        List<UUID> shipUUIDs = saveCommonShipments(itemId);
        shipUUIDs.forEach(uuid->savePrdouctsShipments(uuid,productUUID));
        
        List<UUID> cateUUIDs = saveCommonCategories(detail);
        cateUUIDs.forEach(uuid->saveProductsCategories(uuid,productUUID));

        saveModels(detail,productUUID);
        saveImages(detail,productUUID);

        log.info("success save product itemid {} ",itemId);

    }

    private List<UUID> saveCommonShipments(String itemId){
        List<UUID> shipUUIDs = new ArrayList<UUID>();
        String url = UriComponentsBuilder.fromHttpUrl(PRODUCT_SHIPMENT)
            .queryParam("itemid", itemId)
            .queryParam("shopid", SHOP_ID)
            .toUriString();
        log.info("saveShipments request URL {}", url);
        try{
            ResponseEntity<String> resEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                reqEntity,
                String.class
            );
    
            ObjectMapper objectMapper = new ObjectMapper();
    
            ShipmentDeatil shipmentDeatil = objectMapper.readValue(
                JSONObject.fromObject(resEntity.getBody()).getString("data"),
                ShipmentDeatil.class
            );
    
    
            for(UngroupedChannelInfo ungroupedChannelInfo : shipmentDeatil.getUngroupedChannelInfos()){
                
                String name = ungroupedChannelInfo.getName();
                UUID uuid = UUID.randomUUID();
    
                // query exist shipment
                shipmentsExample.createCriteria().andNameEqualTo(name);
                List<Shipments> shipmentList = shipmentsMapper.selectByExample(shipmentsExample);
                shipmentsExample.clear();
    
                if(shipmentList.size()==1){ 
                    uuid = shipmentList.get(0).getUuid();
                }else{
                    shipments.setUuid(uuid);
                    shipments.setName(name);
    
                    int max = Optional.ofNullable(ungroupedChannelInfo.getMaxPrice()).orElse(0);
                    int mim = Optional.ofNullable(ungroupedChannelInfo.getMinPrice()).orElse(0);
    
                    shipments.setMaxPrice(max);
                    shipments.setMinPrice(mim);
    
                    ChannelDeliveryInfo channelDeliveryInfo = ungroupedChannelInfo.getChannelDeliveryInfo();
                    
                    Integer maxd = (Integer) Optional.ofNullable(channelDeliveryInfo.getEstimatedDeliveryTimeMax()).orElse(0);
                    Integer mind = (Integer) Optional.ofNullable(channelDeliveryInfo.getEstimatedDeliveryTimeMin()).orElse(0);
    
                    shipments.setEstimatedMinDays(mind);
                    shipments.setEstimatedMaxDays(maxd);
                    shipmentsMapper.insert(shipments);
                }
                
                shipUUIDs.add(uuid);
    
            }

            return shipUUIDs;

        }catch(Exception e){
            return shipUUIDs;
        }
    }

    private void savePrdouctsShipments(UUID shipUUID, UUID productUUID){
        try {
            prdouctsShipmentsIntermediary.setUuid(UUID.randomUUID());
            prdouctsShipmentsIntermediary.setProductsId(productUUID);
            prdouctsShipmentsIntermediary.setShipmentsId(shipUUID);
            prdouctsShipmentsIntermediaryMapper.insert(prdouctsShipmentsIntermediary);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    private List<UUID> saveCommonCategories(ProductDetail detail){

        List<UUID> uuids = new ArrayList<UUID>();

        for(Category category : detail.getCategories()){
            String name = category.getDisplayName();

            UUID uuid = UUID.randomUUID();

            categoriesExample.createCriteria().andNameEqualTo(name);
            List<Categories> list = categoriesMapper.selectByExample(categoriesExample);
            categoriesExample.clear();

            if(list.size()==1){
                uuid = list.get(0).getUuid();
            }else{
                categories.setName(name);
                categories.setUuid(uuid);
                categoriesMapper.insert(categories);
            }

            uuids.add(uuid);
        }

        return uuids;
    }

    private void saveProductsCategories(UUID cateUUID, UUID productUUID){
        try {
            productsCategoriesIntermediary.setUuid(UUID.randomUUID());
            productsCategoriesIntermediary.setCategoriesId(cateUUID);
            productsCategoriesIntermediary.setProductsId(productUUID);
            productsCategoriesIntermediaryMapper.insert(productsCategoriesIntermediary);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    private void saveModels(ProductDetail detail,UUID productUUID){
        try {
            List<TierVariation> tierVariations = detail.getTierVariations();
            TierVariation tierVariation = tierVariations.get(0);
            List<String> opts = Optional.ofNullable(tierVariation.getOptions()).orElse(List.of());
            List<String> imgs = Optional.ofNullable(tierVariation.getImages()).orElse(List.of());
            
            opts.removeIf(x->x.isEmpty());

            log.info("opts.size {}",opts.size());
            log.info("imgs.size {}",imgs.size());

            Map<String,String> optsImageHash = IntStream.range(0, opts.size())
                .boxed()
                .collect(
                    Collectors.toMap(x->opts.get(x).toString(), x->imgs.get(x).toString())
                );
            
            for(Model model : detail.getModels()){
                
                productModels.setUuid(UUID.randomUUID());
                productModels.setName(model.getName());
                productModels.setPrice((int) (model.getPrice()/10000));
                
                Float discount = (float) (model.getPrice()/(model.getPriceBeforeDiscount()==0?1:model.getPriceBeforeDiscount()));

                productModels.setDiscount(discount);
                productModels.setTotalStock(model.getStock());
                productModels.setPromoteStock(0);
                productModels.setProductsId(productUUID);
                
                String imageHash = Optional.ofNullable(optsImageHash.get(productModels.getName())).orElse("");
                productModels.setImageHash(imageHash);
                
                productModelsMapper.insert(productModels);
            }
        } catch (Exception e) {
            //TODO: handle exception
            log.error("saveModels fail");
            e.printStackTrace();
            throw(e);
        }
    }

    private void saveImages(ProductDetail detail,UUID productUUID){
        for(String hash : detail.getImages()){
            try {

                Path path = Paths.get("upload");

                if(!Files.exists(path)){
                    Files.createDirectory(path);
                }
                
                saveImageAsFile(PRODUCT_IMAGE+"/"+hash,"upload/"+hash+".jpg");

                productImages.setUuid(UUID.randomUUID());
                productImages.setIsCover(hash == detail.getImage());
                productImages.setProductsId(productUUID);
                productImages.setImageHash(hash);
                productImagesMapper.insert(productImages);

            }catch (IOException e) {
                //TODO: handle exception
            }catch(Exception e){
                log.error("saveImages fail");
                e.printStackTrace();
                throw(e);
            }
        }
    }
    
    private void saveImageAsFile(String imageUrl, String destinationFile) throws IOException {
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
