package com.wochanye.demo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.wochanye.demo.constant.ConfigConsts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fangpf
 * @date 2020/1/19 15:29
 */
@Component
public class JwtUtil {

    @Value("${client.access-secret}")
    private String secret;

    public Map<String, Object> createToken(String userId, String username, Long expireTime){
        Map<String, Object> tokenInfo = new HashMap<>();
        Map<String, Object> headerClaims = new HashMap<>();

        headerClaims.put("alg", "HS256");
        headerClaims.put("typ", "JWT");
        Long tokenExpire = System.currentTimeMillis() + expireTime;
        String token = JWT.create()
                .withHeader(headerClaims)
                .withClaim(ConfigConsts.Auth.TOKEN_ID_KEY, userId)
                .withClaim(ConfigConsts.Auth.TOKEN_USERNAME_KEY, username)
                .withClaim(ConfigConsts.Auth.TOKEN_EXPIRE_KEY, tokenExpire)
                .sign(Algorithm.HMAC256(secret));
        tokenInfo.put(ConfigConsts.Auth.TOKEN_KEY, token);
        tokenInfo.put(ConfigConsts.Auth.TOKEN_EXPIRE_KEY, tokenExpire);
        tokenInfo.put(ConfigConsts.Auth.TOKEN_USERNAME_KEY, username);
        return tokenInfo;
    }

    public Map<String, Claim> verifyToken(String token){
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret)).build();
        DecodedJWT jwt = verifier.verify(token);
        return jwt.getClaims();
    }
}
