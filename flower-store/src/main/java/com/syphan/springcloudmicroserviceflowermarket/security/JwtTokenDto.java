package com.syphan.springcloudmicroserviceflowermarket.security;

public class JwtTokenDto {

    private String token;
    private final String type = "Bearer";

    public JwtTokenDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }
}
