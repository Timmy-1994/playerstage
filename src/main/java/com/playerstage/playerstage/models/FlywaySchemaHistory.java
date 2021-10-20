package com.playerstage.playerstage.models;

import java.util.Date;
import javax.annotation.Generated;

public class FlywaySchemaHistory {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer installedRank;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String version;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String description;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String type;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String script;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer checksum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String installedBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date installedOn;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer executionTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Boolean success;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getInstalledRank() {
        return installedRank;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setInstalledRank(Integer installedRank) {
        this.installedRank = installedRank;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getVersion() {
        return version;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getDescription() {
        return description;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getType() {
        return type;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getScript() {
        return script;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setScript(String script) {
        this.script = script == null ? null : script.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getChecksum() {
        return checksum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setChecksum(Integer checksum) {
        this.checksum = checksum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getInstalledBy() {
        return installedBy;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setInstalledBy(String installedBy) {
        this.installedBy = installedBy == null ? null : installedBy.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getInstalledOn() {
        return installedOn;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setInstalledOn(Date installedOn) {
        this.installedOn = installedOn;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getExecutionTime() {
        return executionTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setExecutionTime(Integer executionTime) {
        this.executionTime = executionTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Boolean getSuccess() {
        return success;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSuccess(Boolean success) {
        this.success = success;
    }
}