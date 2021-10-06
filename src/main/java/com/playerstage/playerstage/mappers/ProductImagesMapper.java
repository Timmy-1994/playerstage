package com.playerstage.playerstage.mappers;

import com.playerstage.playerstage.models.ProductImages;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface ProductImagesMapper {
    @Delete({
        "delete from product_images",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into product_images (id, is_cover, ",
        "image_hash, products_id)",
        "values (#{id,jdbcType=INTEGER}, #{isCover,jdbcType=TINYINT}, ",
        "#{imageHash,jdbcType=VARCHAR}, #{productsId,jdbcType=BINARY})"
    })
    int insert(ProductImages record);

    @Select({
        "select",
        "id, is_cover, image_hash, products_id",
        "from product_images",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="is_cover", property="isCover", jdbcType=JdbcType.TINYINT),
        @Result(column="image_hash", property="imageHash", jdbcType=JdbcType.VARCHAR),
        @Result(column="products_id", property="productsId", jdbcType=JdbcType.BINARY)
    })
    ProductImages selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, is_cover, image_hash, products_id",
        "from product_images"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="is_cover", property="isCover", jdbcType=JdbcType.TINYINT),
        @Result(column="image_hash", property="imageHash", jdbcType=JdbcType.VARCHAR),
        @Result(column="products_id", property="productsId", jdbcType=JdbcType.BINARY)
    })
    List<ProductImages> selectAll();

    @Update({
        "update product_images",
        "set is_cover = #{isCover,jdbcType=TINYINT},",
          "image_hash = #{imageHash,jdbcType=VARCHAR},",
          "products_id = #{productsId,jdbcType=BINARY}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ProductImages record);
}