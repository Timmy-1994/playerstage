package com.playerstage.playerstage.controllers;

import java.util.*;
import com.playerstage.playerstage.dto.*;
import com.playerstage.playerstage.models.*;
import com.playerstage.playerstage.services.ProductsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.Operation;

@Api(tags="商品清單")
@RestController
public class ProductsController {

    @Autowired
    ProductsService productsService;

    @GetMapping("/products")
    @Operation(summary = "全部商品清單")
    public ResponseEntity<List<ProductResponse>> findAll(
        @RequestParam(name = "page", required = false) Optional<Integer> page,
        @RequestParam(name = "pageSize", required = false) Optional<Integer> pageSize
    ) {
        try {
            int limit = pageSize.orElse(10);
            int offset = page.orElse(0)*limit;           
            List<ProductResponse> result = productsService.getProductResponse(limit, offset);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(null);
        }
    }

    @GetMapping("/products/{id}")
    @Operation(summary = "依ID取得商品")
    public ResponseEntity<ProductResponse> findById(
        @RequestParam(name = "uuid", required = true) String uuid
    ) {
        try{
            ProductResponse result = productsService.getProductResponse(uuid);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(null);
        }
    }

    @PutMapping("/products/{id}")
    @Operation(summary = "依ID更新商品-基本")
    public ResponseEntity<String> updateProductById(
        @RequestParam(name = "uuid", required = true) String uuid,
        @RequestBody Products product
    ) {
        try{
            
            return ResponseEntity.status(HttpStatus.OK).body("uuid");
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(null);
        }
    }

    @PutMapping("/products/model/{uuid}")
    @Operation(summary = "依ID更新商品-子項")
    public ResponseEntity<String> updateProductById(
        @PathVariable(name ="uuid") String id,
        @RequestBody ProductModels model
    ) {
        try{

            return ResponseEntity.status(HttpStatus.OK).body("uuid");
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(null);
        }
    }
    
}
