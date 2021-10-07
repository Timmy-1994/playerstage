package com.playerstage.playerstage.mappers;

import com.playerstage.playerstage.models.Products;
import com.playerstage.playerstage.models.ProductsExample.Criteria;
import com.playerstage.playerstage.models.ProductsExample.Criterion;
import com.playerstage.playerstage.models.ProductsExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ProductsSqlProvider {

    public String countByExample(ProductsExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("products");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(ProductsExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("products");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Products record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("products");
        
        if (record.getUuid() != null) {
            sql.VALUES("uuid", "#{uuid,jdbcType=BINARY}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCtime() != null) {
            sql.VALUES("ctime", "#{ctime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUtime() != null) {
            sql.VALUES("utime", "#{utime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBrand() != null) {
            sql.VALUES("brand", "#{brand,jdbcType=VARCHAR}");
        }
        
        if (record.getIsPreOrder() != null) {
            sql.VALUES("is_pre_order", "#{isPreOrder,jdbcType=TINYINT}");
        }
        
        if (record.getRating() != null) {
            sql.VALUES("rating", "#{rating,jdbcType=REAL}");
        }
        
        if (record.getDescription() != null) {
            sql.VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        if (record.getModelName() != null) {
            sql.VALUES("model_name", "#{modelName,jdbcType=VARCHAR}");
        }
        
        if (record.getFreeShippingMiniSpend() != null) {
            sql.VALUES("free_shipping_mini_spend", "#{freeShippingMiniSpend,jdbcType=INTEGER}");
        }
        
        if (record.getOriginItemId() != null) {
            sql.VALUES("origin_item_id", "#{originItemId,jdbcType=VARCHAR}");
        }
        
        if (record.getSold() != null) {
            sql.VALUES("sold", "#{sold,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(ProductsExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("uuid");
        } else {
            sql.SELECT("uuid");
        }
        sql.SELECT("name");
        sql.SELECT("ctime");
        sql.SELECT("utime");
        sql.SELECT("brand");
        sql.SELECT("is_pre_order");
        sql.SELECT("rating");
        sql.SELECT("description");
        sql.SELECT("model_name");
        sql.SELECT("free_shipping_mini_spend");
        sql.SELECT("origin_item_id");
        sql.SELECT("sold");
        sql.FROM("products");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Products record = (Products) parameter.get("record");
        ProductsExample example = (ProductsExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("products");
        
        if (record.getUuid() != null) {
            sql.SET("uuid = #{record.uuid,jdbcType=BINARY}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getCtime() != null) {
            sql.SET("ctime = #{record.ctime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUtime() != null) {
            sql.SET("utime = #{record.utime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBrand() != null) {
            sql.SET("brand = #{record.brand,jdbcType=VARCHAR}");
        }
        
        if (record.getIsPreOrder() != null) {
            sql.SET("is_pre_order = #{record.isPreOrder,jdbcType=TINYINT}");
        }
        
        if (record.getRating() != null) {
            sql.SET("rating = #{record.rating,jdbcType=REAL}");
        }
        
        if (record.getDescription() != null) {
            sql.SET("description = #{record.description,jdbcType=VARCHAR}");
        }
        
        if (record.getModelName() != null) {
            sql.SET("model_name = #{record.modelName,jdbcType=VARCHAR}");
        }
        
        if (record.getFreeShippingMiniSpend() != null) {
            sql.SET("free_shipping_mini_spend = #{record.freeShippingMiniSpend,jdbcType=INTEGER}");
        }
        
        if (record.getOriginItemId() != null) {
            sql.SET("origin_item_id = #{record.originItemId,jdbcType=VARCHAR}");
        }
        
        if (record.getSold() != null) {
            sql.SET("sold = #{record.sold,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("products");
        
        sql.SET("uuid = #{record.uuid,jdbcType=BINARY}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("ctime = #{record.ctime,jdbcType=TIMESTAMP}");
        sql.SET("utime = #{record.utime,jdbcType=TIMESTAMP}");
        sql.SET("brand = #{record.brand,jdbcType=VARCHAR}");
        sql.SET("is_pre_order = #{record.isPreOrder,jdbcType=TINYINT}");
        sql.SET("rating = #{record.rating,jdbcType=REAL}");
        sql.SET("description = #{record.description,jdbcType=VARCHAR}");
        sql.SET("model_name = #{record.modelName,jdbcType=VARCHAR}");
        sql.SET("free_shipping_mini_spend = #{record.freeShippingMiniSpend,jdbcType=INTEGER}");
        sql.SET("origin_item_id = #{record.originItemId,jdbcType=VARCHAR}");
        sql.SET("sold = #{record.sold,jdbcType=INTEGER}");
        
        ProductsExample example = (ProductsExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Products record) {
        SQL sql = new SQL();
        sql.UPDATE("products");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCtime() != null) {
            sql.SET("ctime = #{ctime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUtime() != null) {
            sql.SET("utime = #{utime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBrand() != null) {
            sql.SET("brand = #{brand,jdbcType=VARCHAR}");
        }
        
        if (record.getIsPreOrder() != null) {
            sql.SET("is_pre_order = #{isPreOrder,jdbcType=TINYINT}");
        }
        
        if (record.getRating() != null) {
            sql.SET("rating = #{rating,jdbcType=REAL}");
        }
        
        if (record.getDescription() != null) {
            sql.SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        if (record.getModelName() != null) {
            sql.SET("model_name = #{modelName,jdbcType=VARCHAR}");
        }
        
        if (record.getFreeShippingMiniSpend() != null) {
            sql.SET("free_shipping_mini_spend = #{freeShippingMiniSpend,jdbcType=INTEGER}");
        }
        
        if (record.getOriginItemId() != null) {
            sql.SET("origin_item_id = #{originItemId,jdbcType=VARCHAR}");
        }
        
        if (record.getSold() != null) {
            sql.SET("sold = #{sold,jdbcType=INTEGER}");
        }
        
        sql.WHERE("uuid = #{uuid,jdbcType=BINARY}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, ProductsExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}