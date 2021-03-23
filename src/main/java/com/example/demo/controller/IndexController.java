package com.example.demo.controller;

import com.example.demo.samsung.domain.RcsMessageDomain;
import com.example.demo.service.RcsMaapTokenServiceImpl;
import com.example.demo.service.RcsSendMessageServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Controller
public class IndexController {

	private final RcsMaapTokenServiceImpl rcsMaapTokenServiceImpl;
	private final RcsSendMessageServiceImpl rcsSendMessageServiceImpl;

	@GetMapping(value = "/")
	public String index() {
		return "index";
	}
	
	@GetMapping(value = "/terms")
	public String terms() {
		return "terms";
	}

	@ResponseBody
	@GetMapping("/createToken")
	public String createToken() {
		log.debug("STEP-01_CREATE_TOKEN CALL ===");
		String token = "";
		try {
			 token = Optional.ofNullable(rcsMaapTokenServiceImpl.getOauthClientCredentials())
					         .filter(t -> t.length() > 0)
					 		 .orElseThrow(() -> new IllegalArgumentException("토큰 발급 실패"));
			log.debug("STEP-02_CREATE_TOKEN CALL ===");
		} catch (IllegalAccessException e) {
			log.error(e.getMessage(), e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		log.debug("STEP-03_CREATE_TOKEN CALL FINISH");
		return token;
	}

	@PostMapping("/rcs/sendMessage")
	public void sendMessageMaap(@RequestBody RcsMessageDomain rcsMessageDomain) {
		log.debug("STEP-01_SEND_MESSAGE CALL ===");
		try {
			log.debug("{}", rcsMessageDomain.getMessageContact().getUserContact());
			rcsSendMessageServiceImpl.rcsSendMsgToMaap(rcsMessageDomain);
			log.debug("STEP-02_SEND_MESSAGE CALL ===");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
}
