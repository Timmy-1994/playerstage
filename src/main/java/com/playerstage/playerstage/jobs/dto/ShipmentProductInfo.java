
package com.playerstage.playerstage.jobs.dto;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"free_shipping",
"shipping_fee_info",
"show_shipping_to"
})
@Generated("jsonschema2pojo")
public class ShipmentProductInfo {

    @JsonProperty("free_shipping")
    public ShipmentFreeShipping freeShipping;
    @JsonProperty("shipping_fee_info")
    public ShippingFeeInfo shippingFeeInfo;
    @JsonProperty("show_shipping_to")
    public Boolean showShippingTo;

}