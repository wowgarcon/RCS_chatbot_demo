package com.example.demo.samsung.dto;

import com.example.demo.samsung.domain.MessageContact;
import com.example.demo.samsung.domain.RcsMessage;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SamsungMaapResponseDto {

    @JsonProperty(value = "RCSMessage")
    private RcsMessage rcsMessage;
    private MessageContact messageContact;
    private String event;
}
