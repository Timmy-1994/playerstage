
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
"min_spend"
})
@Generated("jsonschema2pojo")
public class ShipmentFreeShipping {

@JsonProperty("min_spend")
public Integer minSpend;

}