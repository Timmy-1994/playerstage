package com.playerstage.playerstage.models;

import java.util.UUID;
import javax.annotation.Generated;

public class Shipments {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private UUID uuid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer maxPrice;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer minPrice;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer estimatedMaxDays;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer estimatedMinDays;

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
    public Integer getMaxPrice() {
        return maxPrice;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getMinPrice() {
        return minPrice;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getEstimatedMaxDays() {
        return estimatedMaxDays;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setEstimatedMaxDays(Integer estimatedMaxDays) {
        this.estimatedMaxDays = estimatedMaxDays;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getEstimatedMinDays() {
        return estimatedMinDays;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setEstimatedMinDays(Integer estimatedMinDays) {
        this.estimatedMinDays = estimatedMinDays;
    }
}