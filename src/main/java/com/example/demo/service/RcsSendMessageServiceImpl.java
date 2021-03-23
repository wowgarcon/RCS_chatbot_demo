package com.example.demo.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.example.demo.common.RcsMaapTokenOption;
import com.example.demo.samsung.domain.RcsMessageDomain;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
	public void rcsSendMsgToMaap(RcsMessageDomain rcsMessageDomain) throws Exception {
		String token = rcsMaapToken.get(RcsMaapTokenOption.ACCESS_TOKEN.name());
		log.debug("TOKEN [ {} ]", token);

		RestTemplate rest = new RestTemplate();
		HttpHeaders header = new HttpHeaders();
		
		header.setContentType(MediaType.APPLICATION_JSON);
        header.set("Authorization", "Bearer " + token);
		
        HttpEntity<Object> requestEntity = new HttpEntity<>(rcsMessageDomain, header);
        ResponseEntity<Map> resData = rest.exchange(requestTargetUrl + maapSendMsgUrl, HttpMethod.POST, requestEntity, Map.class);
        log.debug("{}", resData.getBody());
	}
}
