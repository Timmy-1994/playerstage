package com.playerstage.playerstage.mappers;

import com.playerstage.playerstage.models.Shipments;
import com.playerstage.playerstage.models.ShipmentsExample.Criteria;
import com.playerstage.playerstage.models.ShipmentsExample.Criterion;
import com.playerstage.playerstage.models.ShipmentsExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ShipmentsSqlProvider {

    public String countByExample(ShipmentsExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("shipments");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(ShipmentsExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("shipments");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Shipments record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("shipments");
        
        if (record.getUuid() != null) {
            sql.VALUES("uuid", "#{uuid,jdbcType=BINARY}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getMaxPrice() != null) {
            sql.VALUES("max_price", "#{maxPrice,jdbcType=INTEGER}");
        }
        
        if (record.getMinPrice() != null) {
            sql.VALUES("min_price", "#{minPrice,jdbcType=INTEGER}");
        }
        
        if (record.getEstimatedMaxDays() != null) {
            sql.VALUES("estimated_max_days", "#{estimatedMaxDays,jdbcType=INTEGER}");
        }
        
        if (record.getEstimatedMinDays() != null) {
            sql.VALUES("estimated_min_days", "#{estimatedMinDays,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(ShipmentsExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("uuid");
        } else {
            sql.SELECT("uuid");
        }
        sql.SELECT("name");
        sql.SELECT("max_price");
        sql.SELECT("min_price");
        sql.SELECT("estimated_max_days");
        sql.SELECT("estimated_min_days");
        sql.FROM("shipments");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Shipments record = (Shipments) parameter.get("record");
        ShipmentsExample example = (ShipmentsExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("shipments");
        
        if (record.getUuid() != null) {
            sql.SET("uuid = #{record.uuid,jdbcType=BINARY}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getMaxPrice() != null) {
            sql.SET("max_price = #{record.maxPrice,jdbcType=INTEGER}");
        }
        
        if (record.getMinPrice() != null) {
            sql.SET("min_price = #{record.minPrice,jdbcType=INTEGER}");
        }
        
        if (record.getEstimatedMaxDays() != null) {
            sql.SET("estimated_max_days = #{record.estimatedMaxDays,jdbcType=INTEGER}");
        }
        
        if (record.getEstimatedMinDays() != null) {
            sql.SET("estimated_min_days = #{record.estimatedMinDays,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("shipments");
        
        sql.SET("uuid = #{record.uuid,jdbcType=BINARY}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("max_price = #{record.maxPrice,jdbcType=INTEGER}");
        sql.SET("min_price = #{record.minPrice,jdbcType=INTEGER}");
        sql.SET("estimated_max_days = #{record.estimatedMaxDays,jdbcType=INTEGER}");
        sql.SET("estimated_min_days = #{record.estimatedMinDays,jdbcType=INTEGER}");
        
        ShipmentsExample example = (ShipmentsExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Shipments record) {
        SQL sql = new SQL();
        sql.UPDATE("shipments");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getMaxPrice() != null) {
            sql.SET("max_price = #{maxPrice,jdbcType=INTEGER}");
        }
        
        if (record.getMinPrice() != null) {
            sql.SET("min_price = #{minPrice,jdbcType=INTEGER}");
        }
        
        if (record.getEstimatedMaxDays() != null) {
            sql.SET("estimated_max_days = #{estimatedMaxDays,jdbcType=INTEGER}");
        }
        
        if (record.getEstimatedMinDays() != null) {
            sql.SET("estimated_min_days = #{estimatedMinDays,jdbcType=INTEGER}");
        }
        
        sql.WHERE("uuid = #{uuid,jdbcType=BINARY}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, ShipmentsExample example, boolean includeExamplePhrase) {
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