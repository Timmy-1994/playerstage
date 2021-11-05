package com.playerstage.playerstage.mappers;

import java.sql.JDBCType;
import java.util.Date;
import java.util.UUID;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class RoleDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Role role = new Role();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<UUID> uuid = role.uuid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> name = role.name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Boolean> valid = role.valid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> ctime = role.ctime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> utime = role.utime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Role extends SqlTable {
        public final SqlColumn<UUID> uuid = column("uuid", JDBCType.BINARY);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> valid = column("valid", JDBCType.TINYINT);

        public final SqlColumn<Date> ctime = column("ctime", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> utime = column("utime", JDBCType.TIMESTAMP);

        public Role() {
            super("role");
        }
    }
}