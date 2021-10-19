
package com.playerstage.playerstage.jobs.dto;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "warning_msg"
})
@Generated("jsonschema2pojo")
public class Warning {

    @JsonProperty("type")
    public String type;
    @JsonProperty("warning_msg")
    public String warningMsg;

}
