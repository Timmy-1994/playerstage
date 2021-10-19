package com.playerstage.playerstage.jobs.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TierVariation {
    @JsonProperty("name")
    public String name;
    @JsonProperty("options")
    public List<String> options = null;
    @JsonProperty("images")
    public List<String> images = null;
    @JsonProperty("properties")
    public List<Object> properties = null;
    @JsonProperty("type")
    public Integer type;
}
