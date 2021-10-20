package com.playerstage.playerstage.models;

import java.util.UUID;
import javax.annotation.Generated;

public class PrdouctsShipmentsIntermediary {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private UUID uuid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private UUID shipmentsId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private UUID productsId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public UUID getUuid() {
        return uuid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public UUID getShipmentsId() {
        return shipmentsId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setShipmentsId(UUID shipmentsId) {
        this.shipmentsId = shipmentsId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public UUID getProductsId() {
        return productsId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setProductsId(UUID productsId) {
        this.productsId = productsId;
    }
}