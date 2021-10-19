
package com.playerstage.playerstage.jobs.dto;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "min_price",
    "max_price",
    "shipping_icon_type",
    "warning"
})
@Generated("jsonschema2pojo")
public class ShippingFeeInfo {

    @JsonProperty("min_price")
    public Object minPrice;
    @JsonProperty("max_price")
    public Object maxPrice;
    @JsonProperty("shipping_icon_type")
    public Integer shippingIconType;
    @JsonProperty("warning")
    public Warning warning;

}
