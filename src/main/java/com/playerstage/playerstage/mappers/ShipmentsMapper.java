package com.playerstage.playerstage.mappers;

import static com.playerstage.playerstage.mappers.ShipmentsDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.playerstage.playerstage.models.Shipments;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
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
public interface ShipmentsMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(uuid, name, maxPrice, minPrice, estimatedMaxDays, estimatedMinDays);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Shipments> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Shipments> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ShipmentsResult")
    Optional<Shipments> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ShipmentsResult", value = {
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.BINARY, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="max_price", property="maxPrice", jdbcType=JdbcType.INTEGER),
        @Result(column="min_price", property="minPrice", jdbcType=JdbcType.INTEGER),
        @Result(column="estimated_max_days", property="estimatedMaxDays", jdbcType=JdbcType.INTEGER),
        @Result(column="estimated_min_days", property="estimatedMinDays", jdbcType=JdbcType.INTEGER)
    })
    List<Shipments> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, shipments, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, shipments, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(UUID uuid_) {
        return delete(c -> 
            c.where(uuid, isEqualTo(uuid_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Shipments record) {
        return MyBatis3Utils.insert(this::insert, record, shipments, c ->
            c.map(uuid).toProperty("uuid")
            .map(name).toProperty("name")
            .map(maxPrice).toProperty("maxPrice")
            .map(minPrice).toProperty("minPrice")
            .map(estimatedMaxDays).toProperty("estimatedMaxDays")
            .map(estimatedMinDays).toProperty("estimatedMinDays")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<Shipments> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, shipments, c ->
            c.map(uuid).toProperty("uuid")
            .map(name).toProperty("name")
            .map(maxPrice).toProperty("maxPrice")
            .map(minPrice).toProperty("minPrice")
            .map(estimatedMaxDays).toProperty("estimatedMaxDays")
            .map(estimatedMinDays).toProperty("estimatedMinDays")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Shipments record) {
        return MyBatis3Utils.insert(this::insert, record, shipments, c ->
            c.map(uuid).toPropertyWhenPresent("uuid", record::getUuid)
            .map(name).toPropertyWhenPresent("name", record::getName)
            .map(maxPrice).toPropertyWhenPresent("maxPrice", record::getMaxPrice)
            .map(minPrice).toPropertyWhenPresent("minPrice", record::getMinPrice)
            .map(estimatedMaxDays).toPropertyWhenPresent("estimatedMaxDays", record::getEstimatedMaxDays)
            .map(estimatedMinDays).toPropertyWhenPresent("estimatedMinDays", record::getEstimatedMinDays)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Shipments> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, shipments, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Shipments> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, shipments, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Shipments> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, shipments, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Shipments> selectByPrimaryKey(UUID uuid_) {
        return selectOne(c ->
            c.where(uuid, isEqualTo(uuid_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, shipments, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Shipments record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(uuid).equalTo(record::getUuid)
                .set(name).equalTo(record::getName)
                .set(maxPrice).equalTo(record::getMaxPrice)
                .set(minPrice).equalTo(record::getMinPrice)
                .set(estimatedMaxDays).equalTo(record::getEstimatedMaxDays)
                .set(estimatedMinDays).equalTo(record::getEstimatedMinDays);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Shipments record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(uuid).equalToWhenPresent(record::getUuid)
                .set(name).equalToWhenPresent(record::getName)
                .set(maxPrice).equalToWhenPresent(record::getMaxPrice)
                .set(minPrice).equalToWhenPresent(record::getMinPrice)
                .set(estimatedMaxDays).equalToWhenPresent(record::getEstimatedMaxDays)
                .set(estimatedMinDays).equalToWhenPresent(record::getEstimatedMinDays);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Shipments record) {
        return update(c ->
            c.set(name).equalTo(record::getName)
            .set(maxPrice).equalTo(record::getMaxPrice)
            .set(minPrice).equalTo(record::getMinPrice)
            .set(estimatedMaxDays).equalTo(record::getEstimatedMaxDays)
            .set(estimatedMinDays).equalTo(record::getEstimatedMinDays)
            .where(uuid, isEqualTo(record::getUuid))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Shipments record) {
        return update(c ->
            c.set(name).equalToWhenPresent(record::getName)
            .set(maxPrice).equalToWhenPresent(record::getMaxPrice)
            .set(minPrice).equalToWhenPresent(record::getMinPrice)
            .set(estimatedMaxDays).equalToWhenPresent(record::getEstimatedMaxDays)
            .set(estimatedMinDays).equalToWhenPresent(record::getEstimatedMinDays)
            .where(uuid, isEqualTo(record::getUuid))
        );
    }
}