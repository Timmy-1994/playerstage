package com.playerstage.playerstage.dao;

import com.playerstage.playerstage.models.product_models;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface product_modelsMapper {
    @Delete({
        "delete from product_models",
        "where uuid = #{uuid,jdbcType=BINARY}"
    })
    int deleteByPrimaryKey(byte[] uuid);

    @Insert({
        "insert into product_models (uuid, name, ",
        "price, discount, total_stock, ",
        "promote_stock, sold, ",
        "products_id)",
        "values (#{uuid,jdbcType=BINARY}, #{name,jdbcType=VARCHAR}, ",
        "#{price,jdbcType=INTEGER}, #{discount,jdbcType=REAL}, #{totalStock,jdbcType=INTEGER}, ",
        "#{promoteStock,jdbcType=INTEGER}, #{sold,jdbcType=INTEGER}, ",
        "#{productsId,jdbcType=BINARY})"
    })
    int insert(product_models record);

    int insertSelective(product_models record);

    @Select({
        "select",
        "uuid, name, price, discount, total_stock, promote_stock, sold, products_id",
        "from product_models",
        "where uuid = #{uuid,jdbcType=BINARY}"
    })
    @ResultMap("com.playerstage.playerstage.dao.product_modelsMapper.ResultMapWithBLOBs")
    product_models selectByPrimaryKey(byte[] uuid);

    int updateByPrimaryKeySelective(product_models record);

    @Update({
        "update product_models",
        "set name = #{name,jdbcType=VARCHAR},",
          "price = #{price,jdbcType=INTEGER},",
          "discount = #{discount,jdbcType=REAL},",
          "total_stock = #{totalStock,jdbcType=INTEGER},",
          "promote_stock = #{promoteStock,jdbcType=INTEGER},",
          "sold = #{sold,jdbcType=INTEGER},",
          "products_id = #{productsId,jdbcType=BINARY}",
        "where uuid = #{uuid,jdbcType=BINARY}"
    })
    int updateByPrimaryKeyWithBLOBs(product_models record);

    @Update({
        "update product_models",
        "set name = #{name,jdbcType=VARCHAR},",
          "price = #{price,jdbcType=INTEGER},",
          "discount = #{discount,jdbcType=REAL},",
          "total_stock = #{totalStock,jdbcType=INTEGER},",
          "promote_stock = #{promoteStock,jdbcType=INTEGER},",
          "sold = #{sold,jdbcType=INTEGER}",
        "where uuid = #{uuid,jdbcType=BINARY}"
    })
    int updateByPrimaryKey(product_models record);
}