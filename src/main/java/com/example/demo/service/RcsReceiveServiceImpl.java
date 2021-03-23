package com.example.demo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.samsung.dto.SamsungMaapReceiveDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class RcsReceiveServiceImpl implements RcsReceiveService {

    private final RcsSendMessageServiceImpl rcsSendMessageServiceImpl;

    @Async(value = "customExcutor")
    @Override
    public void rcsReceiveService(SamsungMaapReceiveDto samsungMaapReceiveDto) throws Exception {
//		rcsSendMessageServiceImpl.rcsSendMsgToMaap();
        log.debug("SERVICE CALL");
    }
}