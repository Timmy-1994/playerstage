package com.playerstage.playerstage.models;

import java.util.UUID;
import javax.annotation.Generated;

public class ProductImages {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private UUID uuid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Boolean isCover;

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
    public Boolean getIsCover() {
        return isCover;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setIsCover(Boolean isCover) {
        this.isCover = isCover;
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