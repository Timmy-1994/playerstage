package com.playerstage.playerstage.models;

import java.util.UUID;

public class ProductModels {
    private UUID uuid;

    private String name;

    private Integer price;

    private Float discount;

    private Integer totalStock;

    private Integer promoteStock;

    private String imageHash;

    private UUID productsId;

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Integer getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(Integer totalStock) {
        this.totalStock = totalStock;
    }

    public Integer getPromoteStock() {
        return promoteStock;
    }

    public void setPromoteStock(Integer promoteStock) {
        this.promoteStock = promoteStock;
    }

    public String getImageHash() {
        return imageHash;
    }

    public void setImageHash(String imageHash) {
        this.imageHash = imageHash == null ? null : imageHash.trim();
    }

    public UUID getProductsId() {
        return productsId;
    }

    public void setProductsId(UUID productsId) {
        this.productsId = productsId;
    }
}