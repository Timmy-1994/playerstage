package com.playerstage.playerstage.dto;

import lombok.Data;

@Data
public class ProductModelRequest {

    private String name;

    private Integer price;

    private Float discount;

    private Integer totalStock;

    private Integer promoteStock;

    private String imageHash;
}
