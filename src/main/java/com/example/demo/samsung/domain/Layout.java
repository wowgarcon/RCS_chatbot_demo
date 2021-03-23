package com.example.demo.samsung.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Layout {
	
	/*
	 * Type of the rich card orientation("HORIZONTAL"/"VERTICAL").
	 */
	private String cardOrientation;
	
	/*
	 * [Optional] Text which specify image alignment ("LEFT", "RIGHT"). Required if cardOrientation is HORIZONTAL.
	 */
	private String imageAlignment;
	
	/*
	 * width of each rich card in the carousel ("SMALL_WIDTH":120 DP, "MEDIUM_WIDTH": 232 DP). SMALL_WIDTH carousel can only have richcard media with SHORT_HEIGHT and MEDIUM_HEIGHT. Refer to R15-8-31 and R15-8-39 of RCC.71 for more details.
	 */
	private String cardWidth;
	
	/*
	 * openRichCard
	 */
	private String widget;
	private String width;
	private String height;
	private String orientation;
	private String paddingLeft;
	private String paddingRight;
	private List<Children> children;
	List<List<Children>> childrens;
}
