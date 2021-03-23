package com.example.demo.samsung.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true) // 무시 속성
public class SamsungMaapReceiveDto implements Serializable {
	/**
	 * serialVersionUID = -138283602955617069L;
	 */
	private static final long serialVersionUID = -138283602955617069L;
	
	@JsonProperty(value = "RCSMessage")
	private RcsMessage rcsMessage;	
	private MessageContact messageContact;
	private String event;
}