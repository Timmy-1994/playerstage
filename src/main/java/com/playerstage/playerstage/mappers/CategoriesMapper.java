package com.playerstage.playerstage.mappers;

import com.playerstage.playerstage.models.Categories;
import java.util.List;
import java.util.UUID;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface CategoriesMapper {
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

    @Select({
        "select",
        "uuid, name",
        "from categories"
    })
    @Results({
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.BINARY, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<Categories> selectAll();

    @Update({
        "update categories",
        "set name = #{name,jdbcType=VARCHAR}",
        "where uuid = #{uuid,jdbcType=BINARY}"
    })
    int updateByPrimaryKey(Categories record);
}