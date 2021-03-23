package com.example.demo.service;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import com.example.demo.common.RcsMaapTokenOption;
import com.example.demo.samsung.domain.RcsMessageDomain;
import com.example.demo.util.JsonParseUtil;
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

	private final RestTemplate restTemplate;
	private final ConcurrentHashMap<String, String> rcsMaapToken;

	@Value("${samsung.rcs.chatbot.domain}")
	private String requestTargetUrl;
	
	@Value("${samsung.rcs.chatbot.send.message.uri}")
	private String maapSendMsgUrl;
	
	@Override
	public void rcsSendMsgToMaap(RcsMessageDomain rcsMessageDomain) throws Exception {
		String token = rcsMaapToken.get(RcsMaapTokenOption.ACCESS_TOKEN.name());
		Optional.ofNullable(token)
				.filter(t -> t.length() > 0)
				.orElseThrow(() -> new IllegalArgumentException("토큰 발급 요망"));
		log.debug("STEP-4 DEMO_API_CALL TOKEN [ {} ]", token);

		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
        header.set("Authorization", "Bearer " + token);

        // Domain -> JsonString 직렬화
		String rcsDomainJsonData = JsonParseUtil.getOBjectToStringData(rcsMessageDomain);
		log.debug("STEP-5 DEMO_API_CALL RCS_DOMAIN_JSON_DATA {}", rcsDomainJsonData);

        HttpEntity<Object> requestEntity = new HttpEntity<>(rcsDomainJsonData, header);
        ResponseEntity<Map> resData = restTemplate.exchange(requestTargetUrl + maapSendMsgUrl, HttpMethod.POST, requestEntity, Map.class);
		log.debug("STEP-6 DEMO_API_CALL FINISH -- RESULT {}", resData.getBody());
	}
}
