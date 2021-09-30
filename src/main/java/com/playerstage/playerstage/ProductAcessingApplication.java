
package com.playerstage.playerstage;

import java.util.*;

import com.playerstage.playerstage.mappers.ProductMapper;
import com.playerstage.playerstage.models.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.jackson.JsonObjectDeserializer;
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
    ProductMapper productMapper;

    private static final long limit = 30;
    private static final String shopid = "23056754";

    @Override
    public void run(ApplicationArguments args) throws Exception {
        
        
        try {
    
            Product pojo =  new Product();
            pojo.setUuid(UUID.randomUUID());
            pojo.setName("test");
            pojo.setBrand("brand");
            pojo.setIs_pre_order(false);
            pojo.setRate((float) 0);
            pojo.setDescription("description");
            pojo.setModel_name("model_name");
            
            productMapper.addProduct(pojo);

            var allPs = productMapper.findAll();
            log.info("[test allPs] {}" ,allPs);
            
            // int page = 0;

            // String PRODUCT_LIST = "https://shopee.tw/api/v4/search/search_items";
            // String PRODUCT_DETAIL = "https://shopee.tw/api/v4/item/get";
            
            // HttpHeaders headers = new HttpHeaders();
            // headers.set("User-Agent", "Googlebot");
            // HttpEntity<?> reqEntity = new HttpEntity<>(headers);

            // while(true){

            //     String product_list_url = UriComponentsBuilder.fromHttpUrl(PRODUCT_LIST)
            //         .queryParam("by", "pop")
            //         .queryParam("entry_point", "ShopByPDP")
            //         .queryParam("limit", limit)
            //         .queryParam("match_id", shopid)
            //         .queryParam("order", "desc")
            //         .queryParam("page_type", "shop")
            //         .queryParam("scenario", "PAGE_OTHERS")
            //         .queryParam("version", "2")
            //         .queryParam("page", page)
            //         .queryParam("newest", limit*page)
            //         .toUriString();

            //     // log.info("product_list_url \n{}",  product_list_url);
                
            //     ResponseEntity<String> product_list_res = restTemplate.exchange(
            //         product_list_url, 
            //         HttpMethod.GET,
            //         reqEntity, 
            //         String.class
            //     );

            //     if (product_list_res.getStatusCodeValue() != 200) {
            //         throw new Exception("request fail");
            //     }

            //     JSONObject resultJSONObject = JSONObject.fromObject(product_list_res.getBody());
            //     JSONArray JSONArrayItems = resultJSONObject.getJSONArray("items");

            //     // crawler products done
            //     if(JSONArrayItems.isEmpty()){
            //         break;
            //     }

            //     for (Object object : JSONArrayItems) {

            //         JSONObject item_basic = JSONObject.fromObject(object).getJSONObject("item_basic");
            //         var itemid = item_basic.get("itemid");
                    
            //         // log.info("[var item_id] {}" , itemid);
                    
            //         String product_detail_url = UriComponentsBuilder.fromHttpUrl(PRODUCT_DETAIL)
            //             .queryParam("itemid", itemid)
            //             .queryParam("shopid", shopid)
            //             .toUriString();
                        
            //         ResponseEntity<String> product_detail_res = restTemplate.exchange(
            //             product_detail_url, 
            //             HttpMethod.GET,
            //             reqEntity, 
            //             String.class
            //         );

            //         // hadle by status
            //         // if(product_detail_res.getStatusCode() !== 200) {}

            //         log.info("[product_detail_res] {}" , product_detail_res);
    
            //     }

            //     page+=1;
            //     Thread.sleep(2000);
            // }
            

        } catch (Exception e) {
            log.error(e.toString());
        }

    }
}
