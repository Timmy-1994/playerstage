package com.playerstage.playerstage.mappers;

import java.sql.JDBCType;
import java.util.Date;
import java.util.UUID;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class RefreshTokenDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final RefreshToken refreshToken = new RefreshToken();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<UUID> uuid = refreshToken.uuid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> expire = refreshToken.expire;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> token = refreshToken.token;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> ip = refreshToken.ip;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<UUID> userId = refreshToken.userId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class RefreshToken extends SqlTable {
        public final SqlColumn<UUID> uuid = column("uuid", JDBCType.BINARY);

        public final SqlColumn<Date> expire = column("expire", JDBCType.TIMESTAMP);

        public final SqlColumn<String> token = column("token", JDBCType.VARCHAR);

        public final SqlColumn<String> ip = column("ip", JDBCType.VARCHAR);

        public final SqlColumn<UUID> userId = column("user_id", JDBCType.BINARY);

        public RefreshToken() {
            super("refresh_token");
        }
    }
}