package com.playerstage.playerstage.mappers;

import java.sql.JDBCType;
import java.util.UUID;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ProductsCategoriesIntermediaryDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final ProductsCategoriesIntermediary productsCategoriesIntermediary = new ProductsCategoriesIntermediary();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<UUID> uuid = productsCategoriesIntermediary.uuid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<UUID> categoriesId = productsCategoriesIntermediary.categoriesId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<UUID> productsId = productsCategoriesIntermediary.productsId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class ProductsCategoriesIntermediary extends SqlTable {
        public final SqlColumn<UUID> uuid = column("uuid", JDBCType.BINARY);

        public final SqlColumn<UUID> categoriesId = column("categories_id", JDBCType.BINARY);

        public final SqlColumn<UUID> productsId = column("products_id", JDBCType.BINARY);

        public ProductsCategoriesIntermediary() {
            super("products_categories_intermediary");
        }
    }
}