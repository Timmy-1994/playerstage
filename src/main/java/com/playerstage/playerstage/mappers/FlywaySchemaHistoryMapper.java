package com.playerstage.playerstage.mappers;

import static com.playerstage.playerstage.mappers.FlywaySchemaHistoryDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.playerstage.playerstage.models.FlywaySchemaHistory;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface FlywaySchemaHistoryMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(installedRank, version, description, type, script, checksum, installedBy, installedOn, executionTime, success);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<FlywaySchemaHistory> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<FlywaySchemaHistory> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("FlywaySchemaHistoryResult")
    Optional<FlywaySchemaHistory> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="FlywaySchemaHistoryResult", value = {
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
    List<FlywaySchemaHistory> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, flywaySchemaHistory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, flywaySchemaHistory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer installedRank_) {
        return delete(c -> 
            c.where(installedRank, isEqualTo(installedRank_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(FlywaySchemaHistory record) {
        return MyBatis3Utils.insert(this::insert, record, flywaySchemaHistory, c ->
            c.map(installedRank).toProperty("installedRank")
            .map(version).toProperty("version")
            .map(description).toProperty("description")
            .map(type).toProperty("type")
            .map(script).toProperty("script")
            .map(checksum).toProperty("checksum")
            .map(installedBy).toProperty("installedBy")
            .map(installedOn).toProperty("installedOn")
            .map(executionTime).toProperty("executionTime")
            .map(success).toProperty("success")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<FlywaySchemaHistory> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, flywaySchemaHistory, c ->
            c.map(installedRank).toProperty("installedRank")
            .map(version).toProperty("version")
            .map(description).toProperty("description")
            .map(type).toProperty("type")
            .map(script).toProperty("script")
            .map(checksum).toProperty("checksum")
            .map(installedBy).toProperty("installedBy")
            .map(installedOn).toProperty("installedOn")
            .map(executionTime).toProperty("executionTime")
            .map(success).toProperty("success")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(FlywaySchemaHistory record) {
        return MyBatis3Utils.insert(this::insert, record, flywaySchemaHistory, c ->
            c.map(installedRank).toPropertyWhenPresent("installedRank", record::getInstalledRank)
            .map(version).toPropertyWhenPresent("version", record::getVersion)
            .map(description).toPropertyWhenPresent("description", record::getDescription)
            .map(type).toPropertyWhenPresent("type", record::getType)
            .map(script).toPropertyWhenPresent("script", record::getScript)
            .map(checksum).toPropertyWhenPresent("checksum", record::getChecksum)
            .map(installedBy).toPropertyWhenPresent("installedBy", record::getInstalledBy)
            .map(installedOn).toPropertyWhenPresent("installedOn", record::getInstalledOn)
            .map(executionTime).toPropertyWhenPresent("executionTime", record::getExecutionTime)
            .map(success).toPropertyWhenPresent("success", record::getSuccess)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<FlywaySchemaHistory> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, flywaySchemaHistory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<FlywaySchemaHistory> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, flywaySchemaHistory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<FlywaySchemaHistory> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, flywaySchemaHistory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<FlywaySchemaHistory> selectByPrimaryKey(Integer installedRank_) {
        return selectOne(c ->
            c.where(installedRank, isEqualTo(installedRank_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, flywaySchemaHistory, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(FlywaySchemaHistory record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(installedRank).equalTo(record::getInstalledRank)
                .set(version).equalTo(record::getVersion)
                .set(description).equalTo(record::getDescription)
                .set(type).equalTo(record::getType)
                .set(script).equalTo(record::getScript)
                .set(checksum).equalTo(record::getChecksum)
                .set(installedBy).equalTo(record::getInstalledBy)
                .set(installedOn).equalTo(record::getInstalledOn)
                .set(executionTime).equalTo(record::getExecutionTime)
                .set(success).equalTo(record::getSuccess);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(FlywaySchemaHistory record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(installedRank).equalToWhenPresent(record::getInstalledRank)
                .set(version).equalToWhenPresent(record::getVersion)
                .set(description).equalToWhenPresent(record::getDescription)
                .set(type).equalToWhenPresent(record::getType)
                .set(script).equalToWhenPresent(record::getScript)
                .set(checksum).equalToWhenPresent(record::getChecksum)
                .set(installedBy).equalToWhenPresent(record::getInstalledBy)
                .set(installedOn).equalToWhenPresent(record::getInstalledOn)
                .set(executionTime).equalToWhenPresent(record::getExecutionTime)
                .set(success).equalToWhenPresent(record::getSuccess);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(FlywaySchemaHistory record) {
        return update(c ->
            c.set(version).equalTo(record::getVersion)
            .set(description).equalTo(record::getDescription)
            .set(type).equalTo(record::getType)
            .set(script).equalTo(record::getScript)
            .set(checksum).equalTo(record::getChecksum)
            .set(installedBy).equalTo(record::getInstalledBy)
            .set(installedOn).equalTo(record::getInstalledOn)
            .set(executionTime).equalTo(record::getExecutionTime)
            .set(success).equalTo(record::getSuccess)
            .where(installedRank, isEqualTo(record::getInstalledRank))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(FlywaySchemaHistory record) {
        return update(c ->
            c.set(version).equalToWhenPresent(record::getVersion)
            .set(description).equalToWhenPresent(record::getDescription)
            .set(type).equalToWhenPresent(record::getType)
            .set(script).equalToWhenPresent(record::getScript)
            .set(checksum).equalToWhenPresent(record::getChecksum)
            .set(installedBy).equalToWhenPresent(record::getInstalledBy)
            .set(installedOn).equalToWhenPresent(record::getInstalledOn)
            .set(executionTime).equalToWhenPresent(record::getExecutionTime)
            .set(success).equalToWhenPresent(record::getSuccess)
            .where(installedRank, isEqualTo(record::getInstalledRank))
        );
    }
}