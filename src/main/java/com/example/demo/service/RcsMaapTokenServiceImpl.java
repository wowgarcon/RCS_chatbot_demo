package com.example.demo.service;

import com.example.demo.common.SAMSUNG_MAAP_TOKEN_OPTION;
import com.example.demo.dto.MaapTokenResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Slf4j
@RequiredArgsConstructor
@Service
public class RcsMaapTokenServiceImpl implements RcsMaapTokenService {

    @Value("${samsung.rcs.chatbot.client.id}")
    private String clientId;

    @Value("${samsung.rcs.chatbot.client.secret}")
    private String clientSecret;

    @Value("${samsung.rcs.chatbot.oauth.token.uri}")
    private String authTokenUrl;
    
    private final RestTemplate restTemplate;
    private final ConcurrentHashMap<String, String> rcsMaapToken;

    @Override
    public String getOauthClientCredentials() throws Exception {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();

        body.add("client_id", clientId);
        body.add("client_secret", clientSecret);
        body.add("grant_type", "client_credentials");
        body.add("scope", "botmessage");

        HttpEntity<Object> requestEntity = new HttpEntity<Object>(body, header);
        ResponseEntity<MaapTokenResponseDto> responseData = restTemplate.exchange(authTokenUrl, HttpMethod.POST, requestEntity, MaapTokenResponseDto.class);

        String token = responseData.getBody().getAccess_token();
        rcsMaapToken.put(SAMSUNG_MAAP_TOKEN_OPTION.ACCESS_TOKEN.name(), token);
        return token;
    }
}