package com.playerstage.playerstage.controllers;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.playerstage.playerstage.dto.SignInRequest;
import com.playerstage.playerstage.dto.SignUpRequest;
import com.playerstage.playerstage.models.RefreshToken;
import com.playerstage.playerstage.models.User;
import com.playerstage.playerstage.security.RoleEnum;
import com.playerstage.playerstage.security.SecurityUser;
import com.playerstage.playerstage.security.jwt.JwtUtils;
import com.playerstage.playerstage.security.services.RefreshTokenService;
import com.playerstage.playerstage.security.services.UserDetailsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;

@Api(tags="用戶權限")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    AuthenticationManager authenticationManager; // come from bean which declared in SecurityConfig.java

    @Autowired
    RefreshTokenService refreshTokenService;

    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;
    
    @Autowired
    JwtUtils jwtUtils;
    
    @PostMapping("/signup")
    @Operation(summary = "註冊")
    public ResponseEntity<?> signup(@Valid @RequestBody SignUpRequest signUpRequest, HttpServletResponse response){
        
        boolean isDuplicated = userDetailsServiceImpl.verifyDuplication(signUpRequest);
        
        if(isDuplicated){
            return ResponseEntity.badRequest().body("user data is duplicated");
        }
        
        try{
            User usr = userDetailsServiceImpl.addUser(signUpRequest,RoleEnum.ROLE_USER);
            
            return ResponseEntity.ok(usr);
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }

    }


    @PostMapping("/signin")
    @Operation(summary = "登入")
    public ResponseEntity<?> getRefreshToken(@Valid @RequestBody SignInRequest signInRequest, HttpServletResponse response){
        
        Authentication authentication = authenticationManager
            .authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        SecurityUser userDetails = (SecurityUser) authentication.getPrincipal();

        String refreshToken = refreshTokenService.createTokenByUserUUID(userDetails.getUuid());

        Cookie cookie = new Cookie("refreshToken", refreshToken);
        cookie.setSecure(true);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        
        return ResponseEntity.ok(userDetails);
    }

    @GetMapping("/accessToken")
    @Operation(summary = "取得 access token")
    public ResponseEntity<?> getAccessToken(
        @CookieValue(value = "refreshToken") String refreshToken
    ){
        RefreshToken refreshTokenModel = refreshTokenService.findByToken(refreshToken).orElse(null);
        
        if(refreshTokenModel == null){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Refresh token is not exsist");
        }
        
        User user = refreshTokenService.getExpVerifyedUser(refreshTokenModel).orElseGet(null);

        if(user == null){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Refresh token has expired or user not exsist");
        }

    
        String token = jwtUtils.generateTokenFromUsername(user.getUsername());

        return ResponseEntity.ok(token);
    }

    @DeleteMapping("/logout")
    @Operation(summary = "登出")
    public ResponseEntity<?> logoutUser(
        @RequestParam(value="userid") String userUUIDStr,
        HttpServletResponse response
    ) {
        refreshTokenService.deleteByUserId(UUID.fromString(userUUIDStr));
        return ResponseEntity.ok("Log out successful!");
    }
}
