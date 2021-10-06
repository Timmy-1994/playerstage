package com.playerstage.playerstage.dao;

import com.playerstage.playerstage.models.product_models;

public interface product_modelsMapper {
    int deleteByPrimaryKey(byte[] uuid);

    int insert(product_models record);

    int insertSelective(product_models record);

    product_models selectByPrimaryKey(byte[] uuid);

    int updateByPrimaryKeySelective(product_models record);

    int updateByPrimaryKeyWithBLOBs(product_models record);

    int updateByPrimaryKey(product_models record);
}