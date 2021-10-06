package com.playerstage.playerstage.mappers;

import com.playerstage.playerstage.models.Products;
import java.util.List;
import java.util.UUID;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface ProductsMapper {
    @Delete({
        "delete from products",
        "where uuid = #{uuid,jdbcType=BINARY}"
    })
    int deleteByPrimaryKey(UUID uuid);

    @Insert({
        "insert into products (uuid, name, ",
        "ctime, utime, ",
        "brand, is_pre_order, ",
        "rating, description, ",
        "model_name, free_shipping_mini_spend, ",
        "origin_item_id, sold)",
        "values (#{uuid,jdbcType=BINARY}, #{name,jdbcType=VARCHAR}, ",
        "#{ctime,jdbcType=TIMESTAMP}, #{utime,jdbcType=TIMESTAMP}, ",
        "#{brand,jdbcType=VARCHAR}, #{isPreOrder,jdbcType=TINYINT}, ",
        "#{rating,jdbcType=REAL}, #{description,jdbcType=VARCHAR}, ",
        "#{modelName,jdbcType=VARCHAR}, #{freeShippingMiniSpend,jdbcType=INTEGER}, ",
        "#{originItemId,jdbcType=VARCHAR}, #{sold,jdbcType=INTEGER})"
    })
    int insert(Products record);

    @Select({
        "select",
        "uuid, name, ctime, utime, brand, is_pre_order, rating, description, model_name, ",
        "free_shipping_mini_spend, origin_item_id, sold",
        "from products",
        "where uuid = #{uuid,jdbcType=BINARY}"
    })
    @Results({
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.BINARY, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="ctime", property="ctime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utime", property="utime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="brand", property="brand", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_pre_order", property="isPreOrder", jdbcType=JdbcType.TINYINT),
        @Result(column="rating", property="rating", jdbcType=JdbcType.REAL),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="model_name", property="modelName", jdbcType=JdbcType.VARCHAR),
        @Result(column="free_shipping_mini_spend", property="freeShippingMiniSpend", jdbcType=JdbcType.INTEGER),
        @Result(column="origin_item_id", property="originItemId", jdbcType=JdbcType.VARCHAR),
        @Result(column="sold", property="sold", jdbcType=JdbcType.INTEGER)
    })
    Products selectByPrimaryKey(UUID uuid);

    @Select({
        "select",
        "uuid, name, ctime, utime, brand, is_pre_order, rating, description, model_name, ",
        "free_shipping_mini_spend, origin_item_id, sold",
        "from products"
    })
    @Results({
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.BINARY, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="ctime", property="ctime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utime", property="utime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="brand", property="brand", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_pre_order", property="isPreOrder", jdbcType=JdbcType.TINYINT),
        @Result(column="rating", property="rating", jdbcType=JdbcType.REAL),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="model_name", property="modelName", jdbcType=JdbcType.VARCHAR),
        @Result(column="free_shipping_mini_spend", property="freeShippingMiniSpend", jdbcType=JdbcType.INTEGER),
        @Result(column="origin_item_id", property="originItemId", jdbcType=JdbcType.VARCHAR),
        @Result(column="sold", property="sold", jdbcType=JdbcType.INTEGER)
    })
    List<Products> selectAll();

    @Update({
        "update products",
        "set name = #{name,jdbcType=VARCHAR},",
          "ctime = #{ctime,jdbcType=TIMESTAMP},",
          "utime = #{utime,jdbcType=TIMESTAMP},",
          "brand = #{brand,jdbcType=VARCHAR},",
          "is_pre_order = #{isPreOrder,jdbcType=TINYINT},",
          "rating = #{rating,jdbcType=REAL},",
          "description = #{description,jdbcType=VARCHAR},",
          "model_name = #{modelName,jdbcType=VARCHAR},",
          "free_shipping_mini_spend = #{freeShippingMiniSpend,jdbcType=INTEGER},",
          "origin_item_id = #{originItemId,jdbcType=VARCHAR},",
          "sold = #{sold,jdbcType=INTEGER}",
        "where uuid = #{uuid,jdbcType=BINARY}"
    })
    int updateByPrimaryKey(Products record);
}