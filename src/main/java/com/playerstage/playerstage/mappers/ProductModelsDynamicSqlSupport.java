package com.playerstage.playerstage.mappers;

import java.sql.JDBCType;
import java.util.UUID;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ProductModelsDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final ProductModels productModels = new ProductModels();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<UUID> uuid = productModels.uuid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> name = productModels.name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> price = productModels.price;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Float> discount = productModels.discount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> totalStock = productModels.totalStock;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> promoteStock = productModels.promoteStock;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> imageHash = productModels.imageHash;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<UUID> productsId = productModels.productsId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class ProductModels extends SqlTable {
        public final SqlColumn<UUID> uuid = column("uuid", JDBCType.BINARY);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<Integer> price = column("price", JDBCType.INTEGER);

        public final SqlColumn<Float> discount = column("discount", JDBCType.REAL);

        public final SqlColumn<Integer> totalStock = column("total_stock", JDBCType.INTEGER);

        public final SqlColumn<Integer> promoteStock = column("promote_stock", JDBCType.INTEGER);

        public final SqlColumn<String> imageHash = column("image_hash", JDBCType.VARCHAR);

        public final SqlColumn<UUID> productsId = column("products_id", JDBCType.BINARY);

        public ProductModels() {
            super("product_models");
        }
    }
}