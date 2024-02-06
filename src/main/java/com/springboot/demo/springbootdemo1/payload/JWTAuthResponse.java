package com.springboot.demo.springbootdemo1.payload;

import lombok.Data;

@Data
public class JWTAuthResponse {
    private String accessToken;
    private String tokenType = "Bearer Token";
}
