package com.example.backen_springboot.configuration.components;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


import com.example.backen_springboot.exception.ResourceNotFoundEx;
import com.example.backen_springboot.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

import java.security.Key;
import java.security.SecureRandom;

import java.util.*;
import java.util.function.Function;


@Component
@RequiredArgsConstructor
public class JwtTokenUtil {
    @Value("${jwt.expiration}")
    private Long expiration;

    @Value("${jwt.secretKey}")
    private String secretKey;

    public String generateToken(User user) throws Exception{
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", user.getEmail());
        try {
            String token = Jwts.builder()
                    .setClaims(claims)
                    .setSubject(user.getEmail()) // Đặt email ở đây
                    .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000L))
                    .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                    .compact();
            return token;
        } catch (Exception e) {
            throw new ResourceNotFoundEx("Cannot create jwt token, error: " + e.getMessage());
        }
    }

    private Key getSignInKey() {
        byte[] bytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(bytes);
    }
    private String generateSecretKey() {
        SecureRandom random = new SecureRandom();
        byte[] keyBytes = new byte[32]; // 256-bit key
        random.nextBytes(keyBytes);
        String secretKey = Encoders.BASE64.encode(keyBytes);
        return secretKey;
    }
    private Claims extractAllClaims(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(getSignInKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            throw new RuntimeException("Invalid token");
        }
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = this.extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // Kiểm tra thời gian hết hạn token
    public boolean isTokenExpired(String token) {
        Date expirationDate = this.extractClaim(token, Claims::getExpiration);
        return expirationDate.before(new Date());
    }

    // Đổi thành email
    public String extractEmail(String token) {
        return extractClaim(token, Claims::getSubject); // Subject là email
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        String email = extractEmail(token); // Đổi thành email
        return (email.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }
}

