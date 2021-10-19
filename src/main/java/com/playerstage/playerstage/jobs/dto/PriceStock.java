
package com.playerstage.playerstage.jobs.dto;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allocated_stock",
    "stock_breakdown_by_location"
})
@Generated("jsonschema2pojo")
public class PriceStock {

    @JsonProperty("allocated_stock")
    public Object allocatedStock;
    @JsonProperty("stock_breakdown_by_location")
    public Object stockBreakdownByLocation;

}
