package com.playerstage.playerstage.controllers;

import java.util.*;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import com.playerstage.playerstage.dto.*;
import com.playerstage.playerstage.mappers.*;
import com.playerstage.playerstage.models.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Slf4j
@Api(tags="商品清單")
@RestController
public class ProductsController {

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

    @GetMapping("/products")
    @ApiOperation(value = "全部商品清單", response = List.class)
    public ResponseEntity<List<ProductResponse>> findAll(
        @RequestParam(name = "page", required = false) Optional<Integer> page,
        @RequestParam(name = "pageSize", required = false) Optional<Integer> pageSize,
        HttpServletRequest request
    ) {

        try {
            int limit = pageSize.orElse(10);
            int offset = page.orElse(0)*limit;

            List<Products> list = productsMapper.select(x->x.limit(limit).offset(offset));

            final String baseUrl = ServletUriComponentsBuilder.fromRequestUri(request)
                .replacePath(null)
                .build()
                .toUriString();
                
            List<ProductResponse> result = list
                .stream()
                .map(x->{
                    ProductResponse resDTO = new ProductResponse();
                        
                    List<String> productImagesUrls = productImagesMapper
                        .select(p->p.where(ProductImagesDynamicSqlSupport.productsId,isEqualTo(x.getUuid())))
                        .stream()
                        .map(i->{
                            String fileName = baseUrl+"/files/"+i.getImageHash()+".jpg";
                            if(i.getIsCover()){
                                resDTO.setCoverImage(fileName);
                            }
                            return fileName;
                        })
                        .collect(Collectors.toList());

                    resDTO.setImgUrl(productImagesUrls);

                    resDTO.setBrand(x.getBrand());
                    resDTO.setTime(x.getUtime());
                    resDTO.setDescription(x.getDescription());
                    resDTO.setIsPreOrder(x.getIsPreOrder());
                    resDTO.setName(x.getName());
                    resDTO.setRating(x.getRating());
                    resDTO.setSold(x.getSold());
                    resDTO.setUuid(x.getUuid());
                  
                    return resDTO;
                })
                .collect(Collectors.toList());
    
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(null);
        }
    }

    @GetMapping("/products/{id}")
    @ApiOperation(value = "依ID取得商品", response = List.class)
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
