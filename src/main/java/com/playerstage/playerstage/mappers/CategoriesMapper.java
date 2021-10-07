package com.playerstage.playerstage.mappers;

import com.playerstage.playerstage.models.Categories;
import com.playerstage.playerstage.models.CategoriesExample;
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

public interface CategoriesMapper {
    @SelectProvider(type=CategoriesSqlProvider.class, method="countByExample")
    long countByExample(CategoriesExample example);

    @DeleteProvider(type=CategoriesSqlProvider.class, method="deleteByExample")
    int deleteByExample(CategoriesExample example);

    @Delete({
        "delete from categories",
        "where uuid = #{uuid,jdbcType=BINARY}"
    })
    int deleteByPrimaryKey(UUID uuid);

    @Insert({
        "insert into categories (uuid, name)",
        "values (#{uuid,jdbcType=BINARY}, #{name,jdbcType=VARCHAR})"
    })
    int insert(Categories record);

    @InsertProvider(type=CategoriesSqlProvider.class, method="insertSelective")
    int insertSelective(Categories record);

    @SelectProvider(type=CategoriesSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.BINARY, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<Categories> selectByExample(CategoriesExample example);

    @Select({
        "select",
        "uuid, name",
        "from categories",
        "where uuid = #{uuid,jdbcType=BINARY}"
    })
    @Results({
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.BINARY, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    Categories selectByPrimaryKey(UUID uuid);

    @UpdateProvider(type=CategoriesSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Categories record, @Param("example") CategoriesExample example);

    @UpdateProvider(type=CategoriesSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Categories record, @Param("example") CategoriesExample example);

    @UpdateProvider(type=CategoriesSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Categories record);

    @Update({
        "update categories",
        "set name = #{name,jdbcType=VARCHAR}",
        "where uuid = #{uuid,jdbcType=BINARY}"
    })
    int updateByPrimaryKey(Categories record);
}