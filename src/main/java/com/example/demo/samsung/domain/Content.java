package com.example.demo.samsung.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Content {
	/*
	 * [Optional] Information about the media file. One of media or title or description is required.
	 */
	private Media media;
	/*
	 * [Optional] Text to be displayed below the image. One of media or title or description is required.
	 */
	private String title;
	/*
	 * [Optional] Message text descibing the meaning of the item. One of media or title or description is required.
	 */
	private String description;
	/*
	 * [Optional] List of the suggested replies and/or suggested actions from Bot. It carries maximum 4 objects of type Action or Reply. However, suggested replies and actions can be truncated if richcard height exceeds max card height (MAX_CARD_HEIGHT: 344 DP). Refer to R15-8-42-1 and R15-8-35 of RCC.71 for more details.
	 */
	private List<Suggestions> suggestions;
}
