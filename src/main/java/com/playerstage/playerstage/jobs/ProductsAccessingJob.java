package com.playerstage.playerstage.jobs;

import java.util.List;
import com.playerstage.playerstage.jobs.dto.ItemBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.EnableScheduling;
import com.playerstage.playerstage.jobs.dto.ProductDetail;

@Slf4j
@Component
@EnableScheduling
public class ProductsAccessingJob implements ApplicationRunner {

    @Autowired
    ProductsAccessingJobServices productsAccessingServices;
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        access();        
    }

    @Scheduled(cron="0 0 2 * * *")
    private void access() throws Exception {

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
