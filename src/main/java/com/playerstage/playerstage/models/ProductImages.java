package com.playerstage.playerstage.models;

import java.util.UUID;

public class ProductImages {
    private Integer id;

    private Boolean isCover;

    private String imageHash;

    private UUID productsId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIsCover() {
        return isCover;
    }

    public void setIsCover(Boolean isCover) {
        this.isCover = isCover;
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