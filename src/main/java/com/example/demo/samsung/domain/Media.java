package com.example.demo.samsung.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Media {
	private String mediaUrl;
	private String mediaContentType;
	private Long mediaFileSize;
	private String thumbnailUrl;
	private String thumbnailContentType;
	private Long thumbnailFileSize; 
	private String height;
	private String contentDescription;
	
	/*
      "mediaUrl": "https://cdn.server/path/media.mp4",
      "mediaContentType": "video/mp4",
      "mediaFileSize": 2718288,
      "thumbnailUrl": "https://cdn.server/path/media.png",
      "thumbnailContentType": "image/png",
      "thumbnailFileSize": 314159,
      "height": "MEDIUM_HEIGHT",
      "contentDescription": "Textual description of media content, e. g. for use with screen readers."
	 */
}
