
package com.playerstage.playerstage.jobs.dto;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "catid",
    "display_name",
    "no_sub",
    "is_default_subcat"
})
@Generated("jsonschema2pojo")
public class FeCategory {

    @JsonProperty("catid")
    public Integer catid;
    @JsonProperty("display_name")
    public String displayName;
    @JsonProperty("no_sub")
    public Boolean noSub;
    @JsonProperty("is_default_subcat")
    public Boolean isDefaultSubcat;

}
