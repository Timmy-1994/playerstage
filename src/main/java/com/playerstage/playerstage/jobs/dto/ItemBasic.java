package com.playerstage.playerstage.jobs.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ItemBasic {
    @JsonProperty("itemid")
    public Long itemid;
    @JsonProperty("shopid")
    public Long shopid;
    @JsonProperty("name")
    public String name;
    @JsonProperty("label_ids")
    public Object labelIds;
    @JsonProperty("image")
    public String image;
    @JsonProperty("images")
    public List<String> images = null;
    @JsonProperty("currency")
    public String currency;
    @JsonProperty("stock")
    public Integer stock;
    @JsonProperty("status")
    public Integer status;
    @JsonProperty("ctime")
    public Integer ctime;
    @JsonProperty("sold")
    public Integer sold;
    @JsonProperty("historical_sold")
    public Integer historicalSold;
    @JsonProperty("liked")
    public Boolean liked;
    @JsonProperty("liked_count")
    public Integer likedCount;
    @JsonProperty("view_count")
    public Integer viewCount;
    @JsonProperty("catid")
    public Integer catid;
    @JsonProperty("brand")
    public String brand;
    @JsonProperty("cmt_count")
    public Integer cmtCount;
    @JsonProperty("flag")
    public Integer flag;
    @JsonProperty("cb_option")
    public Integer cbOption;
    @JsonProperty("item_status")
    public String itemStatus;
    @JsonProperty("price")
    public Long price;
    @JsonProperty("price_min")
    public Long priceMin;
    @JsonProperty("price_max")
    public Long priceMax;
    @JsonProperty("price_min_before_discount")
    public Integer priceMinBeforeDiscount;
    @JsonProperty("price_max_before_discount")
    public Integer priceMaxBeforeDiscount;
    @JsonProperty("hidden_price_display")
    public Object hiddenPriceDisplay;
    @JsonProperty("price_before_discount")
    public Integer priceBeforeDiscount;
    @JsonProperty("has_lowest_price_guarantee")
    public Boolean hasLowestPriceGuarantee;
    @JsonProperty("show_discount")
    public Integer showDiscount;
    @JsonProperty("raw_discount")
    public Integer rawDiscount;
    @JsonProperty("discount")
    public Object discount;
    @JsonProperty("is_category_failed")
    public Boolean isCategoryFailed;
    @JsonProperty("size_chart")
    public Object sizeChart;
    @JsonProperty("video_info_list")
    public Object videoInfoList;
    @JsonProperty("tier_variations")
    public List<TierVariation> tierVariations = null;
    @JsonProperty("item_rating")
    public ItemRating itemRating;
    @JsonProperty("item_type")
    public Integer itemType;
    @JsonProperty("reference_item_id")
    public String referenceItemId;
    @JsonProperty("transparent_background_image")
    public String transparentBackgroundImage;
    @JsonProperty("is_adult")
    public Boolean isAdult;
    @JsonProperty("badge_icon_type")
    public Integer badgeIconType;
    @JsonProperty("shopee_verified")
    public Boolean shopeeVerified;
    @JsonProperty("is_official_shop")
    public Boolean isOfficialShop;
    @JsonProperty("show_official_shop_label")
    public Boolean showOfficialShopLabel;
    @JsonProperty("show_shopee_verified_label")
    public Boolean showShopeeVerifiedLabel;
    @JsonProperty("show_official_shop_label_in_title")
    public Boolean showOfficialShopLabelInTitle;
    @JsonProperty("is_cc_installment_payment_eligible")
    public Boolean isCcInstallmentPaymentEligible;
    @JsonProperty("is_non_cc_installment_payment_eligible")
    public Boolean isNonCcInstallmentPaymentEligible;
    @JsonProperty("coin_earn_label")
    public Object coinEarnLabel;
    @JsonProperty("show_free_shipping")
    public Boolean showFreeShipping;
    @JsonProperty("preview_info")
    public Object previewInfo;
    @JsonProperty("coin_info")
    public Object coinInfo;
    @JsonProperty("exclusive_price_info")
    public Object exclusivePriceInfo;
    @JsonProperty("bundle_deal_id")
    public Integer bundleDealId;
    @JsonProperty("can_use_bundle_deal")
    public Boolean canUseBundleDeal;
    @JsonProperty("bundle_deal_info")
    public Object bundleDealInfo;
    @JsonProperty("is_group_buy_item")
    public Object isGroupBuyItem;
    @JsonProperty("has_group_buy_stock")
    public Object hasGroupBuyStock;
    @JsonProperty("group_buy_info")
    public Object groupBuyInfo;
    @JsonProperty("welcome_package_type")
    public Integer welcomePackageType;
    @JsonProperty("welcome_package_info")
    public Object welcomePackageInfo;
    @JsonProperty("add_on_deal_info")
    public Object addOnDealInfo;
    @JsonProperty("can_use_wholesale")
    public Boolean canUseWholesale;
    @JsonProperty("is_preferred_plus_seller")
    public Boolean isPreferredPlusSeller;
    @JsonProperty("shop_location")
    public String shopLocation;
    @JsonProperty("has_model_with_available_shopee_stock")
    public Boolean hasModelWithAvailableShopeeStock;
    @JsonProperty("voucher_info")
    public Object voucherInfo;
    @JsonProperty("can_use_cod")
    public Boolean canUseCod;
    @JsonProperty("is_on_flash_sale")
    public Boolean isOnFlashSale;
    @JsonProperty("spl_installment_tenure")
    public Object splInstallmentTenure;
    @JsonProperty("is_live_streaming_price")
    public Object isLiveStreamingPrice;
    @JsonProperty("is_mart")
    public Boolean isMart;
    @JsonProperty("pack_size")
    public Object packSize;
    @JsonProperty("deep_discount_skin")
    public Object deepDiscountSkin;
}
