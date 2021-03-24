package com.example.demo.service;

import com.example.demo.common.RcsMessageChipActionOption;
import com.example.demo.common.RcsMessageChipContents;
import com.example.demo.common.RcsMessageKtContents;
import com.example.demo.samsung.domain.*;
import com.example.demo.samsung.dto.SamsungMaapReceiveDto;
import org.springframework.stereotype.Service;

import java.util.*;

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
            LinkedHashMap<RcsMessageChipActionOption, RcsMessageChipContents> suggestions) {

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

        if (suggestions != null) {
            // 하단 칩, 단순 텍스트 메세지는 하단 칩만 가능
            SuggestedChipList suggestedChipList = new SuggestedChipList();
            List<Suggestions> suggestionsList;

            // Chip List 생성
            suggestionsList = getSuggestionsChipList(suggestions);
            suggestedChipList.setSuggestions(suggestionsList);

            // Chip List 추가
            rcsMessage.setSuggestedChipList(suggestedChipList);
        }

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
            String customMessage, SamsungMaapReceiveDto receiveDto, LinkedHashMap<RcsMessageChipActionOption,
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
            LinkedHashMap<RcsMessageChipActionOption, RcsMessageChipContents> suggestions) {

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
            LinkedHashMap<RcsMessageChipActionOption, RcsMessageChipContents> suggestions) {
        
        return null;
    }

    public List<Suggestions> getSuggestionsChipList(
            LinkedHashMap<RcsMessageChipActionOption, RcsMessageChipContents> suggestions) {
        List<Suggestions> suggestionsList = new ArrayList<Suggestions>();

        // ACTION KEY_SET 얻어오기
        Set<RcsMessageChipActionOption> actionKeySet = suggestions.keySet();
        for (RcsMessageChipActionOption chipAction : actionKeySet) {
            if (chipAction.getClassValue().equals(RcsMessageChipActionOption.CHIP_ACTION.getClassValue())) {
                RcsMessageChipContents contents = suggestions.get(chipAction);
                // DISPLAY TEST, POSTBACK, ACTION URL
                Action action = getAction(contents.getValue(), contents.getValue(), contents.getUrl());

                // CHIP SETTING
                Suggestions actionSuggestions = new Suggestions();
                actionSuggestions.setAction(action);

                // ADD CHIP LIST
                suggestionsList.add(actionSuggestions);
            } else if (chipAction.getClassValue().equals(RcsMessageChipActionOption.CHIP_REPLY.getClassValue())) {
                RcsMessageChipContents contents = suggestions.get(chipAction);
                // DISPLAY TEST, POSTBACK, ACTION URL
                Reply reply = getReply(contents.getValue(), contents.getValue());

                // CHIP SETTING
                Suggestions actionSuggestions = new Suggestions();
                actionSuggestions.setReply(reply);

                // ADD CHIP LIST
                suggestionsList.add(actionSuggestions);
            } else if (chipAction.getClassValue().equals(RcsMessageChipActionOption.CHIP_LOCAL_BROWSER_ACTION.getClassValue())) {
                RcsMessageChipContents contents = suggestions.get(chipAction);
                // DISPLAY TEST, POSTBACK, ACTION URL
                Action action = getLocalBrowserAction(contents.getValue(), contents.getValue(), contents.getUrl());

                // CHIP SETTING
                Suggestions actionSuggestions = new Suggestions();
                actionSuggestions.setAction(action);

                // ADD CHIP LIST
                suggestionsList.add(actionSuggestions);
            } else {
                throw new IllegalArgumentException("CHIP_ACTION이 아닙니다.");
            }
        }

        return suggestionsList;
    }

    /**
     * 로컬 브라우져 액션
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
        // 모바일 화면에 반만 노출 할껀지
//        openUrl.setIsHalfView(true);
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
