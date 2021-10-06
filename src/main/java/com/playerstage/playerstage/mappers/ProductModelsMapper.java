package com.playerstage.playerstage.mappers;

import com.playerstage.playerstage.models.ProductModels;
import java.util.List;
import java.util.UUID;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface ProductModelsMapper {
    @Delete({
        "delete from product_models",
        "where uuid = #{uuid,jdbcType=BINARY}"
    })
    int deleteByPrimaryKey(UUID uuid);

    @Insert({
        "insert into product_models (uuid, name, ",
        "price, discount, total_stock, ",
        "promote_stock, image_hash, ",
        "products_id)",
        "values (#{uuid,jdbcType=BINARY}, #{name,jdbcType=VARCHAR}, ",
        "#{price,jdbcType=INTEGER}, #{discount,jdbcType=REAL}, #{totalStock,jdbcType=INTEGER}, ",
        "#{promoteStock,jdbcType=INTEGER}, #{imageHash,jdbcType=VARCHAR}, ",
        "#{productsId,jdbcType=BINARY})"
    })
    int insert(ProductModels record);

    @Select({
        "select",
        "uuid, name, price, discount, total_stock, promote_stock, image_hash, products_id",
        "from product_models",
        "where uuid = #{uuid,jdbcType=BINARY}"
    })
    @Results({
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.BINARY, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.INTEGER),
        @Result(column="discount", property="discount", jdbcType=JdbcType.REAL),
        @Result(column="total_stock", property="totalStock", jdbcType=JdbcType.INTEGER),
        @Result(column="promote_stock", property="promoteStock", jdbcType=JdbcType.INTEGER),
        @Result(column="image_hash", property="imageHash", jdbcType=JdbcType.VARCHAR),
        @Result(column="products_id", property="productsId", jdbcType=JdbcType.BINARY)
    })
    ProductModels selectByPrimaryKey(UUID uuid);

    @Select({
        "select",
        "uuid, name, price, discount, total_stock, promote_stock, image_hash, products_id",
        "from product_models"
    })
    @Results({
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.BINARY, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.INTEGER),
        @Result(column="discount", property="discount", jdbcType=JdbcType.REAL),
        @Result(column="total_stock", property="totalStock", jdbcType=JdbcType.INTEGER),
        @Result(column="promote_stock", property="promoteStock", jdbcType=JdbcType.INTEGER),
        @Result(column="image_hash", property="imageHash", jdbcType=JdbcType.VARCHAR),
        @Result(column="products_id", property="productsId", jdbcType=JdbcType.BINARY)
    })
    List<ProductModels> selectAll();

    @Update({
        "update product_models",
        "set name = #{name,jdbcType=VARCHAR},",
          "price = #{price,jdbcType=INTEGER},",
          "discount = #{discount,jdbcType=REAL},",
          "total_stock = #{totalStock,jdbcType=INTEGER},",
          "promote_stock = #{promoteStock,jdbcType=INTEGER},",
          "image_hash = #{imageHash,jdbcType=VARCHAR},",
          "products_id = #{productsId,jdbcType=BINARY}",
        "where uuid = #{uuid,jdbcType=BINARY}"
    })
    int updateByPrimaryKey(ProductModels record);
}