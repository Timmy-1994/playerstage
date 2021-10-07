package com.playerstage.playerstage.mappers;

import com.playerstage.playerstage.models.FlywaySchemaHistory;
import com.playerstage.playerstage.models.FlywaySchemaHistoryExample.Criteria;
import com.playerstage.playerstage.models.FlywaySchemaHistoryExample.Criterion;
import com.playerstage.playerstage.models.FlywaySchemaHistoryExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class FlywaySchemaHistorySqlProvider {

    public String countByExample(FlywaySchemaHistoryExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("flyway_schema_history");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(FlywaySchemaHistoryExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("flyway_schema_history");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(FlywaySchemaHistory record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("flyway_schema_history");
        
        if (record.getInstalledRank() != null) {
            sql.VALUES("installed_rank", "#{installedRank,jdbcType=INTEGER}");
        }
        
        if (record.getVersion() != null) {
            sql.VALUES("version", "#{version,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=VARCHAR}");
        }
        
        if (record.getScript() != null) {
            sql.VALUES("script", "#{script,jdbcType=VARCHAR}");
        }
        
        if (record.getChecksum() != null) {
            sql.VALUES("checksum", "#{checksum,jdbcType=INTEGER}");
        }
        
        if (record.getInstalledBy() != null) {
            sql.VALUES("installed_by", "#{installedBy,jdbcType=VARCHAR}");
        }
        
        if (record.getInstalledOn() != null) {
            sql.VALUES("installed_on", "#{installedOn,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExecutionTime() != null) {
            sql.VALUES("execution_time", "#{executionTime,jdbcType=INTEGER}");
        }
        
        if (record.getSuccess() != null) {
            sql.VALUES("success", "#{success,jdbcType=TINYINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(FlywaySchemaHistoryExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("installed_rank");
        } else {
            sql.SELECT("installed_rank");
        }
        sql.SELECT("version");
        sql.SELECT("description");
        sql.SELECT("type");
        sql.SELECT("script");
        sql.SELECT("checksum");
        sql.SELECT("installed_by");
        sql.SELECT("installed_on");
        sql.SELECT("execution_time");
        sql.SELECT("success");
        sql.FROM("flyway_schema_history");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        FlywaySchemaHistory record = (FlywaySchemaHistory) parameter.get("record");
        FlywaySchemaHistoryExample example = (FlywaySchemaHistoryExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("flyway_schema_history");
        
        if (record.getInstalledRank() != null) {
            sql.SET("installed_rank = #{record.installedRank,jdbcType=INTEGER}");
        }
        
        if (record.getVersion() != null) {
            sql.SET("version = #{record.version,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.SET("description = #{record.description,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{record.type,jdbcType=VARCHAR}");
        }
        
        if (record.getScript() != null) {
            sql.SET("script = #{record.script,jdbcType=VARCHAR}");
        }
        
        if (record.getChecksum() != null) {
            sql.SET("checksum = #{record.checksum,jdbcType=INTEGER}");
        }
        
        if (record.getInstalledBy() != null) {
            sql.SET("installed_by = #{record.installedBy,jdbcType=VARCHAR}");
        }
        
        if (record.getInstalledOn() != null) {
            sql.SET("installed_on = #{record.installedOn,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExecutionTime() != null) {
            sql.SET("execution_time = #{record.executionTime,jdbcType=INTEGER}");
        }
        
        if (record.getSuccess() != null) {
            sql.SET("success = #{record.success,jdbcType=TINYINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("flyway_schema_history");
        
        sql.SET("installed_rank = #{record.installedRank,jdbcType=INTEGER}");
        sql.SET("version = #{record.version,jdbcType=VARCHAR}");
        sql.SET("description = #{record.description,jdbcType=VARCHAR}");
        sql.SET("type = #{record.type,jdbcType=VARCHAR}");
        sql.SET("script = #{record.script,jdbcType=VARCHAR}");
        sql.SET("checksum = #{record.checksum,jdbcType=INTEGER}");
        sql.SET("installed_by = #{record.installedBy,jdbcType=VARCHAR}");
        sql.SET("installed_on = #{record.installedOn,jdbcType=TIMESTAMP}");
        sql.SET("execution_time = #{record.executionTime,jdbcType=INTEGER}");
        sql.SET("success = #{record.success,jdbcType=TINYINT}");
        
        FlywaySchemaHistoryExample example = (FlywaySchemaHistoryExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(FlywaySchemaHistory record) {
        SQL sql = new SQL();
        sql.UPDATE("flyway_schema_history");
        
        if (record.getVersion() != null) {
            sql.SET("version = #{version,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=VARCHAR}");
        }
        
        if (record.getScript() != null) {
            sql.SET("script = #{script,jdbcType=VARCHAR}");
        }
        
        if (record.getChecksum() != null) {
            sql.SET("checksum = #{checksum,jdbcType=INTEGER}");
        }
        
        if (record.getInstalledBy() != null) {
            sql.SET("installed_by = #{installedBy,jdbcType=VARCHAR}");
        }
        
        if (record.getInstalledOn() != null) {
            sql.SET("installed_on = #{installedOn,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExecutionTime() != null) {
            sql.SET("execution_time = #{executionTime,jdbcType=INTEGER}");
        }
        
        if (record.getSuccess() != null) {
            sql.SET("success = #{success,jdbcType=TINYINT}");
        }
        
        sql.WHERE("installed_rank = #{installedRank,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, FlywaySchemaHistoryExample example, boolean includeExamplePhrase) {
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