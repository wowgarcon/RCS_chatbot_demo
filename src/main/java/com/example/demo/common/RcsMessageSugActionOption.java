package com.example.demo.common;

import com.example.demo.samsung.domain.Action;
import com.example.demo.samsung.domain.LocalBrowserAction;
import com.example.demo.samsung.domain.Reply;
import lombok.Getter;


public enum RcsMessageSugActionOption {
    SUG_ACTION(Action.class),
    SUG_REPLY(Reply.class),
    SUG_LOCAL_BROWSER_ACTION(LocalBrowserAction.class);

    @Getter
    private Class classValue;

    private RcsMessageSugActionOption(Class classValue) {
        this.classValue = classValue;
    }
}