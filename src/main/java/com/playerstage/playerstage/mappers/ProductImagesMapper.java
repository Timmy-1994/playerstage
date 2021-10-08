package com.playerstage.playerstage.mappers;

import com.playerstage.playerstage.models.ProductImages;
import com.playerstage.playerstage.models.ProductImagesExample;
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
import org.apache.ibatis.type.JdbcType;

public interface ProductImagesMapper {
    @SelectProvider(type=ProductImagesSqlProvider.class, method="countByExample")
    long countByExample(ProductImagesExample example);

    @DeleteProvider(type=ProductImagesSqlProvider.class, method="deleteByExample")
    int deleteByExample(ProductImagesExample example);

    @Delete({
        "delete from product_images",
        "where uuid = #{uuid,jdbcType=BINARY}"
    })
    int deleteByPrimaryKey(UUID uuid);

    @Insert({
        "insert into product_images (uuid, is_cover, ",
        "image_hash, products_id)",
        "values (#{uuid,jdbcType=BINARY}, #{isCover,jdbcType=TINYINT}, ",
        "#{imageHash,jdbcType=VARCHAR}, #{productsId,jdbcType=BINARY})"
    })
    int insert(ProductImages record);

    @InsertProvider(type=ProductImagesSqlProvider.class, method="insertSelective")
    int insertSelective(ProductImages record);

    @SelectProvider(type=ProductImagesSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.BINARY, id=true),
        @Result(column="is_cover", property="isCover", jdbcType=JdbcType.TINYINT),
        @Result(column="image_hash", property="imageHash", jdbcType=JdbcType.VARCHAR),
        @Result(column="products_id", property="productsId", jdbcType=JdbcType.BINARY)
    })
    List<ProductImages> selectByExampleWithBLOBs(ProductImagesExample example);

    @SelectProvider(type=ProductImagesSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.BINARY, id=true),
        @Result(column="is_cover", property="isCover", jdbcType=JdbcType.TINYINT),
        @Result(column="image_hash", property="imageHash", jdbcType=JdbcType.VARCHAR)
    })
    List<ProductImages> selectByExample(ProductImagesExample example);

    @Select({
        "select",
        "uuid, is_cover, image_hash, products_id",
        "from product_images",
        "where uuid = #{uuid,jdbcType=BINARY}"
    })
    @Results({
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.BINARY, id=true),
        @Result(column="is_cover", property="isCover", jdbcType=JdbcType.TINYINT),
        @Result(column="image_hash", property="imageHash", jdbcType=JdbcType.VARCHAR),
        @Result(column="products_id", property="productsId", jdbcType=JdbcType.BINARY)
    })
    ProductImages selectByPrimaryKey(UUID uuid);

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
        "where uuid = #{uuid,jdbcType=BINARY}"
    })
    int updateByPrimaryKeyWithBLOBs(ProductImages record);

    @Update({
        "update product_images",
        "set is_cover = #{isCover,jdbcType=TINYINT},",
          "image_hash = #{imageHash,jdbcType=VARCHAR}",
        "where uuid = #{uuid,jdbcType=BINARY}"
    })
    int updateByPrimaryKey(ProductImages record);
}