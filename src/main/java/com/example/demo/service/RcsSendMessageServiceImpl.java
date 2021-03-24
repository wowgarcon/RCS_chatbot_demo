package com.example.demo.service;

import java.net.URI;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import com.example.demo.common.RcsMaapTokenOption;
import com.example.demo.samsung.domain.RcsMessageDomain;
import com.example.demo.util.JsonParseUtil;
import com.sun.jndi.toolkit.url.Uri;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.util.UriComponentsBuilder;

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

	@Value("${samsung.rcs.chatbot.check.contactCapabilities.uri}")
	private String contactCapabilitiesUrl;

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

	@Override
	public String rcsCheckCapabilities(String userContact) throws Exception {
		String token = rcsMaapToken.get(RcsMaapTokenOption.ACCESS_TOKEN.name());
		Optional.ofNullable(token)
				.filter(t -> t.length() > 0)
				.orElseThrow(() -> new IllegalArgumentException("토큰 발급 요망"));

		HttpHeaders header = new HttpHeaders();
		header.set("Authorization", "Bearer " + token);

		userContact = StringUtils.replace(userContact, "+", "%2B");
		URI uri = URI.create(requestTargetUrl + contactCapabilitiesUrl + userContact);

		HttpEntity<Object> requestEntity = new HttpEntity<>(header);
		ResponseEntity<String> resData = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);

		log.debug("{}", resData.getBody().toString());
		return resData.getBody();
	}
}
