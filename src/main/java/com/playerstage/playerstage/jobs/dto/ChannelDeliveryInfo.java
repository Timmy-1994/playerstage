
package com.playerstage.playerstage.jobs.dto;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "has_edt",
    "display_mode",
    "estimated_delivery_date_from",
    "estimated_delivery_date_to",
    "estimated_delivery_time_min",
    "estimated_delivery_time_max",
    "delay_message"
})
@Generated("jsonschema2pojo")
public class ChannelDeliveryInfo {

    @JsonProperty("has_edt")
    public Boolean hasEdt;
    @JsonProperty("display_mode")
    public Object displayMode;
    @JsonProperty("estimated_delivery_date_from")
    public Object estimatedDeliveryDateFrom;
    @JsonProperty("estimated_delivery_date_to")
    public Object estimatedDeliveryDateTo;
    @JsonProperty("estimated_delivery_time_min")
    public Object estimatedDeliveryTimeMin;
    @JsonProperty("estimated_delivery_time_max")
    public Object estimatedDeliveryTimeMax;
    @JsonProperty("delay_message")
    public Object delayMessage;

}
