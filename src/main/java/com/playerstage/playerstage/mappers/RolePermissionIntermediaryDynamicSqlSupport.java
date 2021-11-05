package com.playerstage.playerstage.mappers;

import java.sql.JDBCType;
import java.util.UUID;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class RolePermissionIntermediaryDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final RolePermissionIntermediary rolePermissionIntermediary = new RolePermissionIntermediary();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<UUID> uuid = rolePermissionIntermediary.uuid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<UUID> roleId = rolePermissionIntermediary.roleId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<UUID> permissionId = rolePermissionIntermediary.permissionId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class RolePermissionIntermediary extends SqlTable {
        public final SqlColumn<UUID> uuid = column("uuid", JDBCType.BINARY);

        public final SqlColumn<UUID> roleId = column("role_id", JDBCType.BINARY);

        public final SqlColumn<UUID> permissionId = column("permission_id", JDBCType.BINARY);

        public RolePermissionIntermediary() {
            super("role_permission_intermediary");
        }
    }
}