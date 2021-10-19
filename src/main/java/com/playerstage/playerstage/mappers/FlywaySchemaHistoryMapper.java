package com.playerstage.playerstage.mappers;

import com.playerstage.playerstage.models.FlywaySchemaHistory;
import com.playerstage.playerstage.models.FlywaySchemaHistoryExample;
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
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

public interface FlywaySchemaHistoryMapper {
    @SelectProvider(type=FlywaySchemaHistorySqlProvider.class, method="countByExample")
    long countByExample(FlywaySchemaHistoryExample example);

    @DeleteProvider(type=FlywaySchemaHistorySqlProvider.class, method="deleteByExample")
    int deleteByExample(FlywaySchemaHistoryExample example);

    @Delete({
        "delete from flyway_schema_history",
        "where installed_rank = #{installedRank,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer installedRank);

    @Insert({
        "insert into flyway_schema_history (installed_rank, version, ",
        "description, type, ",
        "script, checksum, ",
        "installed_by, installed_on, ",
        "execution_time, success)",
        "values (#{installedRank,jdbcType=INTEGER}, #{version,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR}, #{type,jdbcType=VARCHAR}, ",
        "#{script,jdbcType=VARCHAR}, #{checksum,jdbcType=INTEGER}, ",
        "#{installedBy,jdbcType=VARCHAR}, #{installedOn,jdbcType=TIMESTAMP}, ",
        "#{executionTime,jdbcType=INTEGER}, #{success,jdbcType=TINYINT})"
    })
    int insert(FlywaySchemaHistory record);

    @InsertProvider(type=FlywaySchemaHistorySqlProvider.class, method="insertSelective")
    int insertSelective(FlywaySchemaHistory record);

    @SelectProvider(type=FlywaySchemaHistorySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="installed_rank", property="installedRank", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="version", property="version", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="script", property="script", jdbcType=JdbcType.VARCHAR),
        @Result(column="checksum", property="checksum", jdbcType=JdbcType.INTEGER),
        @Result(column="installed_by", property="installedBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="installed_on", property="installedOn", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="execution_time", property="executionTime", jdbcType=JdbcType.INTEGER),
        @Result(column="success", property="success", jdbcType=JdbcType.TINYINT)
    })
    List<FlywaySchemaHistory> selectByExampleWithRowbounds(FlywaySchemaHistoryExample example, RowBounds rowBounds);

    @SelectProvider(type=FlywaySchemaHistorySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="installed_rank", property="installedRank", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="version", property="version", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="script", property="script", jdbcType=JdbcType.VARCHAR),
        @Result(column="checksum", property="checksum", jdbcType=JdbcType.INTEGER),
        @Result(column="installed_by", property="installedBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="installed_on", property="installedOn", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="execution_time", property="executionTime", jdbcType=JdbcType.INTEGER),
        @Result(column="success", property="success", jdbcType=JdbcType.TINYINT)
    })
    List<FlywaySchemaHistory> selectByExample(FlywaySchemaHistoryExample example);

    @Select({
        "select",
        "installed_rank, version, description, type, script, checksum, installed_by, ",
        "installed_on, execution_time, success",
        "from flyway_schema_history",
        "where installed_rank = #{installedRank,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="installed_rank", property="installedRank", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="version", property="version", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="script", property="script", jdbcType=JdbcType.VARCHAR),
        @Result(column="checksum", property="checksum", jdbcType=JdbcType.INTEGER),
        @Result(column="installed_by", property="installedBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="installed_on", property="installedOn", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="execution_time", property="executionTime", jdbcType=JdbcType.INTEGER),
        @Result(column="success", property="success", jdbcType=JdbcType.TINYINT)
    })
    FlywaySchemaHistory selectByPrimaryKey(Integer installedRank);

    @UpdateProvider(type=FlywaySchemaHistorySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") FlywaySchemaHistory record, @Param("example") FlywaySchemaHistoryExample example);

    @UpdateProvider(type=FlywaySchemaHistorySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") FlywaySchemaHistory record, @Param("example") FlywaySchemaHistoryExample example);

    @UpdateProvider(type=FlywaySchemaHistorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(FlywaySchemaHistory record);

    @Update({
        "update flyway_schema_history",
        "set version = #{version,jdbcType=VARCHAR},",
          "description = #{description,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=VARCHAR},",
          "script = #{script,jdbcType=VARCHAR},",
          "checksum = #{checksum,jdbcType=INTEGER},",
          "installed_by = #{installedBy,jdbcType=VARCHAR},",
          "installed_on = #{installedOn,jdbcType=TIMESTAMP},",
          "execution_time = #{executionTime,jdbcType=INTEGER},",
          "success = #{success,jdbcType=TINYINT}",
        "where installed_rank = #{installedRank,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(FlywaySchemaHistory record);
}