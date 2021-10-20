package com.playerstage.playerstage.mappers;

import java.sql.JDBCType;
import java.util.UUID;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class CategoriesDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Categories categories = new Categories();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<UUID> uuid = categories.uuid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> name = categories.name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Categories extends SqlTable {
        public final SqlColumn<UUID> uuid = column("uuid", JDBCType.BINARY);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public Categories() {
            super("categories");
        }
    }
}