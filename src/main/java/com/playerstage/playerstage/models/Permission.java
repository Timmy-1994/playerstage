package com.playerstage.playerstage.models;

import java.util.UUID;
import javax.annotation.Generated;

public class Permission {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private UUID uuid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String permission;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public UUID getUuid() {
        return uuid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getPermission() {
        return permission;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }
}