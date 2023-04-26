package com.softwarelearn.lite_mall_backend.constant;

import lombok.Data;

@Data
public class JwtResponse {
    private final String token;

    public JwtResponse(String token) {
        this.token = token;
    }
}