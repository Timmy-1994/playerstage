package com.playerstage.playerstage.dto;

import java.util.List;

import lombok.Data;

@Data
public class ProductRequest {

    private String coverImage;

    private String brand;

    private String description;

    private Boolean isPreOrder;

    private String name;

    private float rating;

    private int sold;

}
