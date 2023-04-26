package com.softwarelearn.lite_mall_backend.security;

import com.softwarelearn.lite_mall_backend.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtil {
    @Autowired
    private UserService userService;
    private static final String SECRET_KEY = "secret";
    private static final long VALIDITY_IN_MILLISECONDS = 3600000; // 1 hour
    private static final long REFRESH_INTERVAL_IN_MILLISECONDS = 300000; // 5 minutes

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, userDetails.getUsername());
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {
        final Date createdDate = new Date();
        final Date expirationDate = new Date(createdDate.getTime() + VALIDITY_IN_MILLISECONDS);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    private Date getExpirationDateFromToken(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getExpiration();
    }

    public boolean shouldTokenBeRefreshed(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        final Date refreshDate = new Date(expiration.getTime() - REFRESH_INTERVAL_IN_MILLISECONDS);
        return refreshDate.before(new Date());
    }

    public String refreshToken(String token) {
        final String username = getUsernameFromToken(token);
        final UserDetails userDetails = userService.loadUserByUsername(username);
        return doGenerateToken(new HashMap<>(), userDetails.getUsername());
    }
}