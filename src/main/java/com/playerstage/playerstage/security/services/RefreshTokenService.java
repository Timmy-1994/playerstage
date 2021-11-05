package com.playerstage.playerstage.security.services;

import java.sql.Date;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import com.playerstage.playerstage.mappers.RefreshTokenDynamicSqlSupport;
import com.playerstage.playerstage.mappers.RefreshTokenMapper;
import com.playerstage.playerstage.mappers.UserMapper;
import com.playerstage.playerstage.models.RefreshToken;
import com.playerstage.playerstage.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

@Service
public class RefreshTokenService {

  @Value("${auth.jwt.refreshExpirationMs}")
  private Long refreshTokenDurationMs;

  @Autowired
  private RefreshTokenMapper refreshTokenMapper;
  
  @Autowired
  UserMapper userMapper;

  public Optional<RefreshToken> findByToken(String token) {
    return refreshTokenMapper.selectOne(x-> x.where( RefreshTokenDynamicSqlSupport.token,isEqualTo(token)));
  }

  public String createTokenByUserUUID(UUID userUUID) {

    String token = UUID.randomUUID().toString();

    RefreshToken refreshToken = new RefreshToken() {{
      setUuid(UUID.randomUUID());
      setUserId(userUUID);
      setExpire(Date.from(Instant.now().plusMillis(refreshTokenDurationMs)));
      setToken(token);
    }};

    refreshTokenMapper.insert(refreshToken);

    return token;
  }

  public Optional<User> getExpVerifyedUser(RefreshToken refreshToken) {

    if (refreshToken.getExpire().compareTo(Date.from(Instant.now())) < 0) {
      refreshTokenMapper.deleteByPrimaryKey(refreshToken.getUuid());
      return null;
    }

    return userMapper.selectByPrimaryKey(refreshToken.getUserId());

  }

  public void deleteByUserId(UUID userUUID) {
    refreshTokenMapper.delete(x->x.where(RefreshTokenDynamicSqlSupport.userId, isEqualTo(userUUID)));
  }
  
}
