package com.playerstage.playerstage.mappers;

import com.playerstage.playerstage.models.PrdouctsShipmentsIntermediary;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface PrdouctsShipmentsIntermediaryMapper {
    @Delete({
        "delete from prdoucts_shipments_intermediary",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into prdoucts_shipments_intermediary (id, shipments_id, ",
        "products_id)",
        "values (#{id,jdbcType=INTEGER}, #{shipmentsId,jdbcType=BINARY}, ",
        "#{productsId,jdbcType=BINARY})"
    })
    int insert(PrdouctsShipmentsIntermediary record);

    @Select({
        "select",
        "id, shipments_id, products_id",
        "from prdoucts_shipments_intermediary",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="shipments_id", property="shipmentsId", jdbcType=JdbcType.BINARY),
        @Result(column="products_id", property="productsId", jdbcType=JdbcType.BINARY)
    })
    PrdouctsShipmentsIntermediary selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, shipments_id, products_id",
        "from prdoucts_shipments_intermediary"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="shipments_id", property="shipmentsId", jdbcType=JdbcType.BINARY),
        @Result(column="products_id", property="productsId", jdbcType=JdbcType.BINARY)
    })
    List<PrdouctsShipmentsIntermediary> selectAll();

    @Update({
        "update prdoucts_shipments_intermediary",
        "set shipments_id = #{shipmentsId,jdbcType=BINARY},",
          "products_id = #{productsId,jdbcType=BINARY}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PrdouctsShipmentsIntermediary record);
}