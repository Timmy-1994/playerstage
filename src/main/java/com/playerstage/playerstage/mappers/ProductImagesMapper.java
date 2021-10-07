package com.playerstage.playerstage.mappers;

import com.playerstage.playerstage.models.ProductImages;
import com.playerstage.playerstage.models.ProductImagesExample;
import java.util.List;
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
import org.apache.ibatis.type.JdbcType;

public interface ProductImagesMapper {
    @SelectProvider(type=ProductImagesSqlProvider.class, method="countByExample")
    long countByExample(ProductImagesExample example);

    @DeleteProvider(type=ProductImagesSqlProvider.class, method="deleteByExample")
    int deleteByExample(ProductImagesExample example);

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

    @InsertProvider(type=ProductImagesSqlProvider.class, method="insertSelective")
    int insertSelective(ProductImages record);

    @SelectProvider(type=ProductImagesSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="is_cover", property="isCover", jdbcType=JdbcType.TINYINT),
        @Result(column="image_hash", property="imageHash", jdbcType=JdbcType.VARCHAR),
        @Result(column="products_id", property="productsId", jdbcType=JdbcType.BINARY)
    })
    List<ProductImages> selectByExampleWithBLOBs(ProductImagesExample example);

    @SelectProvider(type=ProductImagesSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="is_cover", property="isCover", jdbcType=JdbcType.TINYINT),
        @Result(column="image_hash", property="imageHash", jdbcType=JdbcType.VARCHAR)
    })
    List<ProductImages> selectByExample(ProductImagesExample example);

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

    @UpdateProvider(type=ProductImagesSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ProductImages record, @Param("example") ProductImagesExample example);

    @UpdateProvider(type=ProductImagesSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") ProductImages record, @Param("example") ProductImagesExample example);

    @UpdateProvider(type=ProductImagesSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ProductImages record, @Param("example") ProductImagesExample example);

    @UpdateProvider(type=ProductImagesSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ProductImages record);

    @Update({
        "update product_images",
        "set is_cover = #{isCover,jdbcType=TINYINT},",
          "image_hash = #{imageHash,jdbcType=VARCHAR},",
          "products_id = #{productsId,jdbcType=BINARY}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(ProductImages record);

    @Update({
        "update product_images",
        "set is_cover = #{isCover,jdbcType=TINYINT},",
          "image_hash = #{imageHash,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ProductImages record);
}