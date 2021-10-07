package com.playerstage.playerstage.mappers;

import com.playerstage.playerstage.models.Shipments;
import com.playerstage.playerstage.models.ShipmentsExample;
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

public interface ShipmentsMapper {
    @SelectProvider(type=ShipmentsSqlProvider.class, method="countByExample")
    long countByExample(ShipmentsExample example);

    @DeleteProvider(type=ShipmentsSqlProvider.class, method="deleteByExample")
    int deleteByExample(ShipmentsExample example);

    @Delete({
        "delete from shipments",
        "where uuid = #{uuid,jdbcType=BINARY}"
    })
    int deleteByPrimaryKey(UUID uuid);

    @Insert({
        "insert into shipments (uuid, name, ",
        "max_price, min_price, ",
        "estimated_max_days, estimated_min_days)",
        "values (#{uuid,jdbcType=BINARY}, #{name,jdbcType=VARCHAR}, ",
        "#{maxPrice,jdbcType=INTEGER}, #{minPrice,jdbcType=INTEGER}, ",
        "#{estimatedMaxDays,jdbcType=INTEGER}, #{estimatedMinDays,jdbcType=INTEGER})"
    })
    int insert(Shipments record);

    @InsertProvider(type=ShipmentsSqlProvider.class, method="insertSelective")
    int insertSelective(Shipments record);

    @SelectProvider(type=ShipmentsSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.BINARY, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="max_price", property="maxPrice", jdbcType=JdbcType.INTEGER),
        @Result(column="min_price", property="minPrice", jdbcType=JdbcType.INTEGER),
        @Result(column="estimated_max_days", property="estimatedMaxDays", jdbcType=JdbcType.INTEGER),
        @Result(column="estimated_min_days", property="estimatedMinDays", jdbcType=JdbcType.INTEGER)
    })
    List<Shipments> selectByExample(ShipmentsExample example);

    @Select({
        "select",
        "uuid, name, max_price, min_price, estimated_max_days, estimated_min_days",
        "from shipments",
        "where uuid = #{uuid,jdbcType=BINARY}"
    })
    @Results({
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.BINARY, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="max_price", property="maxPrice", jdbcType=JdbcType.INTEGER),
        @Result(column="min_price", property="minPrice", jdbcType=JdbcType.INTEGER),
        @Result(column="estimated_max_days", property="estimatedMaxDays", jdbcType=JdbcType.INTEGER),
        @Result(column="estimated_min_days", property="estimatedMinDays", jdbcType=JdbcType.INTEGER)
    })
    Shipments selectByPrimaryKey(UUID uuid);

    @UpdateProvider(type=ShipmentsSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Shipments record, @Param("example") ShipmentsExample example);

    @UpdateProvider(type=ShipmentsSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Shipments record, @Param("example") ShipmentsExample example);

    @UpdateProvider(type=ShipmentsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Shipments record);

    @Update({
        "update shipments",
        "set name = #{name,jdbcType=VARCHAR},",
          "max_price = #{maxPrice,jdbcType=INTEGER},",
          "min_price = #{minPrice,jdbcType=INTEGER},",
          "estimated_max_days = #{estimatedMaxDays,jdbcType=INTEGER},",
          "estimated_min_days = #{estimatedMinDays,jdbcType=INTEGER}",
        "where uuid = #{uuid,jdbcType=BINARY}"
    })
    int updateByPrimaryKey(Shipments record);
}