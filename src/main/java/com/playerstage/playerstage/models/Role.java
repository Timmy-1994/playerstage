package com.playerstage.playerstage.models;

import java.util.Date;
import java.util.UUID;
import javax.annotation.Generated;

public class Role {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private UUID uuid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Boolean valid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date ctime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date utime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public UUID getUuid() {
        return uuid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getName() {
        return name;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Boolean getValid() {
        return valid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getCtime() {
        return ctime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getUtime() {
        return utime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUtime(Date utime) {
        this.utime = utime;
    }
}