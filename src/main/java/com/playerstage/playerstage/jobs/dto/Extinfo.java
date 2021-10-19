
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
    "tier_index",
    "group_buy_info"
})
@Generated("jsonschema2pojo")
public class Extinfo {

    @JsonProperty("tier_index")
    public List<Integer> tierIndex = null;
    @JsonProperty("group_buy_info")
    public Object groupBuyInfo;

}
