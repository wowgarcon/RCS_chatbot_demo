package com.example.demo.samsung.domain;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Children {
	private String widget;
	private String width;
	private String height;
	private String orientation;
	private String gravity;
	private String marginTop;
	private String marginBottom;
	private String background;
//	private Suggestions suggestions;
	
	// children 
	private List<Children> children;
	private String textSize;
	private String textStyle;
	private String textColor;
	private Integer weight;
	private String text;
	private String textAligment;
	private String scaleType;
	private String mediaUrl;
	private String mediaContentType;
	private Long mediaFileSize;
	private Reply reply;
	private Click click;
}