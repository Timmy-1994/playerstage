package com.playerstage.playerstage.dto;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.playerstage.playerstage.models.ProductModels;

import lombok.Data;

@Data
public class ProductResponse {
    UUID uuid;
    String coverImage;
    List<String> imgUrl;
    List<ProductModels> models;
    String brand;
    Date time;
    String description;
    Boolean isPreOrder;
    String name;
    float rating;
    int sold;
}
