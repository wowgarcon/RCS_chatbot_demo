package com.example.demo.service;

import com.example.demo.common.RcsMessageActionOption;
import com.example.demo.common.RcsMessageChipContents;
import com.example.demo.common.RcsMessageKtContents;
import com.example.demo.samsung.domain.RcsMessageDomain;
import com.example.demo.samsung.dto.SamsungMaapReceiveDto;

import java.util.LinkedHashMap;

public interface RcsMessageConverter {
    public RcsMessageDomain getTextMessage(RcsMessageKtContents message, SamsungMaapReceiveDto receiveDto, LinkedHashMap<RcsMessageActionOption, RcsMessageChipContents> suggestions);
    public RcsMessageDomain getTextCustomMessage(String customMessage, SamsungMaapReceiveDto receiveDto, LinkedHashMap<RcsMessageActionOption, RcsMessageChipContents> suggestions);
//    public RcsMessageDomain getRichCard
}