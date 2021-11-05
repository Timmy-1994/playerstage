package com.playerstage.playerstage.mappers;

import java.sql.JDBCType;
import java.util.UUID;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UserRoleIntermediaryDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final UserRoleIntermediary userRoleIntermediary = new UserRoleIntermediary();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<UUID> uuid = userRoleIntermediary.uuid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<UUID> userId = userRoleIntermediary.userId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<UUID> roleId = userRoleIntermediary.roleId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class UserRoleIntermediary extends SqlTable {
        public final SqlColumn<UUID> uuid = column("uuid", JDBCType.BINARY);

        public final SqlColumn<UUID> userId = column("user_id", JDBCType.BINARY);

        public final SqlColumn<UUID> roleId = column("role_id", JDBCType.BINARY);

        public UserRoleIntermediary() {
            super("user_role_intermediary");
        }
    }
}