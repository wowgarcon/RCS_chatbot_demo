package com.example.demo.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.example.demo.common.SAMSUNG_MAAP_TOKEN_OPTION;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.samsung.dto.SamsungMaapResponseDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class RcsSendMessageServiceImpl implements RcsSendMessageService {

	private final ConcurrentHashMap<String, String> rcsMaapToken;

	@Value("${samsung.rcs.chatbot.domain}")
	private String requestTargetUrl;
	
	@Value("${samsung.rcs.chatbot.send.message.uri}")
	private String maapSendMsgUrl;
	
	@Override
	public void rcsSendMsgToMaap(SamsungMaapResponseDto samsungMaapResponseDto) throws Exception {
		String token = rcsMaapToken.get(SAMSUNG_MAAP_TOKEN_OPTION.ACCESS_TOKEN.name());
		log.debug("TOKEN [ {} ]", token);

		RestTemplate rest = new RestTemplate();
		HttpHeaders header = new HttpHeaders();
		
		header.setContentType(MediaType.APPLICATION_JSON);
        header.set("Authorization", "Bearer " + token);
		
        HttpEntity<Object> requestEntity = new HttpEntity<>(samsungMaapResponseDto, header);
        ResponseEntity<Map> resData = rest.exchange(requestTargetUrl + maapSendMsgUrl, HttpMethod.POST, requestEntity, Map.class);
        log.debug("{}", resData.getBody());
	}
}
