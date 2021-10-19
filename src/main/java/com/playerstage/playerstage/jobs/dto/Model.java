
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
    "itemid",
    "status",
    "current_promotion_reserved_stock",
    "name",
    "promotionid",
    "price",
    "price_stocks",
    "current_promotion_has_reserve_stock",
    "normal_stock",
    "extinfo",
    "price_before_discount",
    "modelid",
    "stock",
    "has_gimmick_tag"
})
@Generated("jsonschema2pojo")
public class Model {

    @JsonProperty("itemid")
    public Long itemid;
    @JsonProperty("status")
    public Integer status;
    @JsonProperty("current_promotion_reserved_stock")
    public Integer currentPromotionReservedStock;
    @JsonProperty("name")
    public String name;
    @JsonProperty("promotionid")
    public Integer promotionid;
    @JsonProperty("price")
    public Long price;
    @JsonProperty("price_stocks")
    public List<PriceStock> priceStocks = null;
    @JsonProperty("current_promotion_has_reserve_stock")
    public Boolean currentPromotionHasReserveStock;
    @JsonProperty("normal_stock")
    public Integer normalStock;
    @JsonProperty("extinfo")
    public Extinfo extinfo;
    @JsonProperty("price_before_discount")
    public Integer priceBeforeDiscount;
    @JsonProperty("modelid")
    public Long modelid;
    @JsonProperty("stock")
    public Integer stock;
    @JsonProperty("has_gimmick_tag")
    public Boolean hasGimmickTag;

}
