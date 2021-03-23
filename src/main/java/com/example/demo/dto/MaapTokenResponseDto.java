package com.example.demo.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
public class MaapTokenResponseDto {
    private String access_token;
    private String token_type;
    private Integer expires_in;
    private String refresh_token;
}