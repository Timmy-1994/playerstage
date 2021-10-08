package com.playerstage.playerstage.models;

import java.util.UUID;

public class ProductsCategoriesIntermediary {
    private UUID uuid;

    private UUID categoriesId;

    private UUID productsId;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(UUID categoriesId) {
        this.categoriesId = categoriesId;
    }

    public UUID getProductsId() {
        return productsId;
    }

    public void setProductsId(UUID productsId) {
        this.productsId = productsId;
    }
}