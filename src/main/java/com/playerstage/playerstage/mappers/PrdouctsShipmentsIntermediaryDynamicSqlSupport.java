package com.playerstage.playerstage.mappers;

import java.sql.JDBCType;
import java.util.UUID;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class PrdouctsShipmentsIntermediaryDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final PrdouctsShipmentsIntermediary prdouctsShipmentsIntermediary = new PrdouctsShipmentsIntermediary();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<UUID> uuid = prdouctsShipmentsIntermediary.uuid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<UUID> shipmentsId = prdouctsShipmentsIntermediary.shipmentsId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<UUID> productsId = prdouctsShipmentsIntermediary.productsId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class PrdouctsShipmentsIntermediary extends SqlTable {
        public final SqlColumn<UUID> uuid = column("uuid", JDBCType.BINARY);

        public final SqlColumn<UUID> shipmentsId = column("shipments_id", JDBCType.BINARY);

        public final SqlColumn<UUID> productsId = column("products_id", JDBCType.BINARY);

        public PrdouctsShipmentsIntermediary() {
            super("prdoucts_shipments_intermediary");
        }
    }
}