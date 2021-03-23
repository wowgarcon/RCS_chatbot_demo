package com.example.demo.samsung.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OpenUrl {
	/*
	 * required
	 */
	private String url;
	/*
	 * set true to show Internal Web browser in vertical half size of screen
	 */
	private Boolean isHalfView;
//	private String idHalfView;
	/*
	 * parameters to be sent as POST method when open url
	 */
	private Object postParameter;
}
