package com.playerstage.playerstage.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.playerstage.playerstage.dto.*;
import com.playerstage.playerstage.mappers.*;
import com.playerstage.playerstage.models.*;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Slf4j
@Service
public class ShipmentsService {

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

    public List<Shipments> getShipmentsByProductUUID(String uuid) throws Exception{
        
        UUID productUUID = UUID.fromString(uuid);

        List<Shipments> res = prdouctsShipmentsIntermediaryMapper
            .select(x->x.where(PrdouctsShipmentsIntermediaryDynamicSqlSupport.productsId,isEqualTo(productUUID)))
            .stream()
            .map(x-> shipmentsMapper.selectByPrimaryKey(x.getShipmentsId()).get())
            .collect(Collectors.toList())
        ;

        return res;
    }
}
