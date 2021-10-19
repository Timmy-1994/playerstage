package com.playerstage.playerstage.jobs.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ItemRating {
    @JsonProperty("rating_star")
    public Integer ratingStar;
    @JsonProperty("rating_count")
    public List<Integer> ratingCount = null;
    @JsonProperty("rcount_with_context")
    public Integer rcountWithContext;
    @JsonProperty("rcount_with_image")
    public Integer rcountWithImage;
}
