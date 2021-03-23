package com.example.demo.common;

import lombok.Getter;

@Getter
public enum RcsMessageKtContents {
    RCS_KT_CONTENTS_HELLO("안녕하세요.");

    private String value;

    private RcsMessageKtContents(String value) {
        this.value = value;
    }
}
