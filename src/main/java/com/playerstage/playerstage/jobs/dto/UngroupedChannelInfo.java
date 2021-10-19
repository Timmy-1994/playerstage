
package com.playerstage.playerstage.jobs.dto;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "channel_id",
    "name",
    "min_price",
    "max_price",
    "price_before_discount",
    "is_mask_channel",
    "warning",
    "channel_delivery_info",
    "channel_promotion_infos"
})
@Generated("jsonschema2pojo")
public class UngroupedChannelInfo {

    @JsonProperty("channel_id")
    public Integer channelId;
    @JsonProperty("name")
    public String name;
    @JsonProperty("min_price")
    public Integer minPrice;
    @JsonProperty("max_price")
    public Integer maxPrice;
    @JsonProperty("price_before_discount")
    public Object priceBeforeDiscount;
    @JsonProperty("is_mask_channel")
    public Boolean isMaskChannel;
    @JsonProperty("warning")
    public Warning warning;
    @JsonProperty("channel_delivery_info")
    public ChannelDeliveryInfo channelDeliveryInfo;
    @JsonProperty("channel_promotion_infos")
    public Object channelPromotionInfos;

}
