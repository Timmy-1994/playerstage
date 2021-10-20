package com.playerstage.playerstage.mappers;

import static com.playerstage.playerstage.mappers.ProductsCategoriesIntermediaryDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.playerstage.playerstage.models.ProductsCategoriesIntermediary;
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
public interface ProductsCategoriesIntermediaryMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(uuid, categoriesId, productsId);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<ProductsCategoriesIntermediary> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<ProductsCategoriesIntermediary> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ProductsCategoriesIntermediaryResult")
    Optional<ProductsCategoriesIntermediary> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ProductsCategoriesIntermediaryResult", value = {
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.BINARY, id=true),
        @Result(column="categories_id", property="categoriesId", jdbcType=JdbcType.BINARY),
        @Result(column="products_id", property="productsId", jdbcType=JdbcType.BINARY)
    })
    List<ProductsCategoriesIntermediary> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, productsCategoriesIntermediary, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, productsCategoriesIntermediary, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(UUID uuid_) {
        return delete(c -> 
            c.where(uuid, isEqualTo(uuid_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(ProductsCategoriesIntermediary record) {
        return MyBatis3Utils.insert(this::insert, record, productsCategoriesIntermediary, c ->
            c.map(uuid).toProperty("uuid")
            .map(categoriesId).toProperty("categoriesId")
            .map(productsId).toProperty("productsId")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<ProductsCategoriesIntermediary> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, productsCategoriesIntermediary, c ->
            c.map(uuid).toProperty("uuid")
            .map(categoriesId).toProperty("categoriesId")
            .map(productsId).toProperty("productsId")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(ProductsCategoriesIntermediary record) {
        return MyBatis3Utils.insert(this::insert, record, productsCategoriesIntermediary, c ->
            c.map(uuid).toPropertyWhenPresent("uuid", record::getUuid)
            .map(categoriesId).toPropertyWhenPresent("categoriesId", record::getCategoriesId)
            .map(productsId).toPropertyWhenPresent("productsId", record::getProductsId)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ProductsCategoriesIntermediary> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, productsCategoriesIntermediary, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ProductsCategoriesIntermediary> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, productsCategoriesIntermediary, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ProductsCategoriesIntermediary> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, productsCategoriesIntermediary, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ProductsCategoriesIntermediary> selectByPrimaryKey(UUID uuid_) {
        return selectOne(c ->
            c.where(uuid, isEqualTo(uuid_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, productsCategoriesIntermediary, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(ProductsCategoriesIntermediary record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(uuid).equalTo(record::getUuid)
                .set(categoriesId).equalTo(record::getCategoriesId)
                .set(productsId).equalTo(record::getProductsId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ProductsCategoriesIntermediary record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(uuid).equalToWhenPresent(record::getUuid)
                .set(categoriesId).equalToWhenPresent(record::getCategoriesId)
                .set(productsId).equalToWhenPresent(record::getProductsId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(ProductsCategoriesIntermediary record) {
        return update(c ->
            c.set(categoriesId).equalTo(record::getCategoriesId)
            .set(productsId).equalTo(record::getProductsId)
            .where(uuid, isEqualTo(record::getUuid))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(ProductsCategoriesIntermediary record) {
        return update(c ->
            c.set(categoriesId).equalToWhenPresent(record::getCategoriesId)
            .set(productsId).equalToWhenPresent(record::getProductsId)
            .where(uuid, isEqualTo(record::getUuid))
        );
    }
}