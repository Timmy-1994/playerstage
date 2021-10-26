package com.playerstage.playerstage.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.playerstage.playerstage.dto.*;
import com.playerstage.playerstage.mappers.*;
import com.playerstage.playerstage.models.*;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Slf4j
@Service
public class ProductsService {

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


    @Transactional(rollbackFor = Exception.class)
    public void updateProductModel(String modleUUIDStr, ProductModelRequest model) throws Exception{

        UUID modelUUID = UUID.fromString(modleUUIDStr);

        ProductModels destModel = new ProductModels(){{
            setUuid(modelUUID);
        }};
        BeanUtils.copyProperties(destModel, model);

        productModelsMapper.updateByPrimaryKeySelective(destModel);

        // set product has been edited
        UUID productUUID = productModelsMapper.selectByPrimaryKey(modelUUID).orElseThrow().getProductsId();
        updateProduct(productUUID.toString(),Optional.empty());

    }

    public void deleteProductModel(String UUIDStr){
        productModelsMapper.deleteByPrimaryKey(UUID.fromString(UUIDStr));
    }

    public void addProductModelByProductId(String productUuidStr, ProductModelRequest modelReq) throws Exception{
        
        UUID productUUID = UUID.fromString(productUuidStr);
        ProductModels destModel = new ProductModels() {{
            setUuid(UUID.randomUUID());
            setProductsId(productUUID);
        }};

        BeanUtils.copyProperties(destModel, modelReq);

        productModelsMapper.insert(destModel);
    }

    public void addProduct(ProductRequest productReq) throws Exception{
        UUID uuid = UUID.randomUUID();
       
        Products dest = new Products() {{
            setUuid(uuid);
            setEdited(true);
        }};
        BeanUtils.copyProperties(dest, productReq);
        
        productsMapper.insert(dest);
    }

    public void deleteProduct(String uuidStr){
        productsMapper.deleteByPrimaryKey(UUID.fromString(uuidStr));
    }

    public void updateProduct(String UUIDStr, Optional<Products> optProduct) throws Exception{

        Products product = optProduct.orElse(new Products());

        product.setUuid(UUID.fromString(UUIDStr));
        product.setEdited(true);

        productsMapper.updateByPrimaryKeySelective(product);

    }

    public List<ProductResponse> getProductResponse(int limit,int offset) throws Exception {

        List<Products> productList = productsMapper.select(x->x.limit(limit).offset(offset));

        List<ProductResponse> result = productList
            .stream()
            .map(x-> {
                try {
                    return getProductResponse(x);
                } catch (Exception e) {
                    return null;
                }
            })
            .collect(Collectors.toList());

        return result;
    }

    public ProductResponse getProductResponse(String UUIDStr) throws Exception {

        Products product = productsMapper.selectByPrimaryKey(UUID.fromString(UUIDStr)).orElseThrow();

        ProductResponse result = getProductResponse(product);

        return result;
    }

    private ProductResponse getProductResponse(Products product) throws Exception {
        ProductResponse response = new ProductResponse();

        List<String> productImagesUrls = productImagesMapper
            .select(p->p.where(ProductImagesDynamicSqlSupport.productsId,isEqualTo(product.getUuid())))
            .stream()
            .map(i->{
                String fileName = getFullImagePath(i.getImageHash());
                if(i.getIsCover()){
                    response.setCoverImage(fileName);
                }
                return fileName;
            })
            .collect(Collectors.toList());

        response.setImgUrl(productImagesUrls);

        UUID uuid = product.getUuid();

        List<ProductModels> models = productModelsMapper
            .select(p->p.where(ProductModelsDynamicSqlSupport.productsId,isEqualTo(uuid)));
        response.setModels(models);

        response.setBrand(product.getBrand());
        response.setTime(product.getUtime());
        response.setDescription(product.getDescription());
        response.setIsPreOrder(product.getIsPreOrder());
        response.setName(product.getName());
        response.setRating(product.getRating());
        response.setSold(product.getSold());
        response.setUuid(uuid);

        return response;
    }

    private String getFullImagePath(String input) {
        final String basePath = ServletUriComponentsBuilder.fromCurrentContextPath().toUriString();
        if(input.contains(basePath)){
            return input;
        }
        return  basePath+"/files/"+input+".jpg";
    }

}
