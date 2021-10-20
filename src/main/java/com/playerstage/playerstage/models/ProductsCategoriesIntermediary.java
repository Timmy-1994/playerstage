package com.playerstage.playerstage.models;

import java.util.UUID;
import javax.annotation.Generated;

public class ProductsCategoriesIntermediary {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private UUID uuid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private UUID categoriesId;

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
    public UUID getCategoriesId() {
        return categoriesId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCategoriesId(UUID categoriesId) {
        this.categoriesId = categoriesId;
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