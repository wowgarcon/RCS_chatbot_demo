package com.example.demo.common;

import lombok.Getter;

@Getter
public enum RcsMessageChipContents {

    RCS_URL_ACTION("WEB_ACTION", "http://121.190.25.242:8080/param"),
    RCS_URL_LOCAL_BROWSER_ACTION("LOCAL_BROWSER_ACTION", "http://121.190.25.242:8080/param"),
    RCS_REPLY("REPLY", "ClickUrl");
    
    private String value;
    private String url;

    private RcsMessageChipContents(String value, String url) {
        this.value = value;
        this.url = url;
    }
}