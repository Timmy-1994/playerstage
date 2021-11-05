package com.playerstage.playerstage.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.playerstage.playerstage.models.*;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUser extends User implements UserDetails {
    

    private Collection<? extends GrantedAuthority> authorities;

    public SecurityUser(User usr){
        BeanUtils.copyProperties(usr, this);
    }

    public void setAuthorities(List<Role> roles) {
        authorities = roles.stream()
            .map(x->new SimpleGrantedAuthority(x.getName()))
            .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return getAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return getAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return getCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return getEnabled();
    }
    
}
