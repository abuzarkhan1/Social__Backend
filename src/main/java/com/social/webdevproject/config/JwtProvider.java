package com.social.webdevproject.config;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.social.webdevproject.config.JwtConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;

import java.util.Base64;
import java.util.Date;


public class JwtProvider {

    private static SecretKey generateSecretKey() {
        byte[] apiKeySecretBytes = Base64.getEncoder().encode(JwtConstant.SECRET_KEY.getBytes());
        return new SecretKeySpec(apiKeySecretBytes, io.jsonwebtoken.SignatureAlgorithm.HS256.getJcaName());
    }

    private static SecretKey key = generateSecretKey();

    public static String generateToken(Authentication auth){

        String jwt = Jwts.builder().setIssuer("IsmailAzam").setIssuedAt(new Date()).setExpiration(new Date(new Date().getTime() + 86400000))
                .claim("email",auth.getName())
                .signWith(key)
                .compact();
        return jwt;
    }

    public static String getEmailFromJwtToken(String jwt){
        jwt = jwt.substring(7);
        Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();

        String email = String.valueOf(claims.get("email"));

        return email;
    }
}
