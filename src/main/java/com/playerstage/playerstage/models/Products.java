package com.playerstage.playerstage.models;

import java.util.Date;
import java.util.UUID;
import javax.annotation.Generated;

public class Products {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private UUID uuid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date ctime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date utime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String brand;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Boolean isPreOrder;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Float rating;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String description;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String originItemId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer sold;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Boolean edited;

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
    public Date getCtime() {
        return ctime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getUtime() {
        return utime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUtime(Date utime) {
        this.utime = utime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getBrand() {
        return brand;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Boolean getIsPreOrder() {
        return isPreOrder;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setIsPreOrder(Boolean isPreOrder) {
        this.isPreOrder = isPreOrder;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Float getRating() {
        return rating;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRating(Float rating) {
        this.rating = rating;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getDescription() {
        return description;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getOriginItemId() {
        return originItemId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setOriginItemId(String originItemId) {
        this.originItemId = originItemId == null ? null : originItemId.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getSold() {
        return sold;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSold(Integer sold) {
        this.sold = sold;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Boolean getEdited() {
        return edited;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setEdited(Boolean edited) {
        this.edited = edited;
    }
}