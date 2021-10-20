package com.playerstage.playerstage.mappers;

import java.sql.JDBCType;
import java.util.UUID;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ProductImagesDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final ProductImages productImages = new ProductImages();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<UUID> uuid = productImages.uuid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Boolean> isCover = productImages.isCover;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> imageHash = productImages.imageHash;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<UUID> productsId = productImages.productsId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class ProductImages extends SqlTable {
        public final SqlColumn<UUID> uuid = column("uuid", JDBCType.BINARY);

        public final SqlColumn<Boolean> isCover = column("is_cover", JDBCType.TINYINT);

        public final SqlColumn<String> imageHash = column("image_hash", JDBCType.VARCHAR);

        public final SqlColumn<UUID> productsId = column("products_id", JDBCType.BINARY);

        public ProductImages() {
            super("product_images");
        }
    }
}