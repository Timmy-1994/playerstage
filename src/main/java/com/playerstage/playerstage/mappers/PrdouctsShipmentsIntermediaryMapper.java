package com.playerstage.playerstage.mappers;

import static com.playerstage.playerstage.mappers.PrdouctsShipmentsIntermediaryDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.playerstage.playerstage.models.PrdouctsShipmentsIntermediary;
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
public interface PrdouctsShipmentsIntermediaryMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(uuid, shipmentsId, productsId);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<PrdouctsShipmentsIntermediary> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<PrdouctsShipmentsIntermediary> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PrdouctsShipmentsIntermediaryResult")
    Optional<PrdouctsShipmentsIntermediary> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PrdouctsShipmentsIntermediaryResult", value = {
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.BINARY, id=true),
        @Result(column="shipments_id", property="shipmentsId", jdbcType=JdbcType.BINARY),
        @Result(column="products_id", property="productsId", jdbcType=JdbcType.BINARY)
    })
    List<PrdouctsShipmentsIntermediary> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, prdouctsShipmentsIntermediary, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, prdouctsShipmentsIntermediary, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(UUID uuid_) {
        return delete(c -> 
            c.where(uuid, isEqualTo(uuid_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(PrdouctsShipmentsIntermediary record) {
        return MyBatis3Utils.insert(this::insert, record, prdouctsShipmentsIntermediary, c ->
            c.map(uuid).toProperty("uuid")
            .map(shipmentsId).toProperty("shipmentsId")
            .map(productsId).toProperty("productsId")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<PrdouctsShipmentsIntermediary> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, prdouctsShipmentsIntermediary, c ->
            c.map(uuid).toProperty("uuid")
            .map(shipmentsId).toProperty("shipmentsId")
            .map(productsId).toProperty("productsId")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(PrdouctsShipmentsIntermediary record) {
        return MyBatis3Utils.insert(this::insert, record, prdouctsShipmentsIntermediary, c ->
            c.map(uuid).toPropertyWhenPresent("uuid", record::getUuid)
            .map(shipmentsId).toPropertyWhenPresent("shipmentsId", record::getShipmentsId)
            .map(productsId).toPropertyWhenPresent("productsId", record::getProductsId)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<PrdouctsShipmentsIntermediary> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, prdouctsShipmentsIntermediary, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<PrdouctsShipmentsIntermediary> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, prdouctsShipmentsIntermediary, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<PrdouctsShipmentsIntermediary> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, prdouctsShipmentsIntermediary, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<PrdouctsShipmentsIntermediary> selectByPrimaryKey(UUID uuid_) {
        return selectOne(c ->
            c.where(uuid, isEqualTo(uuid_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, prdouctsShipmentsIntermediary, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(PrdouctsShipmentsIntermediary record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(uuid).equalTo(record::getUuid)
                .set(shipmentsId).equalTo(record::getShipmentsId)
                .set(productsId).equalTo(record::getProductsId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(PrdouctsShipmentsIntermediary record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(uuid).equalToWhenPresent(record::getUuid)
                .set(shipmentsId).equalToWhenPresent(record::getShipmentsId)
                .set(productsId).equalToWhenPresent(record::getProductsId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(PrdouctsShipmentsIntermediary record) {
        return update(c ->
            c.set(shipmentsId).equalTo(record::getShipmentsId)
            .set(productsId).equalTo(record::getProductsId)
            .where(uuid, isEqualTo(record::getUuid))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(PrdouctsShipmentsIntermediary record) {
        return update(c ->
            c.set(shipmentsId).equalToWhenPresent(record::getShipmentsId)
            .set(productsId).equalToWhenPresent(record::getProductsId)
            .where(uuid, isEqualTo(record::getUuid))
        );
    }
}