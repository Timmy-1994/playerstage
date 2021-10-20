package com.playerstage.playerstage.dto;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class ProductResponse {
    String coverImage;
    List<String> imgUrl;
    String brand;
    Date time;
    String description;
    Boolean isPreOrder;
    String name;
    float rating;
    int sold;
    UUID uuid;
}
