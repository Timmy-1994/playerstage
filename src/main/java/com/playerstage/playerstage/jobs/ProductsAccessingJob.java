package com.playerstage.playerstage.jobs;

import java.util.List;
import com.playerstage.playerstage.jobs.dto.ItemBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.scheduling.annotation.EnableScheduling;
import com.playerstage.playerstage.jobs.dto.ProductDetail;

@Slf4j
@Api(tags="排程任務")
@Component
@EnableScheduling
@RestController
public class ProductsAccessingJob {

    @Autowired
    ProductsAccessingJobServices productsAccessingServices;

    @PreAuthorize("hasRole('USER')")
    @Scheduled(cron="0 0 2 * * *")
    @PostMapping("/jobs")
    @Operation(summary = "執行取得蝦皮商品排程任務")
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
