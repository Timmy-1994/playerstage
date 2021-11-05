package com.playerstage.playerstage.models;

import java.util.UUID;
import javax.annotation.Generated;

public class RolePermissionIntermediary {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private UUID uuid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private UUID roleId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private UUID permissionId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public UUID getUuid() {
        return uuid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public UUID getRoleId() {
        return roleId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setRoleId(UUID roleId) {
        this.roleId = roleId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public UUID getPermissionId() {
        return permissionId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPermissionId(UUID permissionId) {
        this.permissionId = permissionId;
    }
}