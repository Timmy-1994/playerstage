package com.playerstage.playerstage.mappers;

import static com.playerstage.playerstage.mappers.ProductsDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.playerstage.playerstage.models.Products;
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
public interface ProductsMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(uuid, name, ctime, utime, brand, isPreOrder, rating, description, originItemId, sold, edited);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Products> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Products> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ProductsResult")
    Optional<Products> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ProductsResult", value = {
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.BINARY, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="ctime", property="ctime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utime", property="utime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="brand", property="brand", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_pre_order", property="isPreOrder", jdbcType=JdbcType.TINYINT),
        @Result(column="rating", property="rating", jdbcType=JdbcType.REAL),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="origin_item_id", property="originItemId", jdbcType=JdbcType.VARCHAR),
        @Result(column="sold", property="sold", jdbcType=JdbcType.INTEGER),
        @Result(column="edited", property="edited", jdbcType=JdbcType.TINYINT)
    })
    List<Products> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, products, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, products, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(UUID uuid_) {
        return delete(c -> 
            c.where(uuid, isEqualTo(uuid_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Products record) {
        return MyBatis3Utils.insert(this::insert, record, products, c ->
            c.map(uuid).toProperty("uuid")
            .map(name).toProperty("name")
            .map(ctime).toProperty("ctime")
            .map(utime).toProperty("utime")
            .map(brand).toProperty("brand")
            .map(isPreOrder).toProperty("isPreOrder")
            .map(rating).toProperty("rating")
            .map(description).toProperty("description")
            .map(originItemId).toProperty("originItemId")
            .map(sold).toProperty("sold")
            .map(edited).toProperty("edited")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<Products> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, products, c ->
            c.map(uuid).toProperty("uuid")
            .map(name).toProperty("name")
            .map(ctime).toProperty("ctime")
            .map(utime).toProperty("utime")
            .map(brand).toProperty("brand")
            .map(isPreOrder).toProperty("isPreOrder")
            .map(rating).toProperty("rating")
            .map(description).toProperty("description")
            .map(originItemId).toProperty("originItemId")
            .map(sold).toProperty("sold")
            .map(edited).toProperty("edited")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Products record) {
        return MyBatis3Utils.insert(this::insert, record, products, c ->
            c.map(uuid).toPropertyWhenPresent("uuid", record::getUuid)
            .map(name).toPropertyWhenPresent("name", record::getName)
            .map(ctime).toPropertyWhenPresent("ctime", record::getCtime)
            .map(utime).toPropertyWhenPresent("utime", record::getUtime)
            .map(brand).toPropertyWhenPresent("brand", record::getBrand)
            .map(isPreOrder).toPropertyWhenPresent("isPreOrder", record::getIsPreOrder)
            .map(rating).toPropertyWhenPresent("rating", record::getRating)
            .map(description).toPropertyWhenPresent("description", record::getDescription)
            .map(originItemId).toPropertyWhenPresent("originItemId", record::getOriginItemId)
            .map(sold).toPropertyWhenPresent("sold", record::getSold)
            .map(edited).toPropertyWhenPresent("edited", record::getEdited)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Products> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, products, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Products> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, products, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Products> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, products, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Products> selectByPrimaryKey(UUID uuid_) {
        return selectOne(c ->
            c.where(uuid, isEqualTo(uuid_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, products, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Products record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(uuid).equalTo(record::getUuid)
                .set(name).equalTo(record::getName)
                .set(ctime).equalTo(record::getCtime)
                .set(utime).equalTo(record::getUtime)
                .set(brand).equalTo(record::getBrand)
                .set(isPreOrder).equalTo(record::getIsPreOrder)
                .set(rating).equalTo(record::getRating)
                .set(description).equalTo(record::getDescription)
                .set(originItemId).equalTo(record::getOriginItemId)
                .set(sold).equalTo(record::getSold)
                .set(edited).equalTo(record::getEdited);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Products record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(uuid).equalToWhenPresent(record::getUuid)
                .set(name).equalToWhenPresent(record::getName)
                .set(ctime).equalToWhenPresent(record::getCtime)
                .set(utime).equalToWhenPresent(record::getUtime)
                .set(brand).equalToWhenPresent(record::getBrand)
                .set(isPreOrder).equalToWhenPresent(record::getIsPreOrder)
                .set(rating).equalToWhenPresent(record::getRating)
                .set(description).equalToWhenPresent(record::getDescription)
                .set(originItemId).equalToWhenPresent(record::getOriginItemId)
                .set(sold).equalToWhenPresent(record::getSold)
                .set(edited).equalToWhenPresent(record::getEdited);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Products record) {
        return update(c ->
            c.set(name).equalTo(record::getName)
            .set(ctime).equalTo(record::getCtime)
            .set(utime).equalTo(record::getUtime)
            .set(brand).equalTo(record::getBrand)
            .set(isPreOrder).equalTo(record::getIsPreOrder)
            .set(rating).equalTo(record::getRating)
            .set(description).equalTo(record::getDescription)
            .set(originItemId).equalTo(record::getOriginItemId)
            .set(sold).equalTo(record::getSold)
            .set(edited).equalTo(record::getEdited)
            .where(uuid, isEqualTo(record::getUuid))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Products record) {
        return update(c ->
            c.set(name).equalToWhenPresent(record::getName)
            .set(ctime).equalToWhenPresent(record::getCtime)
            .set(utime).equalToWhenPresent(record::getUtime)
            .set(brand).equalToWhenPresent(record::getBrand)
            .set(isPreOrder).equalToWhenPresent(record::getIsPreOrder)
            .set(rating).equalToWhenPresent(record::getRating)
            .set(description).equalToWhenPresent(record::getDescription)
            .set(originItemId).equalToWhenPresent(record::getOriginItemId)
            .set(sold).equalToWhenPresent(record::getSold)
            .set(edited).equalToWhenPresent(record::getEdited)
            .where(uuid, isEqualTo(record::getUuid))
        );
    }
}