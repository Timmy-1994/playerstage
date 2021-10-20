package com.playerstage.playerstage.jobs;

import java.util.List;
import com.playerstage.playerstage.jobs.dto.ItemBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.EnableScheduling;
import com.playerstage.playerstage.jobs.dto.ProductDetail;

@Slf4j
@Component
@EnableScheduling
public class ProductsAccessingJob {

    @Autowired
    ProductsAccessingJobServices productsAccessingServices;
    
    @EventListener(ContextRefreshedEvent.class)
    @Scheduled(cron="0 0 2 * * *")
    public void access() throws Exception {

        int page = 0;

        while(true){

            List<ItemBasic> itemBasics = productsAccessingServices.getProductList(page);

            if(itemBasics.size() == 0){
                break;
            }

            for(ItemBasic itemBasic : itemBasics){
                try{
                    String itemId = String.valueOf(itemBasic.getItemid());

                    ProductDetail detail = productsAccessingServices.getProductDetail(itemId);

                    if(detail==null){
                        continue;
                    }

                    productsAccessingServices.saveProducts(detail);

                }catch(Exception e){

                }
            }

            Thread.sleep(1000);
            page++;
        }

    }

}
