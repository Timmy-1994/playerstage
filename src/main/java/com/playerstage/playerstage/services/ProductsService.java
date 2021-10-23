package com.playerstage.playerstage.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.playerstage.playerstage.dto.ProductResponse;
import com.playerstage.playerstage.mappers.*;
import com.playerstage.playerstage.models.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

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
    public void saveProductPrice(UUID ModelUUID, ProductModels models) throws Exception{
        
        // ProductModels model = productModelsMapper.selectByPrimaryKey(ModelUUID).orElseThrow();

        // UUID productUUID = model.getProductsId();
        // productsMapper.update(x->
        //     x.set(ProductsDynamicSqlSupport.edited,Boolean.valueOf())
        //     .where(ProductsDynamicSqlSupport.uuid, isEqualTo(productUUID))
        // );
        

        // productModelsMapper.updateByPrimaryKey(ModelUUID);

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

    public ProductResponse getProductResponse(String uuid) throws Exception {
       
        Products product = productsMapper.selectByPrimaryKey(UUID.fromString(uuid)).orElseThrow();

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

        List<ProductModels> models = productModelsMapper
            .select(p->p.where(ProductModelsDynamicSqlSupport.productsId,isEqualTo(product.getUuid())));
    
        response.setModels(models);

        response.setBrand(product.getBrand());
        response.setTime(product.getUtime());
        response.setDescription(product.getDescription());
        response.setIsPreOrder(product.getIsPreOrder());
        response.setName(product.getName());
        response.setRating(product.getRating());
        response.setSold(product.getSold());
        response.setUuid(product.getUuid());

        return response;
    }
    
    private String getFullImagePath(String name) {
        final String basePath = ServletUriComponentsBuilder.fromCurrentContextPath().toUriString();
        return  basePath+"/files/"+name+".jpg";
    } 
    

}
