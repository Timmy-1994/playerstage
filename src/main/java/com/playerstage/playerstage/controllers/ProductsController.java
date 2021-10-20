package com.playerstage.playerstage.controllers;

import java.util.*;

import com.playerstage.playerstage.mappers.ProductsMapper;
import com.playerstage.playerstage.models.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import springfox.documentation.annotations.ApiIgnore;

@Slf4j
@Api(tags="商品清單")
@RestController
public class ProductsController {
    
    @Autowired
    ProductsMapper productsMapper;


    @GetMapping("/products")
    @ApiOperation(value = "全部商品清單", response = List.class)
    public ResponseEntity<List<Products>> find(
        @RequestParam(name = "page", required = false) Optional<Integer> page,
        @RequestParam(name = "pageSize", required = false) Optional<Integer> pageSize
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(List.of());

    }

    @GetMapping("/products/{id}")
    @ApiOperation(value = "", response = List.class)
    public ResponseEntity<Products> findById(
        @RequestParam(name = "uuid", required = false) String uuid
    ) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

}
