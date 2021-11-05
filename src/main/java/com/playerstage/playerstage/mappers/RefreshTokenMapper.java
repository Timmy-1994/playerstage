package com.playerstage.playerstage.mappers;

import static com.playerstage.playerstage.mappers.RefreshTokenDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.playerstage.playerstage.models.RefreshToken;
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
public interface RefreshTokenMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(uuid, expire, token, ip, userId);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<RefreshToken> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<RefreshToken> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("RefreshTokenResult")
    Optional<RefreshToken> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="RefreshTokenResult", value = {
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.BINARY, id=true),
        @Result(column="expire", property="expire", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="token", property="token", jdbcType=JdbcType.VARCHAR),
        @Result(column="ip", property="ip", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BINARY)
    })
    List<RefreshToken> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, refreshToken, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, refreshToken, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(UUID uuid_) {
        return delete(c -> 
            c.where(uuid, isEqualTo(uuid_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(RefreshToken record) {
        return MyBatis3Utils.insert(this::insert, record, refreshToken, c ->
            c.map(uuid).toProperty("uuid")
            .map(expire).toProperty("expire")
            .map(token).toProperty("token")
            .map(ip).toProperty("ip")
            .map(userId).toProperty("userId")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<RefreshToken> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, refreshToken, c ->
            c.map(uuid).toProperty("uuid")
            .map(expire).toProperty("expire")
            .map(token).toProperty("token")
            .map(ip).toProperty("ip")
            .map(userId).toProperty("userId")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(RefreshToken record) {
        return MyBatis3Utils.insert(this::insert, record, refreshToken, c ->
            c.map(uuid).toPropertyWhenPresent("uuid", record::getUuid)
            .map(expire).toPropertyWhenPresent("expire", record::getExpire)
            .map(token).toPropertyWhenPresent("token", record::getToken)
            .map(ip).toPropertyWhenPresent("ip", record::getIp)
            .map(userId).toPropertyWhenPresent("userId", record::getUserId)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<RefreshToken> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, refreshToken, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<RefreshToken> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, refreshToken, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<RefreshToken> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, refreshToken, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<RefreshToken> selectByPrimaryKey(UUID uuid_) {
        return selectOne(c ->
            c.where(uuid, isEqualTo(uuid_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, refreshToken, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(RefreshToken record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(uuid).equalTo(record::getUuid)
                .set(expire).equalTo(record::getExpire)
                .set(token).equalTo(record::getToken)
                .set(ip).equalTo(record::getIp)
                .set(userId).equalTo(record::getUserId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(RefreshToken record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(uuid).equalToWhenPresent(record::getUuid)
                .set(expire).equalToWhenPresent(record::getExpire)
                .set(token).equalToWhenPresent(record::getToken)
                .set(ip).equalToWhenPresent(record::getIp)
                .set(userId).equalToWhenPresent(record::getUserId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(RefreshToken record) {
        return update(c ->
            c.set(expire).equalTo(record::getExpire)
            .set(token).equalTo(record::getToken)
            .set(ip).equalTo(record::getIp)
            .set(userId).equalTo(record::getUserId)
            .where(uuid, isEqualTo(record::getUuid))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(RefreshToken record) {
        return update(c ->
            c.set(expire).equalToWhenPresent(record::getExpire)
            .set(token).equalToWhenPresent(record::getToken)
            .set(ip).equalToWhenPresent(record::getIp)
            .set(userId).equalToWhenPresent(record::getUserId)
            .where(uuid, isEqualTo(record::getUuid))
        );
    }
}