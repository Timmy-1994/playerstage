package com.playerstage.playerstage.models;

import lombok.Data;
import java.util.UUID;

@Data
public class Product {
    private UUID uuid;
    private String name;
    private String ctime;
    private String utime;
    private String brand;
    private Boolean is_pre_order;
    private Float rate;
    private String description;
    private String model_name;
}
