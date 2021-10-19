
package com.playerstage.playerstage.jobs.dto;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "value",
    "id",
    "is_timestamp",
    "brand_option",
    "val_id"
})
@Generated("jsonschema2pojo")
public class Attribute {

    @JsonProperty("name")
    public String name;
    @JsonProperty("value")
    public String value;
    @JsonProperty("id")
    public Integer id;
    @JsonProperty("is_timestamp")
    public Boolean isTimestamp;
    @JsonProperty("brand_option")
    public Object brandOption;
    @JsonProperty("val_id")
    public Object valId;

}
