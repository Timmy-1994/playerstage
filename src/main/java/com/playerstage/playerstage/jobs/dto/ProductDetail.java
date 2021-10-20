
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
    "shopid",
    "userid",
    "price_max_before_discount",
    "has_lowest_price_guarantee",
    "price_before_discount",
    "price_min_before_discount",
    "exclusive_price_info",
    "hidden_price_display",
    "price_min",
    "price_max",
    "price",
    "stock",
    "discount",
    "historical_sold",
    "sold",
    "show_discount",
    "raw_discount",
    "min_purchase_limit",
    "overall_purchase_limit",
    "pack_size",
    "is_live_streaming_price",
    "name",
    "ctime",
    "item_status",
    "status",
    "condition",
    "catid",
    "description",
    "is_mart",
    "show_shopee_verified_label",
    "size_chart",
    "reference_item_id",
    "brand",
    "item_rating",
    "label_ids",
    "attributes",
    "liked",
    "liked_count",
    "cmt_count",
    "flag",
    "shopee_verified",
    "is_adult",
    "is_preferred_plus_seller",
    "tier_variations",
    "bundle_deal_id",
    "can_use_bundle_deal",
    "add_on_deal_info",
    "bundle_deal_info",
    "can_use_wholesale",
    "wholesale_tier_list",
    "is_group_buy_item",
    "group_buy_info",
    "welcome_package_type",
    "welcome_package_info",
    "tax_code",
    "invoice_option",
    "complaint_policy",
    "images",
    "image",
    "video_info_list",
    "item_type",
    "is_official_shop",
    "show_official_shop_label_in_title",
    "shop_location",
    "coin_earn_label",
    "cb_option",
    "is_pre_order",
    "estimated_days",
    "badge_icon_type",
    "show_free_shipping",
    "shipping_icon_type",
    "cod_flag",
    "show_original_guarantee",
    "categories",
    "other_stock",
    "item_has_post",
    "discount_stock",
    "current_promotion_has_reserve_stock",
    "current_promotion_reserved_stock",
    "normal_stock",
    "brand_id",
    "is_alcohol_product",
    "show_recycling_info",
    "coin_info",
    "models",
    "spl_info",
    "preview_info",
    "fe_categories",
    "presale_info",
    "is_cc_installment_payment_eligible",
    "is_non_cc_installment_payment_eligible",
    "flash_sale",
    "upcoming_flash_sale",
    "deep_discount",
    "has_low_fulfillment_rate",
    "is_partial_fulfilled",
    "makeups",
    "shop_vouchers"
})
@Generated("jsonschema2pojo")
    public class ProductDetail {

        @JsonProperty("itemid")
        public Long itemid;
        @JsonProperty("shopid")
        public Integer shopid;
        @JsonProperty("userid")
        public Integer userid;
        @JsonProperty("price_max_before_discount")
        public Long priceMaxBeforeDiscount;
        @JsonProperty("has_lowest_price_guarantee")
        public Boolean hasLowestPriceGuarantee;
        @JsonProperty("price_before_discount")
        public Integer priceBeforeDiscount;
        @JsonProperty("price_min_before_discount")
        public Integer priceMinBeforeDiscount;
        @JsonProperty("exclusive_price_info")
        public Object exclusivePriceInfo;
        @JsonProperty("hidden_price_display")
        public Object hiddenPriceDisplay;
        @JsonProperty("price_min")
        public Long priceMin;
        @JsonProperty("price_max")
        public Long priceMax;
        @JsonProperty("price")
        public Long price;
        @JsonProperty("stock")
        public Integer stock;
        @JsonProperty("discount")
        public Object discount;
        @JsonProperty("historical_sold")
        public Integer historicalSold;
        @JsonProperty("sold")
        public Integer sold;
        @JsonProperty("show_discount")
        public Integer showDiscount;
        @JsonProperty("raw_discount")
        public Integer rawDiscount;
        @JsonProperty("min_purchase_limit")
        public Integer minPurchaseLimit;
        @JsonProperty("overall_purchase_limit")
        public OverallPurchaseLimit overallPurchaseLimit;
        @JsonProperty("pack_size")
        public Object packSize;
        @JsonProperty("is_live_streaming_price")
        public Object isLiveStreamingPrice;
        @JsonProperty("name")
        public String name;
        @JsonProperty("ctime")
        public Integer ctime;
        @JsonProperty("item_status")
        public String itemStatus;
        @JsonProperty("status")
        public Integer status;
        @JsonProperty("condition")
        public Integer condition;
        @JsonProperty("catid")
        public Integer catid;
        @JsonProperty("description")
        public String description;
        @JsonProperty("is_mart")
        public Boolean isMart;
        @JsonProperty("show_shopee_verified_label")
        public Boolean showShopeeVerifiedLabel;
        @JsonProperty("size_chart")
        public Object sizeChart;
        @JsonProperty("reference_item_id")
        public String referenceItemId;
        @JsonProperty("brand")
        public String brand;
        @JsonProperty("item_rating")
        public ItemRating itemRating;
        @JsonProperty("label_ids")
        public Object labelIds;
        @JsonProperty("attributes")
        public List<Attribute> attributes = null;
        @JsonProperty("liked")
        public Boolean liked;
        @JsonProperty("liked_count")
        public Integer likedCount;
        @JsonProperty("cmt_count")
        public Integer cmtCount;
        @JsonProperty("flag")
        public Integer flag;
        @JsonProperty("shopee_verified")
        public Boolean shopeeVerified;
        @JsonProperty("is_adult")
        public Boolean isAdult;
        @JsonProperty("is_preferred_plus_seller")
        public Boolean isPreferredPlusSeller;
        @JsonProperty("tier_variations")
        public List<TierVariation> tierVariations = null;
        @JsonProperty("bundle_deal_id")
        public Integer bundleDealId;
        @JsonProperty("can_use_bundle_deal")
        public Boolean canUseBundleDeal;
        @JsonProperty("add_on_deal_info")
        public Object addOnDealInfo;
        @JsonProperty("bundle_deal_info")
        public Object bundleDealInfo;
        @JsonProperty("can_use_wholesale")
        public Boolean canUseWholesale;
        @JsonProperty("wholesale_tier_list")
        public List<Object> wholesaleTierList = null;
        @JsonProperty("is_group_buy_item")
        public Object isGroupBuyItem;
        @JsonProperty("group_buy_info")
        public Object groupBuyInfo;
        @JsonProperty("welcome_package_type")
        public Integer welcomePackageType;
        @JsonProperty("welcome_package_info")
        public Object welcomePackageInfo;
        @JsonProperty("tax_code")
        public Object taxCode;
        @JsonProperty("invoice_option")
        public Object invoiceOption;
        @JsonProperty("complaint_policy")
        public Object complaintPolicy;
        @JsonProperty("images")
        public List<String> images = null;
        @JsonProperty("image")
        public String image;
        @JsonProperty("video_info_list")
        public Object videoInfoList;
        @JsonProperty("item_type")
        public Integer itemType;
        @JsonProperty("is_official_shop")
        public Boolean isOfficialShop;
        @JsonProperty("show_official_shop_label_in_title")
        public Boolean showOfficialShopLabelInTitle;
        @JsonProperty("shop_location")
        public String shopLocation;
        @JsonProperty("coin_earn_label")
        public Object coinEarnLabel;
        @JsonProperty("cb_option")
        public Integer cbOption;
        @JsonProperty("is_pre_order")
        public Boolean isPreOrder;
        @JsonProperty("estimated_days")
        public Integer estimatedDays;
        @JsonProperty("badge_icon_type")
        public Integer badgeIconType;
        @JsonProperty("show_free_shipping")
        public Boolean showFreeShipping;
        @JsonProperty("shipping_icon_type")
        public Integer shippingIconType;
        @JsonProperty("cod_flag")
        public Integer codFlag;
        @JsonProperty("show_original_guarantee")
        public Boolean showOriginalGuarantee;
        @JsonProperty("categories")
        public List<Category> categories = null;
        @JsonProperty("other_stock")
        public Integer otherStock;
        @JsonProperty("item_has_post")
        public Boolean itemHasPost;
        @JsonProperty("discount_stock")
        public Integer discountStock;
        @JsonProperty("current_promotion_has_reserve_stock")
        public Boolean currentPromotionHasReserveStock;
        @JsonProperty("current_promotion_reserved_stock")
        public Integer currentPromotionReservedStock;
        @JsonProperty("normal_stock")
        public Integer normalStock;
        @JsonProperty("brand_id")
        public Integer brandId;
        @JsonProperty("is_alcohol_product")
        public Boolean isAlcoholProduct;
        @JsonProperty("show_recycling_info")
        public Boolean showRecyclingInfo;
        @JsonProperty("coin_info")
        public CoinInfo coinInfo;
        @JsonProperty("models")
        public List<Model> models = null;
        @JsonProperty("spl_info")
        public SplInfo splInfo;
        @JsonProperty("preview_info")
        public Object previewInfo;
        @JsonProperty("fe_categories")
        public List<FeCategory> feCategories = null;
        @JsonProperty("presale_info")
        public Object presaleInfo;
        @JsonProperty("is_cc_installment_payment_eligible")
        public Boolean isCcInstallmentPaymentEligible;
        @JsonProperty("is_non_cc_installment_payment_eligible")
        public Boolean isNonCcInstallmentPaymentEligible;
        @JsonProperty("flash_sale")
        public Object flashSale;
        @JsonProperty("upcoming_flash_sale")
        public Object upcomingFlashSale;
        @JsonProperty("deep_discount")
        public Object deepDiscount;
        @JsonProperty("has_low_fulfillment_rate")
        public Boolean hasLowFulfillmentRate;
        @JsonProperty("is_partial_fulfilled")
        public Boolean isPartialFulfilled;
        @JsonProperty("makeups")
        public Object makeups;
        @JsonProperty("shop_vouchers")
        public Object shopVouchers;
}