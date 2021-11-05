package com.playerstage.playerstage.mappers;

import static com.playerstage.playerstage.mappers.UserDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.playerstage.playerstage.models.User;
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
public interface UserMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(uuid, username, password, name, birthday, sex, phone, email, avatar, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, valid, ctime, utime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<User> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<User> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UserResult")
    Optional<User> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UserResult", value = {
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.BINARY, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.DATE),
        @Result(column="sex", property="sex", jdbcType=JdbcType.TINYINT),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="enabled", property="enabled", jdbcType=JdbcType.TINYINT),
        @Result(column="account_non_expired", property="accountNonExpired", jdbcType=JdbcType.TINYINT),
        @Result(column="credentials_non_expired", property="credentialsNonExpired", jdbcType=JdbcType.TINYINT),
        @Result(column="account_non_locked", property="accountNonLocked", jdbcType=JdbcType.TINYINT),
        @Result(column="valid", property="valid", jdbcType=JdbcType.TINYINT),
        @Result(column="ctime", property="ctime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="utime", property="utime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<User> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, user, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, user, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(UUID uuid_) {
        return delete(c -> 
            c.where(uuid, isEqualTo(uuid_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(User record) {
        return MyBatis3Utils.insert(this::insert, record, user, c ->
            c.map(uuid).toProperty("uuid")
            .map(username).toProperty("username")
            .map(password).toProperty("password")
            .map(name).toProperty("name")
            .map(birthday).toProperty("birthday")
            .map(sex).toProperty("sex")
            .map(phone).toProperty("phone")
            .map(email).toProperty("email")
            .map(avatar).toProperty("avatar")
            .map(enabled).toProperty("enabled")
            .map(accountNonExpired).toProperty("accountNonExpired")
            .map(credentialsNonExpired).toProperty("credentialsNonExpired")
            .map(accountNonLocked).toProperty("accountNonLocked")
            .map(valid).toProperty("valid")
            .map(ctime).toProperty("ctime")
            .map(utime).toProperty("utime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<User> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, user, c ->
            c.map(uuid).toProperty("uuid")
            .map(username).toProperty("username")
            .map(password).toProperty("password")
            .map(name).toProperty("name")
            .map(birthday).toProperty("birthday")
            .map(sex).toProperty("sex")
            .map(phone).toProperty("phone")
            .map(email).toProperty("email")
            .map(avatar).toProperty("avatar")
            .map(enabled).toProperty("enabled")
            .map(accountNonExpired).toProperty("accountNonExpired")
            .map(credentialsNonExpired).toProperty("credentialsNonExpired")
            .map(accountNonLocked).toProperty("accountNonLocked")
            .map(valid).toProperty("valid")
            .map(ctime).toProperty("ctime")
            .map(utime).toProperty("utime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(User record) {
        return MyBatis3Utils.insert(this::insert, record, user, c ->
            c.map(uuid).toPropertyWhenPresent("uuid", record::getUuid)
            .map(username).toPropertyWhenPresent("username", record::getUsername)
            .map(password).toPropertyWhenPresent("password", record::getPassword)
            .map(name).toPropertyWhenPresent("name", record::getName)
            .map(birthday).toPropertyWhenPresent("birthday", record::getBirthday)
            .map(sex).toPropertyWhenPresent("sex", record::getSex)
            .map(phone).toPropertyWhenPresent("phone", record::getPhone)
            .map(email).toPropertyWhenPresent("email", record::getEmail)
            .map(avatar).toPropertyWhenPresent("avatar", record::getAvatar)
            .map(enabled).toPropertyWhenPresent("enabled", record::getEnabled)
            .map(accountNonExpired).toPropertyWhenPresent("accountNonExpired", record::getAccountNonExpired)
            .map(credentialsNonExpired).toPropertyWhenPresent("credentialsNonExpired", record::getCredentialsNonExpired)
            .map(accountNonLocked).toPropertyWhenPresent("accountNonLocked", record::getAccountNonLocked)
            .map(valid).toPropertyWhenPresent("valid", record::getValid)
            .map(ctime).toPropertyWhenPresent("ctime", record::getCtime)
            .map(utime).toPropertyWhenPresent("utime", record::getUtime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<User> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, user, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<User> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, user, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<User> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, user, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<User> selectByPrimaryKey(UUID uuid_) {
        return selectOne(c ->
            c.where(uuid, isEqualTo(uuid_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, user, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(User record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(uuid).equalTo(record::getUuid)
                .set(username).equalTo(record::getUsername)
                .set(password).equalTo(record::getPassword)
                .set(name).equalTo(record::getName)
                .set(birthday).equalTo(record::getBirthday)
                .set(sex).equalTo(record::getSex)
                .set(phone).equalTo(record::getPhone)
                .set(email).equalTo(record::getEmail)
                .set(avatar).equalTo(record::getAvatar)
                .set(enabled).equalTo(record::getEnabled)
                .set(accountNonExpired).equalTo(record::getAccountNonExpired)
                .set(credentialsNonExpired).equalTo(record::getCredentialsNonExpired)
                .set(accountNonLocked).equalTo(record::getAccountNonLocked)
                .set(valid).equalTo(record::getValid)
                .set(ctime).equalTo(record::getCtime)
                .set(utime).equalTo(record::getUtime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(User record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(uuid).equalToWhenPresent(record::getUuid)
                .set(username).equalToWhenPresent(record::getUsername)
                .set(password).equalToWhenPresent(record::getPassword)
                .set(name).equalToWhenPresent(record::getName)
                .set(birthday).equalToWhenPresent(record::getBirthday)
                .set(sex).equalToWhenPresent(record::getSex)
                .set(phone).equalToWhenPresent(record::getPhone)
                .set(email).equalToWhenPresent(record::getEmail)
                .set(avatar).equalToWhenPresent(record::getAvatar)
                .set(enabled).equalToWhenPresent(record::getEnabled)
                .set(accountNonExpired).equalToWhenPresent(record::getAccountNonExpired)
                .set(credentialsNonExpired).equalToWhenPresent(record::getCredentialsNonExpired)
                .set(accountNonLocked).equalToWhenPresent(record::getAccountNonLocked)
                .set(valid).equalToWhenPresent(record::getValid)
                .set(ctime).equalToWhenPresent(record::getCtime)
                .set(utime).equalToWhenPresent(record::getUtime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(User record) {
        return update(c ->
            c.set(username).equalTo(record::getUsername)
            .set(password).equalTo(record::getPassword)
            .set(name).equalTo(record::getName)
            .set(birthday).equalTo(record::getBirthday)
            .set(sex).equalTo(record::getSex)
            .set(phone).equalTo(record::getPhone)
            .set(email).equalTo(record::getEmail)
            .set(avatar).equalTo(record::getAvatar)
            .set(enabled).equalTo(record::getEnabled)
            .set(accountNonExpired).equalTo(record::getAccountNonExpired)
            .set(credentialsNonExpired).equalTo(record::getCredentialsNonExpired)
            .set(accountNonLocked).equalTo(record::getAccountNonLocked)
            .set(valid).equalTo(record::getValid)
            .set(ctime).equalTo(record::getCtime)
            .set(utime).equalTo(record::getUtime)
            .where(uuid, isEqualTo(record::getUuid))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(User record) {
        return update(c ->
            c.set(username).equalToWhenPresent(record::getUsername)
            .set(password).equalToWhenPresent(record::getPassword)
            .set(name).equalToWhenPresent(record::getName)
            .set(birthday).equalToWhenPresent(record::getBirthday)
            .set(sex).equalToWhenPresent(record::getSex)
            .set(phone).equalToWhenPresent(record::getPhone)
            .set(email).equalToWhenPresent(record::getEmail)
            .set(avatar).equalToWhenPresent(record::getAvatar)
            .set(enabled).equalToWhenPresent(record::getEnabled)
            .set(accountNonExpired).equalToWhenPresent(record::getAccountNonExpired)
            .set(credentialsNonExpired).equalToWhenPresent(record::getCredentialsNonExpired)
            .set(accountNonLocked).equalToWhenPresent(record::getAccountNonLocked)
            .set(valid).equalToWhenPresent(record::getValid)
            .set(ctime).equalToWhenPresent(record::getCtime)
            .set(utime).equalToWhenPresent(record::getUtime)
            .where(uuid, isEqualTo(record::getUuid))
        );
    }
}