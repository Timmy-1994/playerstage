package com.playerstage.playerstage.mappers;

import static com.playerstage.playerstage.mappers.RolePermissionIntermediaryDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.playerstage.playerstage.models.RolePermissionIntermediary;
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
public interface RolePermissionIntermediaryMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(uuid, roleId, permissionId);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<RolePermissionIntermediary> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<RolePermissionIntermediary> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("RolePermissionIntermediaryResult")
    Optional<RolePermissionIntermediary> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="RolePermissionIntermediaryResult", value = {
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.BINARY, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.BINARY),
        @Result(column="permission_id", property="permissionId", jdbcType=JdbcType.BINARY)
    })
    List<RolePermissionIntermediary> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, rolePermissionIntermediary, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, rolePermissionIntermediary, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(UUID uuid_) {
        return delete(c -> 
            c.where(uuid, isEqualTo(uuid_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(RolePermissionIntermediary record) {
        return MyBatis3Utils.insert(this::insert, record, rolePermissionIntermediary, c ->
            c.map(uuid).toProperty("uuid")
            .map(roleId).toProperty("roleId")
            .map(permissionId).toProperty("permissionId")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<RolePermissionIntermediary> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, rolePermissionIntermediary, c ->
            c.map(uuid).toProperty("uuid")
            .map(roleId).toProperty("roleId")
            .map(permissionId).toProperty("permissionId")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(RolePermissionIntermediary record) {
        return MyBatis3Utils.insert(this::insert, record, rolePermissionIntermediary, c ->
            c.map(uuid).toPropertyWhenPresent("uuid", record::getUuid)
            .map(roleId).toPropertyWhenPresent("roleId", record::getRoleId)
            .map(permissionId).toPropertyWhenPresent("permissionId", record::getPermissionId)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<RolePermissionIntermediary> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, rolePermissionIntermediary, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<RolePermissionIntermediary> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, rolePermissionIntermediary, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<RolePermissionIntermediary> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, rolePermissionIntermediary, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<RolePermissionIntermediary> selectByPrimaryKey(UUID uuid_) {
        return selectOne(c ->
            c.where(uuid, isEqualTo(uuid_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, rolePermissionIntermediary, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(RolePermissionIntermediary record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(uuid).equalTo(record::getUuid)
                .set(roleId).equalTo(record::getRoleId)
                .set(permissionId).equalTo(record::getPermissionId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(RolePermissionIntermediary record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(uuid).equalToWhenPresent(record::getUuid)
                .set(roleId).equalToWhenPresent(record::getRoleId)
                .set(permissionId).equalToWhenPresent(record::getPermissionId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(RolePermissionIntermediary record) {
        return update(c ->
            c.set(roleId).equalTo(record::getRoleId)
            .set(permissionId).equalTo(record::getPermissionId)
            .where(uuid, isEqualTo(record::getUuid))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(RolePermissionIntermediary record) {
        return update(c ->
            c.set(roleId).equalToWhenPresent(record::getRoleId)
            .set(permissionId).equalToWhenPresent(record::getPermissionId)
            .where(uuid, isEqualTo(record::getUuid))
        );
    }
}