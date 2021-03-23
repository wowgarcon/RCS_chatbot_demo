package com.example.demo.controller;

import com.example.demo.common.RcsMessageEventOption;
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
	private final RcsReceiveServiceImpl rcsReceiveService;
	
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
			log.debug("MAAP_RECEIVE_DATA [ {} ]", resData);
			SamsungMaapReceiveDto samsungMaapReceiveDto = JsonParseUtil.getStringToObjectData(resData, new SamsungMaapReceiveDto());
			String event = samsungMaapReceiveDto.getEvent();

			// 사용자에 의한 메세지일 경우에만 serviceCall
			if (!event.equals(RcsMessageEventOption.MESSAGE_STATUS.getValue())) {
				log.debug("STEP-1 DEMO_API_CALL [ {} ]", resData);
				rcsReceiveService.rcsReceiveService(samsungMaapReceiveDto);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		return ResponseEntity.ok().build();
	}
}