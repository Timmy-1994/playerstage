package com.playerstage.playerstage.models;

import java.util.UUID;

public class PrdouctsShipmentsIntermediary {
    private UUID uuid;

    private UUID shipmentsId;

    private UUID productsId;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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