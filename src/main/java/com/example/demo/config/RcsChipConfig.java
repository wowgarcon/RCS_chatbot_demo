package com.example.demo.config;

import com.example.demo.common.RcsMessageChipActionOption;
import com.example.demo.common.RcsMessageChipContents;
import com.example.demo.common.RcsMessageSugActionOption;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class RcsChipConfig {

    /**
     * 하단 칩 노출
     * 
     */
    @Bean
    public LinkedHashMap<RcsMessageChipActionOption, RcsMessageChipContents> suggestionsChipList() {
        LinkedHashMap<RcsMessageChipActionOption, RcsMessageChipContents> map = new LinkedHashMap<>();

        map.put(RcsMessageChipActionOption.CHIP_ACTION, RcsMessageChipContents.RCS_URL_ACTION);
        map.put(RcsMessageChipActionOption.CHIP_REPLY, RcsMessageChipContents.RCS_REPLY);
        map.put(RcsMessageChipActionOption.CHIP_LOCAL_BROWSER_ACTION, RcsMessageChipContents.RCS_URL_LOCAL_BROWSER_ACTION);

        return map;
    }

    /**
     * 카드 선택지 노출
     *
     */
    @Bean
    public LinkedHashMap<RcsMessageSugActionOption, RcsMessageChipContents> suggestionsList() {
        LinkedHashMap<RcsMessageSugActionOption, RcsMessageChipContents> map = new LinkedHashMap<>();

        map.put(RcsMessageSugActionOption.SUG_ACTION, RcsMessageChipContents.RCS_URL_ACTION);
        map.put(RcsMessageSugActionOption.SUG_REPLY, RcsMessageChipContents.RCS_REPLY);
        map.put(RcsMessageSugActionOption.SUG_LOCAL_BROWSER_ACTION, RcsMessageChipContents.RCS_URL_LOCAL_BROWSER_ACTION);

        return map;
    }
}