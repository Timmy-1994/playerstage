package com.playerstage.playerstage.mappers;

import com.playerstage.playerstage.models.PrdouctsShipmentsIntermediary;
import com.playerstage.playerstage.models.PrdouctsShipmentsIntermediaryExample;
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

public interface PrdouctsShipmentsIntermediaryMapper {
    @SelectProvider(type=PrdouctsShipmentsIntermediarySqlProvider.class, method="countByExample")
    long countByExample(PrdouctsShipmentsIntermediaryExample example);

    @DeleteProvider(type=PrdouctsShipmentsIntermediarySqlProvider.class, method="deleteByExample")
    int deleteByExample(PrdouctsShipmentsIntermediaryExample example);

    @Delete({
        "delete from prdoucts_shipments_intermediary",
        "where uuid = #{uuid,jdbcType=BINARY}"
    })
    int deleteByPrimaryKey(UUID uuid);

    @Insert({
        "insert into prdoucts_shipments_intermediary (uuid, shipments_id, ",
        "products_id)",
        "values (#{uuid,jdbcType=BINARY}, #{shipmentsId,jdbcType=BINARY}, ",
        "#{productsId,jdbcType=BINARY})"
    })
    int insert(PrdouctsShipmentsIntermediary record);

    @InsertProvider(type=PrdouctsShipmentsIntermediarySqlProvider.class, method="insertSelective")
    int insertSelective(PrdouctsShipmentsIntermediary record);

    @SelectProvider(type=PrdouctsShipmentsIntermediarySqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.BINARY, id=true),
        @Result(column="shipments_id", property="shipmentsId", jdbcType=JdbcType.BINARY),
        @Result(column="products_id", property="productsId", jdbcType=JdbcType.BINARY)
    })
    List<PrdouctsShipmentsIntermediary> selectByExampleWithBLOBsWithRowbounds(PrdouctsShipmentsIntermediaryExample example, RowBounds rowBounds);

    @SelectProvider(type=PrdouctsShipmentsIntermediarySqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.BINARY, id=true),
        @Result(column="shipments_id", property="shipmentsId", jdbcType=JdbcType.BINARY),
        @Result(column="products_id", property="productsId", jdbcType=JdbcType.BINARY)
    })
    List<PrdouctsShipmentsIntermediary> selectByExampleWithBLOBs(PrdouctsShipmentsIntermediaryExample example);

    @SelectProvider(type=PrdouctsShipmentsIntermediarySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.BINARY, id=true)
    })
    List<PrdouctsShipmentsIntermediary> selectByExampleWithRowbounds(PrdouctsShipmentsIntermediaryExample example, RowBounds rowBounds);

    @SelectProvider(type=PrdouctsShipmentsIntermediarySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.BINARY, id=true)
    })
    List<PrdouctsShipmentsIntermediary> selectByExample(PrdouctsShipmentsIntermediaryExample example);

    @Select({
        "select",
        "uuid, shipments_id, products_id",
        "from prdoucts_shipments_intermediary",
        "where uuid = #{uuid,jdbcType=BINARY}"
    })
    @Results({
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.BINARY, id=true),
        @Result(column="shipments_id", property="shipmentsId", jdbcType=JdbcType.BINARY),
        @Result(column="products_id", property="productsId", jdbcType=JdbcType.BINARY)
    })
    PrdouctsShipmentsIntermediary selectByPrimaryKey(UUID uuid);

    @UpdateProvider(type=PrdouctsShipmentsIntermediarySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PrdouctsShipmentsIntermediary record, @Param("example") PrdouctsShipmentsIntermediaryExample example);

    @UpdateProvider(type=PrdouctsShipmentsIntermediarySqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") PrdouctsShipmentsIntermediary record, @Param("example") PrdouctsShipmentsIntermediaryExample example);

    @UpdateProvider(type=PrdouctsShipmentsIntermediarySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PrdouctsShipmentsIntermediary record, @Param("example") PrdouctsShipmentsIntermediaryExample example);

    @UpdateProvider(type=PrdouctsShipmentsIntermediarySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PrdouctsShipmentsIntermediary record);

    @Update({
        "update prdoucts_shipments_intermediary",
        "set shipments_id = #{shipmentsId,jdbcType=BINARY},",
          "products_id = #{productsId,jdbcType=BINARY}",
        "where uuid = #{uuid,jdbcType=BINARY}"
    })
    int updateByPrimaryKeyWithBLOBs(PrdouctsShipmentsIntermediary record);
}