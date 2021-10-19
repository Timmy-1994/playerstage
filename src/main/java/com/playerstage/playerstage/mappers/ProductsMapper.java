package com.playerstage.playerstage.mappers;

import com.playerstage.playerstage.models.Products;
import com.playerstage.playerstage.models.ProductsExample;
import java.util.List;
import java.util.UUID;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

public interface ProductsMapper {
    @SelectProvider(type=ProductsSqlProvider.class, method="countByExample")
    long countByExample(ProductsExample example);

    @DeleteProvider(type=ProductsSqlProvider.class, method="deleteByExample")
    int deleteByExample(ProductsExample example);

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
        "origin_item_id, sold, ",
        "edited)",
        "values (#{uuid,jdbcType=BINARY}, #{name,jdbcType=VARCHAR}, ",
        "#{ctime,jdbcType=TIMESTAMP}, #{utime,jdbcType=TIMESTAMP}, ",
        "#{brand,jdbcType=VARCHAR}, #{isPreOrder,jdbcType=TINYINT}, ",
        "#{rating,jdbcType=REAL}, #{description,jdbcType=VARCHAR}, ",
        "#{originItemId,jdbcType=VARCHAR}, #{sold,jdbcType=INTEGER}, ",
        "#{edited,jdbcType=TINYINT})"
    })
    int insert(Products record);

    @InsertProvider(type=ProductsSqlProvider.class, method="insertSelective")
    int insertSelective(Products record);

    @SelectProvider(type=ProductsSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.BINARY, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="ctime", property="ctime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utime", property="utime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="brand", property="brand", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_pre_order", property="isPreOrder", jdbcType=JdbcType.TINYINT),
        @Result(column="rating", property="rating", jdbcType=JdbcType.REAL),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="origin_item_id", property="originItemId", jdbcType=JdbcType.VARCHAR),
        @Result(column="sold", property="sold", jdbcType=JdbcType.INTEGER),
        @Result(column="edited", property="edited", jdbcType=JdbcType.TINYINT)
    })
    List<Products> selectByExampleWithRowbounds(ProductsExample example, RowBounds rowBounds);

    @SelectProvider(type=ProductsSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.BINARY, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="ctime", property="ctime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utime", property="utime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="brand", property="brand", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_pre_order", property="isPreOrder", jdbcType=JdbcType.TINYINT),
        @Result(column="rating", property="rating", jdbcType=JdbcType.REAL),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="origin_item_id", property="originItemId", jdbcType=JdbcType.VARCHAR),
        @Result(column="sold", property="sold", jdbcType=JdbcType.INTEGER),
        @Result(column="edited", property="edited", jdbcType=JdbcType.TINYINT)
    })
    List<Products> selectByExample(ProductsExample example);

    @Select({
        "select",
        "uuid, name, ctime, utime, brand, is_pre_order, rating, description, origin_item_id, ",
        "sold, edited",
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
        @Result(column="origin_item_id", property="originItemId", jdbcType=JdbcType.VARCHAR),
        @Result(column="sold", property="sold", jdbcType=JdbcType.INTEGER),
        @Result(column="edited", property="edited", jdbcType=JdbcType.TINYINT)
    })
    Products selectByPrimaryKey(UUID uuid);

    @UpdateProvider(type=ProductsSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Products record, @Param("example") ProductsExample example);

    @UpdateProvider(type=ProductsSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Products record, @Param("example") ProductsExample example);

    @UpdateProvider(type=ProductsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Products record);

    @Update({
        "update products",
        "set name = #{name,jdbcType=VARCHAR},",
          "ctime = #{ctime,jdbcType=TIMESTAMP},",
          "utime = #{utime,jdbcType=TIMESTAMP},",
          "brand = #{brand,jdbcType=VARCHAR},",
          "is_pre_order = #{isPreOrder,jdbcType=TINYINT},",
          "rating = #{rating,jdbcType=REAL},",
          "description = #{description,jdbcType=VARCHAR},",
          "origin_item_id = #{originItemId,jdbcType=VARCHAR},",
          "sold = #{sold,jdbcType=INTEGER},",
          "edited = #{edited,jdbcType=TINYINT}",
        "where uuid = #{uuid,jdbcType=BINARY}"
    })
    int updateByPrimaryKey(Products record);
}