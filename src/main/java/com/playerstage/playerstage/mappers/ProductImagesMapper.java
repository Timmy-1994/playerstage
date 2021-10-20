package com.playerstage.playerstage.mappers;

import static com.playerstage.playerstage.mappers.ProductImagesDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.playerstage.playerstage.models.ProductImages;
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
public interface ProductImagesMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(uuid, isCover, imageHash, productsId);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<ProductImages> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<ProductImages> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ProductImagesResult")
    Optional<ProductImages> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ProductImagesResult", value = {
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.BINARY, id=true),
        @Result(column="is_cover", property="isCover", jdbcType=JdbcType.TINYINT),
        @Result(column="image_hash", property="imageHash", jdbcType=JdbcType.VARCHAR),
        @Result(column="products_id", property="productsId", jdbcType=JdbcType.BINARY)
    })
    List<ProductImages> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, productImages, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, productImages, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(UUID uuid_) {
        return delete(c -> 
            c.where(uuid, isEqualTo(uuid_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(ProductImages record) {
        return MyBatis3Utils.insert(this::insert, record, productImages, c ->
            c.map(uuid).toProperty("uuid")
            .map(isCover).toProperty("isCover")
            .map(imageHash).toProperty("imageHash")
            .map(productsId).toProperty("productsId")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<ProductImages> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, productImages, c ->
            c.map(uuid).toProperty("uuid")
            .map(isCover).toProperty("isCover")
            .map(imageHash).toProperty("imageHash")
            .map(productsId).toProperty("productsId")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(ProductImages record) {
        return MyBatis3Utils.insert(this::insert, record, productImages, c ->
            c.map(uuid).toPropertyWhenPresent("uuid", record::getUuid)
            .map(isCover).toPropertyWhenPresent("isCover", record::getIsCover)
            .map(imageHash).toPropertyWhenPresent("imageHash", record::getImageHash)
            .map(productsId).toPropertyWhenPresent("productsId", record::getProductsId)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ProductImages> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, productImages, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ProductImages> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, productImages, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ProductImages> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, productImages, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ProductImages> selectByPrimaryKey(UUID uuid_) {
        return selectOne(c ->
            c.where(uuid, isEqualTo(uuid_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, productImages, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(ProductImages record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(uuid).equalTo(record::getUuid)
                .set(isCover).equalTo(record::getIsCover)
                .set(imageHash).equalTo(record::getImageHash)
                .set(productsId).equalTo(record::getProductsId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ProductImages record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(uuid).equalToWhenPresent(record::getUuid)
                .set(isCover).equalToWhenPresent(record::getIsCover)
                .set(imageHash).equalToWhenPresent(record::getImageHash)
                .set(productsId).equalToWhenPresent(record::getProductsId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(ProductImages record) {
        return update(c ->
            c.set(isCover).equalTo(record::getIsCover)
            .set(imageHash).equalTo(record::getImageHash)
            .set(productsId).equalTo(record::getProductsId)
            .where(uuid, isEqualTo(record::getUuid))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(ProductImages record) {
        return update(c ->
            c.set(isCover).equalToWhenPresent(record::getIsCover)
            .set(imageHash).equalToWhenPresent(record::getImageHash)
            .set(productsId).equalToWhenPresent(record::getProductsId)
            .where(uuid, isEqualTo(record::getUuid))
        );
    }
}