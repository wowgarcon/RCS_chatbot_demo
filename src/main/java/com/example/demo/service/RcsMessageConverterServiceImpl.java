package com.example.demo.service;

import com.example.demo.common.RcsMessageActionOption;
import com.example.demo.common.RcsMessageChipContents;
import com.example.demo.common.RcsMessageKtContents;
import com.example.demo.samsung.domain.*;
import com.example.demo.samsung.dto.SamsungMaapReceiveDto;
import org.aspectj.bridge.Message;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

@Service
public class RcsMessageConverterServiceImpl implements RcsMessageConverterService {

    /**
     * 기본 메세지
     * @param message
     * @param receiveDto
     * @param suggestions
     * @return RcsMessageDomain
     */
    @Override
    public RcsMessageDomain getTextMessage(
            RcsMessageKtContents message, SamsungMaapReceiveDto receiveDto,
            LinkedHashMap<RcsMessageActionOption, RcsMessageChipContents> suggestions) {

        // 고객 번호
        String contactUser = receiveDto.getMessageContact().getUserContact();

        /**
         * BUILD DOMAIN
         */
        // 회신받을 번호 셋팅
        MessageContact messageContact = new MessageContact();
        messageContact.setUserContact(contactUser);

        // RCS 규격 메세지 BODY 셋팅
        RcsMessage rcsMessage = new RcsMessage();
        rcsMessage.setTextMessage(message.getValue());

        // RCS 규격 DOMAIN 셋팅
        RcsMessageDomain rcsMessageDomain = new RcsMessageDomain();
        rcsMessageDomain.setMessageContact(messageContact);
        rcsMessageDomain.setRcsMessage(rcsMessage);

        return rcsMessageDomain;
    }

    /**
     * 사용자 정의 메세지
     * @param customMessage
     * @param receiveDto
     * @param suggestions
     * @return
     */
    @Override
    public RcsMessageDomain getTextCustomMessage(
            String customMessage, SamsungMaapReceiveDto receiveDto, LinkedHashMap<RcsMessageActionOption,
            RcsMessageChipContents> suggestions) {

        return null;
    }

    /**
     * 기본 카드
     * @param message
     * @param receiveDto
     * @param suggestions
     * @return
     */
    @Override
    public RcsMessageDomain getRichCard(
            RcsMessageKtContents message, SamsungMaapReceiveDto receiveDto,
            LinkedHashMap<RcsMessageActionOption, RcsMessageChipContents> suggestions) {

        return null;
    }

    /**
     * 슬라이드 카드
     * @param message
     * @param receiveDto
     * @param suggestions
     * @return
     */
    @Override
    public RcsMessageDomain getCarouselRichCard(
            RcsMessageKtContents message, SamsungMaapReceiveDto receiveDto,
            LinkedHashMap<RcsMessageActionOption, RcsMessageChipContents> suggestions) {
        
        return null;
    }

    /**
     * IN-WEB 브라우져 액션
     * @param displayText
     * @param postBackData
     * @param url
     * @return
     */
    public Action getLocalBrowserAction(String displayText, String postBackData, String url) {
        Action action = new Action();
        action.setDisplayText(displayText);

        // 버튼 클릭시 PostBack으로 오는 데이터
        Postback postback = new Postback();
        postback.setData(postBackData); // Action Button 클릭시 이벤트
        action.setPostback(postback);

        OpenUrl openUrl = new OpenUrl();
        openUrl.setUrl(url);
        openUrl.setIsHalfView(true);
        LocalBrowserAction localBrowserAction = new LocalBrowserAction();
        localBrowserAction.setOpenUrl(openUrl);
        action.setLocalBrowserAction(localBrowserAction);

        return action;
    }

    /**
     * 기본 액션
     * @param displayText
     * @param postBackData
     * @param url
     * @return
     */
    public Action getAction(String displayText, String postBackData, String url) {
        Action action = new Action();
        action.setDisplayText(displayText);

        Postback postback = new Postback();
        postback.setData(postBackData); // Action Button 클릭시 이벤트
        action.setPostback(postback);

        OpenUrl openUrl = new OpenUrl();
        openUrl.setUrl(url);
        UrlAction urlAction = new UrlAction();
        urlAction.setOpenUrl(openUrl);
        action.setUrlAction(urlAction);

        return action;
    }

    /**
     * 기본 동작
     * @param displayText
     * @param postBackData
     * @return
     */
    public Reply getReply(String displayText, String postBackData) {
        // PostBack
        Postback postback = new Postback();
        postback.setData(postBackData); // 선택 했을때 피드백 오는 메시지

        // Suggestions.Reply
        Reply reply = new Reply();
        reply.setDisplayText(displayText);
        reply.setPostback(postback);

        return reply;
    }
}
