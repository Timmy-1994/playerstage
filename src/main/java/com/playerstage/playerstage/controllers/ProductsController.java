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

    @PostMapping("/products")
    @Operation(summary = "新增商品")
    public ResponseEntity<?> add(
        @RequestBody ProductRequest product
    ){
        try{
            productsService.addProduct(product);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e);
        } 
    }

    @GetMapping("/products")
    @Operation(summary = "全部商品清單")
    public ResponseEntity<?> findAll(
        @RequestParam(name = "page", required = false) Optional<Integer> page,
        @RequestParam(name = "pageSize", required = false) Optional<Integer> pageSize
    ) {
        try {
            int limit = pageSize.orElse(10);
            int offset = page.orElse(0)*limit;
            List<ProductResponse> result = productsService.getProductResponse(limit, offset);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e);
        }
    }

    @GetMapping("/products/{uuid}")
    @Operation(summary = "依ID取得商品")
    public ResponseEntity<?> findById(
        @PathVariable(name ="uuid") String uuid
    ) {
        try{
            ProductResponse result = productsService.getProductResponse(uuid);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e);
        }
    }

    @PutMapping("/products/{uuid}")
    @Operation(summary = "依ID更新商品")
    public ResponseEntity<?> updateById(
        @PathVariable(name ="uuid",required = true) String uuid,
        @RequestBody Products product
    ) {
        try{
            productsService.updateProduct(uuid,Optional.ofNullable(product));
            ProductResponse result = productsService.getProductResponse(uuid);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e);
        }
    }

    @DeleteMapping("/products/{uuid}")
    @Operation(summary = "依ID刪除商品")
    public ResponseEntity<?> deleteById(
        @PathVariable(name ="uuid") String uuid
    ){
        try{
            productsService.deleteProduct(uuid);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e);
        }
    }

    @PutMapping("/products/model/{uuid}")
    @Operation(summary = "依子項ID更新商品子項")
    public ResponseEntity<?> updateModelById(
        @PathVariable(name ="uuid") String modelUUID,
        @RequestBody ProductModelRequest model
    ) {
        try{
            productsService.updateProductModel(modelUUID,model);
            return ResponseEntity.status(HttpStatus.OK).body(model);
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e);
        }
    }
    
    @DeleteMapping("/products/model/{uuid}")
    @Operation(summary = "依子項ID刪除商品子項")
    public ResponseEntity<?> deleteModelById(
        @PathVariable(name ="uuid") String modelUUID
    ) {
        try{
            productsService.deleteProductModel(modelUUID);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e);
        }
    }

    @PostMapping("/products/{uuid}/model")
    @Operation(summary = "依主項ID新增商品子項")
    public ResponseEntity<?> addProductModelByProductId(
        @PathVariable(name ="uuid") String uuid,
        @RequestBody ProductModelRequest model
    ) {
        try{
            productsService.addProductModelByProductId(uuid,model);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e);
        }
    }

}
