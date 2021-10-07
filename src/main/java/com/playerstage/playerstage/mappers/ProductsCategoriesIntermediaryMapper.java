package com.playerstage.playerstage.mappers;

import com.playerstage.playerstage.models.ProductsCategoriesIntermediary;
import com.playerstage.playerstage.models.ProductsCategoriesIntermediaryExample;
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

public interface ProductsCategoriesIntermediaryMapper {
    @SelectProvider(type=ProductsCategoriesIntermediarySqlProvider.class, method="countByExample")
    long countByExample(ProductsCategoriesIntermediaryExample example);

    @DeleteProvider(type=ProductsCategoriesIntermediarySqlProvider.class, method="deleteByExample")
    int deleteByExample(ProductsCategoriesIntermediaryExample example);

    @Delete({
        "delete from products_categories_intermediary",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into products_categories_intermediary (id, categories_id, ",
        "products_id)",
        "values (#{id,jdbcType=INTEGER}, #{categoriesId,jdbcType=BINARY}, ",
        "#{productsId,jdbcType=BINARY})"
    })
    int insert(ProductsCategoriesIntermediary record);

    @InsertProvider(type=ProductsCategoriesIntermediarySqlProvider.class, method="insertSelective")
    int insertSelective(ProductsCategoriesIntermediary record);

    @SelectProvider(type=ProductsCategoriesIntermediarySqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="categories_id", property="categoriesId", jdbcType=JdbcType.BINARY),
        @Result(column="products_id", property="productsId", jdbcType=JdbcType.BINARY)
    })
    List<ProductsCategoriesIntermediary> selectByExampleWithBLOBs(ProductsCategoriesIntermediaryExample example);

    @SelectProvider(type=ProductsCategoriesIntermediarySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true)
    })
    List<ProductsCategoriesIntermediary> selectByExample(ProductsCategoriesIntermediaryExample example);

    @Select({
        "select",
        "id, categories_id, products_id",
        "from products_categories_intermediary",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="categories_id", property="categoriesId", jdbcType=JdbcType.BINARY),
        @Result(column="products_id", property="productsId", jdbcType=JdbcType.BINARY)
    })
    ProductsCategoriesIntermediary selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ProductsCategoriesIntermediarySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ProductsCategoriesIntermediary record, @Param("example") ProductsCategoriesIntermediaryExample example);

    @UpdateProvider(type=ProductsCategoriesIntermediarySqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") ProductsCategoriesIntermediary record, @Param("example") ProductsCategoriesIntermediaryExample example);

    @UpdateProvider(type=ProductsCategoriesIntermediarySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ProductsCategoriesIntermediary record, @Param("example") ProductsCategoriesIntermediaryExample example);

    @UpdateProvider(type=ProductsCategoriesIntermediarySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ProductsCategoriesIntermediary record);

    @Update({
        "update products_categories_intermediary",
        "set categories_id = #{categoriesId,jdbcType=BINARY},",
          "products_id = #{productsId,jdbcType=BINARY}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(ProductsCategoriesIntermediary record);
}