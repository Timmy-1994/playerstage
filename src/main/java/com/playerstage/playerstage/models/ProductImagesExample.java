package com.playerstage.playerstage.models;

import java.util.ArrayList;
import java.util.List;

public class ProductImagesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductImagesExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIsCoverIsNull() {
            addCriterion("is_cover is null");
            return (Criteria) this;
        }

        public Criteria andIsCoverIsNotNull() {
            addCriterion("is_cover is not null");
            return (Criteria) this;
        }

        public Criteria andIsCoverEqualTo(Boolean value) {
            addCriterion("is_cover =", value, "isCover");
            return (Criteria) this;
        }

        public Criteria andIsCoverNotEqualTo(Boolean value) {
            addCriterion("is_cover <>", value, "isCover");
            return (Criteria) this;
        }

        public Criteria andIsCoverGreaterThan(Boolean value) {
            addCriterion("is_cover >", value, "isCover");
            return (Criteria) this;
        }

        public Criteria andIsCoverGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_cover >=", value, "isCover");
            return (Criteria) this;
        }

        public Criteria andIsCoverLessThan(Boolean value) {
            addCriterion("is_cover <", value, "isCover");
            return (Criteria) this;
        }

        public Criteria andIsCoverLessThanOrEqualTo(Boolean value) {
            addCriterion("is_cover <=", value, "isCover");
            return (Criteria) this;
        }

        public Criteria andIsCoverIn(List<Boolean> values) {
            addCriterion("is_cover in", values, "isCover");
            return (Criteria) this;
        }

        public Criteria andIsCoverNotIn(List<Boolean> values) {
            addCriterion("is_cover not in", values, "isCover");
            return (Criteria) this;
        }

        public Criteria andIsCoverBetween(Boolean value1, Boolean value2) {
            addCriterion("is_cover between", value1, value2, "isCover");
            return (Criteria) this;
        }

        public Criteria andIsCoverNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_cover not between", value1, value2, "isCover");
            return (Criteria) this;
        }

        public Criteria andImageHashIsNull() {
            addCriterion("image_hash is null");
            return (Criteria) this;
        }

        public Criteria andImageHashIsNotNull() {
            addCriterion("image_hash is not null");
            return (Criteria) this;
        }

        public Criteria andImageHashEqualTo(String value) {
            addCriterion("image_hash =", value, "imageHash");
            return (Criteria) this;
        }

        public Criteria andImageHashNotEqualTo(String value) {
            addCriterion("image_hash <>", value, "imageHash");
            return (Criteria) this;
        }

        public Criteria andImageHashGreaterThan(String value) {
            addCriterion("image_hash >", value, "imageHash");
            return (Criteria) this;
        }

        public Criteria andImageHashGreaterThanOrEqualTo(String value) {
            addCriterion("image_hash >=", value, "imageHash");
            return (Criteria) this;
        }

        public Criteria andImageHashLessThan(String value) {
            addCriterion("image_hash <", value, "imageHash");
            return (Criteria) this;
        }

        public Criteria andImageHashLessThanOrEqualTo(String value) {
            addCriterion("image_hash <=", value, "imageHash");
            return (Criteria) this;
        }

        public Criteria andImageHashLike(String value) {
            addCriterion("image_hash like", value, "imageHash");
            return (Criteria) this;
        }

        public Criteria andImageHashNotLike(String value) {
            addCriterion("image_hash not like", value, "imageHash");
            return (Criteria) this;
        }

        public Criteria andImageHashIn(List<String> values) {
            addCriterion("image_hash in", values, "imageHash");
            return (Criteria) this;
        }

        public Criteria andImageHashNotIn(List<String> values) {
            addCriterion("image_hash not in", values, "imageHash");
            return (Criteria) this;
        }

        public Criteria andImageHashBetween(String value1, String value2) {
            addCriterion("image_hash between", value1, value2, "imageHash");
            return (Criteria) this;
        }

        public Criteria andImageHashNotBetween(String value1, String value2) {
            addCriterion("image_hash not between", value1, value2, "imageHash");
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