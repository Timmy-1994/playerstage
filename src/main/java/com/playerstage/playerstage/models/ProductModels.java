package com.playerstage.playerstage.models;

import java.util.UUID;
import javax.annotation.Generated;

public class ProductModels {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private UUID uuid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer price;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Float discount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer totalStock;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer promoteStock;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String imageHash;

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
    public String getName() {
        return name;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getPrice() {
        return price;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPrice(Integer price) {
        this.price = price;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Float getDiscount() {
        return discount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getTotalStock() {
        return totalStock;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTotalStock(Integer totalStock) {
        this.totalStock = totalStock;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getPromoteStock() {
        return promoteStock;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPromoteStock(Integer promoteStock) {
        this.promoteStock = promoteStock;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getImageHash() {
        return imageHash;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setImageHash(String imageHash) {
        this.imageHash = imageHash == null ? null : imageHash.trim();
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