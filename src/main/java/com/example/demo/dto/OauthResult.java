package com.example.demo.dto;

public class OauthResult {
    private String token_type = "bearer";
    private String access_token;
    private Integer expires_in;
    private String refresh_token;
    private Integer refresh_token_expires_in;
    private String scope;

    @Override
    public String toString() {
        return "OauthResult{" +
                "token_type='" + token_type + '\'' +
                ", access_token='" + access_token + '\'' +
                ", expires_in=" + expires_in +
                ", refresh_token='" + refresh_token + '\'' +
                ", refresh_token_expires_in=" + refresh_token_expires_in +
                ", scope='" + scope + '\'' +
                '}';
    }
}
