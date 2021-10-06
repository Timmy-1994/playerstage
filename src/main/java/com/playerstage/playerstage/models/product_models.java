package com.playerstage.playerstage.models;

import java.io.Serializable;

public class product_models implements Serializable {
    private byte[] uuid;

    private String name;

    private Integer price;

    private Float discount;

    private Integer totalStock;

    private Integer promoteStock;

    private Integer sold;

    private byte[] productsId;

    private static final long serialVersionUID = 1L;

    public byte[] getUuid() {
        return uuid;
    }

    public void setUuid(byte[] uuid) {
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

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public byte[] getProductsId() {
        return productsId;
    }

    public void setProductsId(byte[] productsId) {
        this.productsId = productsId;
    }
}