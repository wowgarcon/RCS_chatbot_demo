package com.example.demo.service;

import com.example.demo.common.RcsMessageChipActionOption;
import com.example.demo.common.RcsMessageChipContents;
import com.example.demo.common.RcsMessageKtContents;
import com.example.demo.samsung.domain.RcsMessageDomain;
import com.example.demo.samsung.dto.SamsungMaapReceiveDto;

import java.util.LinkedHashMap;

public interface RcsMessageConverterService {
    /**
     * BOT MESSAGE 전송시 도메인으로 REST 통신
     * @param message
     * @param receiveDto
     * @param suggestions
     * @return rcsMessageDomain
     */
    public RcsMessageDomain getTextMessage(RcsMessageKtContents message, SamsungMaapReceiveDto receiveDto, LinkedHashMap<RcsMessageChipActionOption, RcsMessageChipContents> suggestions);
    public RcsMessageDomain getTextCustomMessage(String customMessage, SamsungMaapReceiveDto receiveDto, LinkedHashMap<RcsMessageChipActionOption, RcsMessageChipContents> suggestions);
    public RcsMessageDomain getRichCard(RcsMessageKtContents message, SamsungMaapReceiveDto receiveDto, LinkedHashMap<RcsMessageChipActionOption, RcsMessageChipContents> suggestions);
    public RcsMessageDomain getCarouselRichCard(RcsMessageKtContents message, SamsungMaapReceiveDto receiveDto, LinkedHashMap<RcsMessageChipActionOption, RcsMessageChipContents> suggestions);
//    public RcsMessageDomain getRichCard
}