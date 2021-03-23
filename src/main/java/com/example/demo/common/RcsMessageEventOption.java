package com.example.demo.common;

import lombok.Getter;

public enum RcsMessageEventOption {
    NEW_USER("newUser"),
    RESPONSE("response"),
    MESSAGE("message"),
    MESSAGE_STATUS("messageStatus");

    @Getter
    private String value;

    private RcsMessageEventOption(String value) {
        this.value = value;
    }
}
