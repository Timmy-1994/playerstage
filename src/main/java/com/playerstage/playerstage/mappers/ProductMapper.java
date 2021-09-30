package com.playerstage.playerstage.mappers;

import java.util.List;

import com.playerstage.playerstage.models.Product;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {
    @Select(
        "SELECT * FROM products"
    )
    List<Product> findAll();

    @Insert(
        "INSERT INTO products (`uuid`,`name`,`brand`,`is_pre_order`,`rate`,`description`,`model_name`)" +
        "VALUES (#{uuid},#{name},#{brand},#{is_pre_order},#{rate},#{description},#{model_name})"
    )
    Integer addProduct(Product product);
}
