package com.example.demo.samsung.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneralPurposeCard {
	private String messageHeader;
	private String messageFooter;
	
	private Layout layout;
	private Content content;
}