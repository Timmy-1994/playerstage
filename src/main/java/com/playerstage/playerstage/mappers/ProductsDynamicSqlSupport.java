package com.playerstage.playerstage.mappers;

import java.sql.JDBCType;
import java.util.Date;
import java.util.UUID;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ProductsDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Products products = new Products();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<UUID> uuid = products.uuid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> name = products.name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> ctime = products.ctime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> utime = products.utime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> brand = products.brand;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Boolean> isPreOrder = products.isPreOrder;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Float> rating = products.rating;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> description = products.description;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> originItemId = products.originItemId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> sold = products.sold;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Boolean> edited = products.edited;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Products extends SqlTable {
        public final SqlColumn<UUID> uuid = column("uuid", JDBCType.BINARY);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<Date> ctime = column("ctime", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> utime = column("utime", JDBCType.TIMESTAMP);

        public final SqlColumn<String> brand = column("brand", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> isPreOrder = column("is_pre_order", JDBCType.TINYINT);

        public final SqlColumn<Float> rating = column("rating", JDBCType.REAL);

        public final SqlColumn<String> description = column("description", JDBCType.VARCHAR);

        public final SqlColumn<String> originItemId = column("origin_item_id", JDBCType.VARCHAR);

        public final SqlColumn<Integer> sold = column("sold", JDBCType.INTEGER);

        public final SqlColumn<Boolean> edited = column("edited", JDBCType.TINYINT);

        public Products() {
            super("products");
        }
    }
}