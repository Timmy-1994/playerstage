package com.playerstage.playerstage.mappers;

import com.playerstage.playerstage.models.ProductModels;
import com.playerstage.playerstage.models.ProductModelsExample.Criteria;
import com.playerstage.playerstage.models.ProductModelsExample.Criterion;
import com.playerstage.playerstage.models.ProductModelsExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ProductModelsSqlProvider {

    public String countByExample(ProductModelsExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("product_models");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(ProductModelsExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("product_models");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(ProductModels record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("product_models");
        
        if (record.getUuid() != null) {
            sql.VALUES("uuid", "#{uuid,jdbcType=BINARY}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getPrice() != null) {
            sql.VALUES("price", "#{price,jdbcType=INTEGER}");
        }
        
        if (record.getDiscount() != null) {
            sql.VALUES("discount", "#{discount,jdbcType=REAL}");
        }
        
        if (record.getTotalStock() != null) {
            sql.VALUES("total_stock", "#{totalStock,jdbcType=INTEGER}");
        }
        
        if (record.getPromoteStock() != null) {
            sql.VALUES("promote_stock", "#{promoteStock,jdbcType=INTEGER}");
        }
        
        if (record.getImageHash() != null) {
            sql.VALUES("image_hash", "#{imageHash,jdbcType=VARCHAR}");
        }
        
        if (record.getProductsId() != null) {
            sql.VALUES("products_id", "#{productsId,jdbcType=BINARY}");
        }
        
        return sql.toString();
    }

    public String selectByExampleWithBLOBs(ProductModelsExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("uuid");
        } else {
            sql.SELECT("uuid");
        }
        sql.SELECT("name");
        sql.SELECT("price");
        sql.SELECT("discount");
        sql.SELECT("total_stock");
        sql.SELECT("promote_stock");
        sql.SELECT("image_hash");
        sql.SELECT("products_id");
        sql.FROM("product_models");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(ProductModelsExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("uuid");
        } else {
            sql.SELECT("uuid");
        }
        sql.SELECT("name");
        sql.SELECT("price");
        sql.SELECT("discount");
        sql.SELECT("total_stock");
        sql.SELECT("promote_stock");
        sql.SELECT("image_hash");
        sql.FROM("product_models");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ProductModels record = (ProductModels) parameter.get("record");
        ProductModelsExample example = (ProductModelsExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("product_models");
        
        if (record.getUuid() != null) {
            sql.SET("uuid = #{record.uuid,jdbcType=BINARY}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getPrice() != null) {
            sql.SET("price = #{record.price,jdbcType=INTEGER}");
        }
        
        if (record.getDiscount() != null) {
            sql.SET("discount = #{record.discount,jdbcType=REAL}");
        }
        
        if (record.getTotalStock() != null) {
            sql.SET("total_stock = #{record.totalStock,jdbcType=INTEGER}");
        }
        
        if (record.getPromoteStock() != null) {
            sql.SET("promote_stock = #{record.promoteStock,jdbcType=INTEGER}");
        }
        
        if (record.getImageHash() != null) {
            sql.SET("image_hash = #{record.imageHash,jdbcType=VARCHAR}");
        }
        
        if (record.getProductsId() != null) {
            sql.SET("products_id = #{record.productsId,jdbcType=BINARY}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("product_models");
        
        sql.SET("uuid = #{record.uuid,jdbcType=BINARY}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("price = #{record.price,jdbcType=INTEGER}");
        sql.SET("discount = #{record.discount,jdbcType=REAL}");
        sql.SET("total_stock = #{record.totalStock,jdbcType=INTEGER}");
        sql.SET("promote_stock = #{record.promoteStock,jdbcType=INTEGER}");
        sql.SET("image_hash = #{record.imageHash,jdbcType=VARCHAR}");
        sql.SET("products_id = #{record.productsId,jdbcType=BINARY}");
        
        ProductModelsExample example = (ProductModelsExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("product_models");
        
        sql.SET("uuid = #{record.uuid,jdbcType=BINARY}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("price = #{record.price,jdbcType=INTEGER}");
        sql.SET("discount = #{record.discount,jdbcType=REAL}");
        sql.SET("total_stock = #{record.totalStock,jdbcType=INTEGER}");
        sql.SET("promote_stock = #{record.promoteStock,jdbcType=INTEGER}");
        sql.SET("image_hash = #{record.imageHash,jdbcType=VARCHAR}");
        
        ProductModelsExample example = (ProductModelsExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ProductModels record) {
        SQL sql = new SQL();
        sql.UPDATE("product_models");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getPrice() != null) {
            sql.SET("price = #{price,jdbcType=INTEGER}");
        }
        
        if (record.getDiscount() != null) {
            sql.SET("discount = #{discount,jdbcType=REAL}");
        }
        
        if (record.getTotalStock() != null) {
            sql.SET("total_stock = #{totalStock,jdbcType=INTEGER}");
        }
        
        if (record.getPromoteStock() != null) {
            sql.SET("promote_stock = #{promoteStock,jdbcType=INTEGER}");
        }
        
        if (record.getImageHash() != null) {
            sql.SET("image_hash = #{imageHash,jdbcType=VARCHAR}");
        }
        
        if (record.getProductsId() != null) {
            sql.SET("products_id = #{productsId,jdbcType=BINARY}");
        }
        
        sql.WHERE("uuid = #{uuid,jdbcType=BINARY}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, ProductModelsExample example, boolean includeExamplePhrase) {
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