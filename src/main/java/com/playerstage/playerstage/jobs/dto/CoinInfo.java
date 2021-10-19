
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
    "spend_cash_unit",
    "coin_earn_items"
})
@Generated("jsonschema2pojo")
public class CoinInfo {

    @JsonProperty("spend_cash_unit")
    public Integer spendCashUnit;
    @JsonProperty("coin_earn_items")
    public List<Object> coinEarnItems = null;

}
