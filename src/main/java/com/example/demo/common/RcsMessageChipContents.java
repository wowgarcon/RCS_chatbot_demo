package com.example.demo.common;

import lombok.Getter;

@Getter
public enum RcsMessageChipContents {

    RCS_URL_ACTION("WEB_ACTION", "https://www.naver.com"),
    RCS_URL_LOCAL_BROWSER_ACTION("IN_WEB_ACTION", "https://www.naver.com"),
    RCS_REPLY("REPLY", "ClickUrl");
    
    private String value;
    private String url;

    private RcsMessageChipContents(String value, String url) {
        this.value = value;
        this.url = url;
    }
}