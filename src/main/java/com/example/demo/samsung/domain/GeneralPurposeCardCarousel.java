package com.example.demo.samsung.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@JsonPropertyOrder({"messageHeader","messageFooter"})
@Getter
@Setter
public class GeneralPurposeCardCarousel {
	private String messageHeader;
	private String messageFooter;
	
	private Layout layout;
	private List<Content> content;
}