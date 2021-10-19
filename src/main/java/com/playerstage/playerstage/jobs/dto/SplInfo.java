
package com.playerstage.playerstage.jobs.dto;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "installment_info",
    "user_credit_info",
    "channel_id",
    "show_spl",
    "show_spl_lite"
})
@Generated("jsonschema2pojo")
public class SplInfo {

    @JsonProperty("installment_info")
    public Object installmentInfo;
    @JsonProperty("user_credit_info")
    public Object userCreditInfo;
    @JsonProperty("channel_id")
    public Object channelId;
    @JsonProperty("show_spl")
    public Boolean showSpl;
    @JsonProperty("show_spl_lite")
    public Boolean showSplLite;

}
