package com.example.demo.service;

import com.example.demo.samsung.dto.SamsungMaapResponseDto;

public interface RcsSendMessageService {
	public void rcsSendMsgToMaap(SamsungMaapResponseDto samsungMaapResponseDto) throws Exception;
}
