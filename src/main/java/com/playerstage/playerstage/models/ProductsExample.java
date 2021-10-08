package com.playerstage.playerstage.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ProductsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andUuidIsNull() {
            addCriterion("uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(UUID value) {
            addCriterion("uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(UUID value) {
            addCriterion("uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(UUID value) {
            addCriterion("uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(UUID value) {
            addCriterion("uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(UUID value) {
            addCriterion("uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(UUID value) {
            addCriterion("uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<UUID> values) {
            addCriterion("uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<UUID> values) {
            addCriterion("uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(UUID value1, UUID value2) {
            addCriterion("uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(UUID value1, UUID value2) {
            addCriterion("uuid not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNull() {
            addCriterion("ctime is null");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNotNull() {
            addCriterion("ctime is not null");
            return (Criteria) this;
        }

        public Criteria andCtimeEqualTo(Date value) {
            addCriterion("ctime =", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotEqualTo(Date value) {
            addCriterion("ctime <>", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThan(Date value) {
            addCriterion("ctime >", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ctime >=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThan(Date value) {
            addCriterion("ctime <", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThanOrEqualTo(Date value) {
            addCriterion("ctime <=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeIn(List<Date> values) {
            addCriterion("ctime in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotIn(List<Date> values) {
            addCriterion("ctime not in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeBetween(Date value1, Date value2) {
            addCriterion("ctime between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotBetween(Date value1, Date value2) {
            addCriterion("ctime not between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andUtimeIsNull() {
            addCriterion("utime is null");
            return (Criteria) this;
        }

        public Criteria andUtimeIsNotNull() {
            addCriterion("utime is not null");
            return (Criteria) this;
        }

        public Criteria andUtimeEqualTo(Date value) {
            addCriterion("utime =", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeNotEqualTo(Date value) {
            addCriterion("utime <>", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeGreaterThan(Date value) {
            addCriterion("utime >", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("utime >=", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeLessThan(Date value) {
            addCriterion("utime <", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeLessThanOrEqualTo(Date value) {
            addCriterion("utime <=", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeIn(List<Date> values) {
            addCriterion("utime in", values, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeNotIn(List<Date> values) {
            addCriterion("utime not in", values, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeBetween(Date value1, Date value2) {
            addCriterion("utime between", value1, value2, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeNotBetween(Date value1, Date value2) {
            addCriterion("utime not between", value1, value2, "utime");
            return (Criteria) this;
        }

        public Criteria andBrandIsNull() {
            addCriterion("brand is null");
            return (Criteria) this;
        }

        public Criteria andBrandIsNotNull() {
            addCriterion("brand is not null");
            return (Criteria) this;
        }

        public Criteria andBrandEqualTo(String value) {
            addCriterion("brand =", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotEqualTo(String value) {
            addCriterion("brand <>", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThan(String value) {
            addCriterion("brand >", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThanOrEqualTo(String value) {
            addCriterion("brand >=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThan(String value) {
            addCriterion("brand <", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThanOrEqualTo(String value) {
            addCriterion("brand <=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLike(String value) {
            addCriterion("brand like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotLike(String value) {
            addCriterion("brand not like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandIn(List<String> values) {
            addCriterion("brand in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotIn(List<String> values) {
            addCriterion("brand not in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandBetween(String value1, String value2) {
            addCriterion("brand between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotBetween(String value1, String value2) {
            addCriterion("brand not between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andIsPreOrderIsNull() {
            addCriterion("is_pre_order is null");
            return (Criteria) this;
        }

        public Criteria andIsPreOrderIsNotNull() {
            addCriterion("is_pre_order is not null");
            return (Criteria) this;
        }

        public Criteria andIsPreOrderEqualTo(Boolean value) {
            addCriterion("is_pre_order =", value, "isPreOrder");
            return (Criteria) this;
        }

        public Criteria andIsPreOrderNotEqualTo(Boolean value) {
            addCriterion("is_pre_order <>", value, "isPreOrder");
            return (Criteria) this;
        }

        public Criteria andIsPreOrderGreaterThan(Boolean value) {
            addCriterion("is_pre_order >", value, "isPreOrder");
            return (Criteria) this;
        }

        public Criteria andIsPreOrderGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_pre_order >=", value, "isPreOrder");
            return (Criteria) this;
        }

        public Criteria andIsPreOrderLessThan(Boolean value) {
            addCriterion("is_pre_order <", value, "isPreOrder");
            return (Criteria) this;
        }

        public Criteria andIsPreOrderLessThanOrEqualTo(Boolean value) {
            addCriterion("is_pre_order <=", value, "isPreOrder");
            return (Criteria) this;
        }

        public Criteria andIsPreOrderIn(List<Boolean> values) {
            addCriterion("is_pre_order in", values, "isPreOrder");
            return (Criteria) this;
        }

        public Criteria andIsPreOrderNotIn(List<Boolean> values) {
            addCriterion("is_pre_order not in", values, "isPreOrder");
            return (Criteria) this;
        }

        public Criteria andIsPreOrderBetween(Boolean value1, Boolean value2) {
            addCriterion("is_pre_order between", value1, value2, "isPreOrder");
            return (Criteria) this;
        }

        public Criteria andIsPreOrderNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_pre_order not between", value1, value2, "isPreOrder");
            return (Criteria) this;
        }

        public Criteria andRatingIsNull() {
            addCriterion("rating is null");
            return (Criteria) this;
        }

        public Criteria andRatingIsNotNull() {
            addCriterion("rating is not null");
            return (Criteria) this;
        }

        public Criteria andRatingEqualTo(Float value) {
            addCriterion("rating =", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingNotEqualTo(Float value) {
            addCriterion("rating <>", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingGreaterThan(Float value) {
            addCriterion("rating >", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingGreaterThanOrEqualTo(Float value) {
            addCriterion("rating >=", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingLessThan(Float value) {
            addCriterion("rating <", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingLessThanOrEqualTo(Float value) {
            addCriterion("rating <=", value, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingIn(List<Float> values) {
            addCriterion("rating in", values, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingNotIn(List<Float> values) {
            addCriterion("rating not in", values, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingBetween(Float value1, Float value2) {
            addCriterion("rating between", value1, value2, "rating");
            return (Criteria) this;
        }

        public Criteria andRatingNotBetween(Float value1, Float value2) {
            addCriterion("rating not between", value1, value2, "rating");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andOriginItemIdIsNull() {
            addCriterion("origin_item_id is null");
            return (Criteria) this;
        }

        public Criteria andOriginItemIdIsNotNull() {
            addCriterion("origin_item_id is not null");
            return (Criteria) this;
        }

        public Criteria andOriginItemIdEqualTo(String value) {
            addCriterion("origin_item_id =", value, "originItemId");
            return (Criteria) this;
        }

        public Criteria andOriginItemIdNotEqualTo(String value) {
            addCriterion("origin_item_id <>", value, "originItemId");
            return (Criteria) this;
        }

        public Criteria andOriginItemIdGreaterThan(String value) {
            addCriterion("origin_item_id >", value, "originItemId");
            return (Criteria) this;
        }

        public Criteria andOriginItemIdGreaterThanOrEqualTo(String value) {
            addCriterion("origin_item_id >=", value, "originItemId");
            return (Criteria) this;
        }

        public Criteria andOriginItemIdLessThan(String value) {
            addCriterion("origin_item_id <", value, "originItemId");
            return (Criteria) this;
        }

        public Criteria andOriginItemIdLessThanOrEqualTo(String value) {
            addCriterion("origin_item_id <=", value, "originItemId");
            return (Criteria) this;
        }

        public Criteria andOriginItemIdLike(String value) {
            addCriterion("origin_item_id like", value, "originItemId");
            return (Criteria) this;
        }

        public Criteria andOriginItemIdNotLike(String value) {
            addCriterion("origin_item_id not like", value, "originItemId");
            return (Criteria) this;
        }

        public Criteria andOriginItemIdIn(List<String> values) {
            addCriterion("origin_item_id in", values, "originItemId");
            return (Criteria) this;
        }

        public Criteria andOriginItemIdNotIn(List<String> values) {
            addCriterion("origin_item_id not in", values, "originItemId");
            return (Criteria) this;
        }

        public Criteria andOriginItemIdBetween(String value1, String value2) {
            addCriterion("origin_item_id between", value1, value2, "originItemId");
            return (Criteria) this;
        }

        public Criteria andOriginItemIdNotBetween(String value1, String value2) {
            addCriterion("origin_item_id not between", value1, value2, "originItemId");
            return (Criteria) this;
        }

        public Criteria andSoldIsNull() {
            addCriterion("sold is null");
            return (Criteria) this;
        }

        public Criteria andSoldIsNotNull() {
            addCriterion("sold is not null");
            return (Criteria) this;
        }

        public Criteria andSoldEqualTo(Integer value) {
            addCriterion("sold =", value, "sold");
            return (Criteria) this;
        }

        public Criteria andSoldNotEqualTo(Integer value) {
            addCriterion("sold <>", value, "sold");
            return (Criteria) this;
        }

        public Criteria andSoldGreaterThan(Integer value) {
            addCriterion("sold >", value, "sold");
            return (Criteria) this;
        }

        public Criteria andSoldGreaterThanOrEqualTo(Integer value) {
            addCriterion("sold >=", value, "sold");
            return (Criteria) this;
        }

        public Criteria andSoldLessThan(Integer value) {
            addCriterion("sold <", value, "sold");
            return (Criteria) this;
        }

        public Criteria andSoldLessThanOrEqualTo(Integer value) {
            addCriterion("sold <=", value, "sold");
            return (Criteria) this;
        }

        public Criteria andSoldIn(List<Integer> values) {
            addCriterion("sold in", values, "sold");
            return (Criteria) this;
        }

        public Criteria andSoldNotIn(List<Integer> values) {
            addCriterion("sold not in", values, "sold");
            return (Criteria) this;
        }

        public Criteria andSoldBetween(Integer value1, Integer value2) {
            addCriterion("sold between", value1, value2, "sold");
            return (Criteria) this;
        }

        public Criteria andSoldNotBetween(Integer value1, Integer value2) {
            addCriterion("sold not between", value1, value2, "sold");
            return (Criteria) this;
        }

        public Criteria andEditedIsNull() {
            addCriterion("edited is null");
            return (Criteria) this;
        }

        public Criteria andEditedIsNotNull() {
            addCriterion("edited is not null");
            return (Criteria) this;
        }

        public Criteria andEditedEqualTo(Boolean value) {
            addCriterion("edited =", value, "edited");
            return (Criteria) this;
        }

        public Criteria andEditedNotEqualTo(Boolean value) {
            addCriterion("edited <>", value, "edited");
            return (Criteria) this;
        }

        public Criteria andEditedGreaterThan(Boolean value) {
            addCriterion("edited >", value, "edited");
            return (Criteria) this;
        }

        public Criteria andEditedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("edited >=", value, "edited");
            return (Criteria) this;
        }

        public Criteria andEditedLessThan(Boolean value) {
            addCriterion("edited <", value, "edited");
            return (Criteria) this;
        }

        public Criteria andEditedLessThanOrEqualTo(Boolean value) {
            addCriterion("edited <=", value, "edited");
            return (Criteria) this;
        }

        public Criteria andEditedIn(List<Boolean> values) {
            addCriterion("edited in", values, "edited");
            return (Criteria) this;
        }

        public Criteria andEditedNotIn(List<Boolean> values) {
            addCriterion("edited not in", values, "edited");
            return (Criteria) this;
        }

        public Criteria andEditedBetween(Boolean value1, Boolean value2) {
            addCriterion("edited between", value1, value2, "edited");
            return (Criteria) this;
        }

        public Criteria andEditedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("edited not between", value1, value2, "edited");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}