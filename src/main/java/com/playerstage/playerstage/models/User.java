package com.playerstage.playerstage.models;

import java.util.Date;
import java.util.UUID;
import javax.annotation.Generated;

public class User {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private UUID uuid;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String username;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String password;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date birthday;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Boolean sex;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String phone;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String email;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String avatar;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Boolean enabled;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Boolean accountNonExpired;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Boolean credentialsNonExpired;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Boolean accountNonLocked;

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
    public String getUsername() {
        return username;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getPassword() {
        return password;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
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
    public Date getBirthday() {
        return birthday;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Boolean getSex() {
        return sex;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getPhone() {
        return phone;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getEmail() {
        return email;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getAvatar() {
        return avatar;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Boolean getEnabled() {
        return enabled;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Boolean getAccountNonExpired() {
        return accountNonExpired;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Boolean getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Boolean getAccountNonLocked() {
        return accountNonLocked;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
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