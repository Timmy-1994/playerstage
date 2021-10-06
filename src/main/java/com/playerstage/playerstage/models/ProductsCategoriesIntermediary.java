package com.playerstage.playerstage.models;

import java.util.UUID;

public class ProductsCategoriesIntermediary {
    private Integer id;

    private UUID categoriesId;

    private UUID productsId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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