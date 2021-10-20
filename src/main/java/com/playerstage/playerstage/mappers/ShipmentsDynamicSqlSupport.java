package com.playerstage.playerstage.mappers;

import java.sql.JDBCType;
import java.util.UUID;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ShipmentsDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Shipments shipments = new Shipments();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<UUID> uuid = shipments.uuid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> name = shipments.name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> maxPrice = shipments.maxPrice;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> minPrice = shipments.minPrice;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> estimatedMaxDays = shipments.estimatedMaxDays;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> estimatedMinDays = shipments.estimatedMinDays;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Shipments extends SqlTable {
        public final SqlColumn<UUID> uuid = column("uuid", JDBCType.BINARY);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<Integer> maxPrice = column("max_price", JDBCType.INTEGER);

        public final SqlColumn<Integer> minPrice = column("min_price", JDBCType.INTEGER);

        public final SqlColumn<Integer> estimatedMaxDays = column("estimated_max_days", JDBCType.INTEGER);

        public final SqlColumn<Integer> estimatedMinDays = column("estimated_min_days", JDBCType.INTEGER);

        public Shipments() {
            super("shipments");
        }
    }
}