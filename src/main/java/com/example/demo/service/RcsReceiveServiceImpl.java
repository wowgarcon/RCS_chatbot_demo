package com.example.demo.service;

import com.example.demo.common.RcsMessageChipActionOption;
import com.example.demo.common.RcsMessageChipContents;
import com.example.demo.common.RcsMessageEventOption;
import com.example.demo.common.RcsMessageKtContents;
import com.example.demo.samsung.domain.RcsMessageDomain;
import com.example.demo.samsung.dto.SamsungMaapReceiveDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

@Slf4j
@RequiredArgsConstructor
@Service
public class RcsReceiveServiceImpl implements RcsReceiveService {

    private final LinkedHashMap<RcsMessageChipActionOption, RcsMessageChipContents> suggestionsChipList;

    private final RcsMessageConverterServiceImpl rcsMessageConverterService;
    private final RcsSendMessageServiceImpl rcsSendMessageService;

    @Async(value = "customExcutor")
    @Override
    public void rcsReceiveService(SamsungMaapReceiveDto samsungMaapReceiveDto) throws Exception {
        log.debug("STEP-2 DEMO_API_CALL");

        if (samsungMaapReceiveDto.getEvent().equals(RcsMessageEventOption.MESSAGE.getValue())
                || samsungMaapReceiveDto.getEvent().equals(RcsMessageEventOption.NEW_USER.getValue())) {
            callRcsSendMsgService(samsungMaapReceiveDto);
        }
    }

    @Override
    public void callRcsSendMsgService(SamsungMaapReceiveDto samsungMaapReceiveDto) throws Exception {
        log.debug("STEP-3 DEMO_API_CALL");
        RcsMessageDomain rcsMessageDomain;

        rcsMessageDomain = rcsMessageConverterService.getTextMessage(
                RcsMessageKtContents.RCS_KT_CONTENTS_HELLO, samsungMaapReceiveDto, suggestionsChipList);
        rcsSendMessageService.rcsSendMsgToMaap(rcsMessageDomain);
    }
}