package com.example.demo.controller;

import com.example.demo.util.JsonParseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.samsung.dto.SamsungMaapReceiveDto;
import com.example.demo.service.RcsReceiveServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/demo")
@RestController
public class RcsReceiveController {
	private final RcsReceiveServiceImpl rcsReceiveServiceImpl;
	
	@GetMapping(value = "/webhook/messages")
	public ResponseEntity<?> testWebHook() {
		log.debug("CALL_TEST_WEBHOOK_MAP_SIZE");
		return ResponseEntity.ok().build();
	}
	
	@PostMapping(value = "/webhook/messages")
	public ResponseEntity<?> webHook(			
			@RequestHeader(value = "authorization", required = true) String authorization,
			@RequestHeader(value = "host", required = false) String host,
			@RequestBody(required = true) String resData) {
		
		try {
			log.debug("RECEIVE_JSON_DATA [ {} ]", resData);
			SamsungMaapReceiveDto samsungMaapReceiveDto = JsonParseUtil.getStringToObjectData(resData, new SamsungMaapReceiveDto());
			rcsReceiveServiceImpl.rcsReceiveService(samsungMaapReceiveDto);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		return ResponseEntity.ok().build();
	}
}