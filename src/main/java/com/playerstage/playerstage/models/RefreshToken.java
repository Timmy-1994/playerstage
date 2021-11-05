package com.playerstage.playerstage.models;

import java.util.Date;
import java.util.UUID;
import javax.annotation.Generated;

public class RefreshToken {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private UUID uuid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date expire;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String token;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String ip;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private UUID userId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public UUID getUuid() {
        return uuid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getExpire() {
        return expire;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setExpire(Date expire) {
        this.expire = expire;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getToken() {
        return token;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getIp() {
        return ip;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public UUID getUserId() {
        return userId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}