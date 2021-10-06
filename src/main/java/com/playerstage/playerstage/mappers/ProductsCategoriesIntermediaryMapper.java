package com.playerstage.playerstage.mappers;

import com.playerstage.playerstage.models.ProductsCategoriesIntermediary;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface ProductsCategoriesIntermediaryMapper {
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

    @Select({
        "select",
        "id, categories_id, products_id",
        "from products_categories_intermediary"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="categories_id", property="categoriesId", jdbcType=JdbcType.BINARY),
        @Result(column="products_id", property="productsId", jdbcType=JdbcType.BINARY)
    })
    List<ProductsCategoriesIntermediary> selectAll();

    @Update({
        "update products_categories_intermediary",
        "set categories_id = #{categoriesId,jdbcType=BINARY},",
          "products_id = #{productsId,jdbcType=BINARY}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(ProductsCategoriesIntermediary record);
}