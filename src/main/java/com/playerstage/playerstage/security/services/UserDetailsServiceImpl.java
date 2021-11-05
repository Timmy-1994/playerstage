package com.playerstage.playerstage.security.services;

import com.playerstage.playerstage.dto.SignUpRequest;
import com.playerstage.playerstage.mappers.*;
import com.playerstage.playerstage.models.*;
import com.playerstage.playerstage.security.RoleEnum;
import com.playerstage.playerstage.security.SecurityUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

import static org.mybatis.dynamic.sql.SqlBuilder.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  UserRoleIntermediaryMapper userRoleIntermediaryMapper;

  @Autowired
  RoleMapper roleMapper;

  @Autowired
  UserMapper userMapper;
  
  @Autowired
  PasswordEncoder passwordEncoder; // come from bean which declared in SecurityConfig.java

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    
    User usr = userMapper
      .selectOne(x-> x.where(UserDynamicSqlSupport.username, isEqualTo(username)))
      .orElseThrow(()->new UsernameNotFoundException("User Not Found with username: " + username));


    // get role by user
    List<Role> roles = userRoleIntermediaryMapper
        .select(x->x.where(UserRoleIntermediaryDynamicSqlSupport.userId,isEqualTo(usr.getUuid())))
        .stream()
        .map(x->roleMapper.selectByPrimaryKey(x.getRoleId()).orElse(null))
        .collect(Collectors.toList());

    log.info("loadUserByUsername roles : {}" , roles);
    log.info("loadUserByUsername usr.getAccountNonLocked() : {}" , usr.getAccountNonLocked());

    var securityUser = new SecurityUser(usr);
    securityUser.setAuthorities(roles);

    return securityUser;
  }

  public boolean verifyDuplication(SignUpRequest signUpRequest){
    
    Optional<User> res = userMapper.selectOne(
      x->x.where(UserDynamicSqlSupport.username,isEqualTo(signUpRequest.getUsername()))
      // .or(UserDynamicSqlSupport.email ,isEqualTo(signUpRequest.getEmail()))
    );

    return !res.isEmpty();

  }

  @Transactional(rollbackFor = Exception.class)
  public User addUser(SignUpRequest signUpRequest, RoleEnum roleName) throws Exception{
    
    User user = new User() {{
      setUuid(UUID.randomUUID());
      setName(signUpRequest.getUsername());
      setUsername(signUpRequest.getUsername());
      setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
      setEnabled(true);
      setValid(true);
      setAccountNonExpired(true);
      setCredentialsNonExpired(true);
      setAccountNonLocked(true);
  }};

    Role role = roleMapper.selectOne(
      x->x.where(RoleDynamicSqlSupport.name, isEqualTo(roleName.toString()))
    ).orElse(null);

    if(role==null){
      throw new Exception("Role not found");
    }

    userMapper.insert(user);

    userRoleIntermediaryMapper.insert(new UserRoleIntermediary(){{
      setUuid(UUID.randomUUID());
      setUserId(user.getUuid());
      setRoleId(role.getUuid());
    }});

    return user;

  }

}
