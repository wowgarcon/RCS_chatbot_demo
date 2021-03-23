package com.example.demo.samsung.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

// 직렬화 순서
@JsonPropertyOrder({"rcsMessage","messageContact"})
@Getter
@Setter
public class RcsMessageDomain {
	
	// JSON Key값 설정
	@JsonProperty("RCSMessage")
	private RcsMessage rcsMessage;
	
	private MessageContact messageContact;
	
//	@Builder
//	public RcsMessageDomain(RcsMessage rcsMessage, MessageContact messageContact) {
//		this.rcsMessage = rcsMessage;
//		this.messageContact = messageContact;
//	}
}
