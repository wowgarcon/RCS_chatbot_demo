package com.example.demo.service;

import com.example.demo.common.RcsMessageKtContents;
import com.example.demo.samsung.domain.RcsMessageDomain;
import com.example.demo.samsung.dto.SamsungMaapReceiveDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class RcsReceiveServiceImpl implements RcsReceiveService {

    private final RcsMessageConverterServiceImpl rcsMessageConverterService;
    private final RcsSendMessageServiceImpl rcsSendMessageService;

    @Async(value = "customExcutor")
    @Override
    public void rcsReceiveService(SamsungMaapReceiveDto samsungMaapReceiveDto) throws Exception {
        log.debug("STEP-2 DEMO_API_CALL");
        callRcsSendMsgService(samsungMaapReceiveDto);
    }

    @Override
    public void callRcsSendMsgService(SamsungMaapReceiveDto samsungMaapReceiveDto) throws Exception {
        log.debug("STEP-3 DEMO_API_CALL");
        RcsMessageDomain rcsMessageDomain;

        rcsMessageDomain = rcsMessageConverterService.getTextMessage(
                RcsMessageKtContents.RCS_KT_CONTENTS_HELLO, samsungMaapReceiveDto, null);
        rcsSendMessageService.rcsSendMsgToMaap(rcsMessageDomain);
    }
}