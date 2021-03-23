package com.example.demo.config;

import com.example.demo.common.RcsMessageActionOption;
import com.example.demo.common.RcsMessageChipContents;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;

@Configuration
public class RcsChipConfig {

    /**
     * 하단 칩 노출
     * 
     */
    @Bean
    public LinkedHashMap<RcsMessageActionOption, RcsMessageChipContents> suggestionsChipList() {
        LinkedHashMap<RcsMessageActionOption, RcsMessageChipContents> map = new LinkedHashMap<>();

        map.put(RcsMessageActionOption.CHIP_ACTION, RcsMessageChipContents.RCS_URL_ACTION);
        map.put(RcsMessageActionOption.CHIP_REPLY, RcsMessageChipContents.RCS_REPLY);
        map.put(RcsMessageActionOption.CHIP_LOCAL_BROWSER_ACTION, RcsMessageChipContents.RCS_URL_LOCAL_BROWSER_ACTION);

        return map;
    }

    /**
     * 카드 선택지 노출
     *
     */
    @Bean
    public LinkedHashMap<RcsMessageActionOption, RcsMessageChipContents> suggestionsList() {
        LinkedHashMap<RcsMessageActionOption, RcsMessageChipContents> map = new LinkedHashMap<>();

        map.put(RcsMessageActionOption.SUG_ACTION, RcsMessageChipContents.RCS_URL_ACTION);
        map.put(RcsMessageActionOption.SUG_REPLY, RcsMessageChipContents.RCS_REPLY);
        map.put(RcsMessageActionOption.SUG_LOCAL_BROWSER_ACTION, RcsMessageChipContents.RCS_URL_LOCAL_BROWSER_ACTION);

        return map;
    }

    /**
     * 하단 칩 & 카드 선택지 노출
     *
     */
    @Bean
    public LinkedHashMap<RcsMessageActionOption, RcsMessageChipContents> suggestions() {
        LinkedHashMap<RcsMessageActionOption, RcsMessageChipContents> map = new LinkedHashMap<>();

        map.put(RcsMessageActionOption.CHIP_ACTION, RcsMessageChipContents.RCS_URL_ACTION);
        map.put(RcsMessageActionOption.CHIP_REPLY, RcsMessageChipContents.RCS_REPLY);
        map.put(RcsMessageActionOption.CHIP_LOCAL_BROWSER_ACTION, RcsMessageChipContents.RCS_URL_LOCAL_BROWSER_ACTION);

        map.put(RcsMessageActionOption.SUG_ACTION, RcsMessageChipContents.RCS_URL_ACTION);
        map.put(RcsMessageActionOption.SUG_REPLY, RcsMessageChipContents.RCS_REPLY);
        map.put(RcsMessageActionOption.SUG_LOCAL_BROWSER_ACTION, RcsMessageChipContents.RCS_URL_LOCAL_BROWSER_ACTION);

        return map;
    }
}
