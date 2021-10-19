
package com.playerstage.playerstage.jobs.dto;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "order_max_purchase_limit",
    "overall_purchase_limit",
    "item_overall_quota",
    "start_date",
    "end_date"
})
@Generated("jsonschema2pojo")
public class OverallPurchaseLimit {

    @JsonProperty("order_max_purchase_limit")
    public Integer orderMaxPurchaseLimit;
    @JsonProperty("overall_purchase_limit")
    public Object overallPurchaseLimit;
    @JsonProperty("item_overall_quota")
    public Object itemOverallQuota;
    @JsonProperty("start_date")
    public Object startDate;
    @JsonProperty("end_date")
    public Object endDate;

}
