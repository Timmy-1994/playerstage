package com.playerstage.playerstage.models;

import java.util.Date;
import java.util.UUID;

public class Products {
    private UUID uuid;

    private String name;

    private Date ctime;

    private Date utime;

    private String brand;

    private Boolean isPreOrder;

    private Float rating;

    private String description;

    private String originItemId;

    private Integer sold;

    private Boolean edited;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public Boolean getIsPreOrder() {
        return isPreOrder;
    }

    public void setIsPreOrder(Boolean isPreOrder) {
        this.isPreOrder = isPreOrder;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getOriginItemId() {
        return originItemId;
    }

    public void setOriginItemId(String originItemId) {
        this.originItemId = originItemId == null ? null : originItemId.trim();
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public Boolean getEdited() {
        return edited;
    }

    public void setEdited(Boolean edited) {
        this.edited = edited;
    }
}