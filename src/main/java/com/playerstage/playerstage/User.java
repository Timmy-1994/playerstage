package com.playerstage.playerstage;

import io.swagger.annotations.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("使用者基本資訊")
public class User {

    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("年齡")
    private Integer age;
    private String address;
    private String email;

}