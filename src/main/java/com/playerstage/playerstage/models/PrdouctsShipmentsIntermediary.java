package com.playerstage.playerstage.models;

import java.util.UUID;

public class PrdouctsShipmentsIntermediary {
    private Integer id;

    private UUID shipmentsId;

    private UUID productsId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UUID getShipmentsId() {
        return shipmentsId;
    }

    public void setShipmentsId(UUID shipmentsId) {
        this.shipmentsId = shipmentsId;
    }

    public UUID getProductsId() {
        return productsId;
    }

    public void setProductsId(UUID productsId) {
        this.productsId = productsId;
    }
}