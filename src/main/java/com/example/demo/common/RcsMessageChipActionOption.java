package com.example.demo.common;

import com.example.demo.samsung.domain.Action;
import com.example.demo.samsung.domain.LocalBrowserAction;
import com.example.demo.samsung.domain.Reply;
import lombok.Getter;


public enum RcsMessageChipActionOption {

    CHIP_ACTION(Action.class),
    CHIP_REPLY(Reply.class),
    CHIP_LOCAL_BROWSER_ACTION(LocalBrowserAction.class);

    @Getter
    private Class classValue;

    private RcsMessageChipActionOption(Class classValue) {
        this.classValue = classValue;
    }
}