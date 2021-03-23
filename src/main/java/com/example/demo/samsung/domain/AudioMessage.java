package com.example.demo.samsung.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AudioMessage {
	/*
	 * [Optional] The Audio file name.
	 */
	private String fileName;
	/*
	 * HTTP URL of audio file.
	 */
	private String fileUrl;
	/*
	 * [Optional] MIME type of file.
	 */
	private String fileMIMEType;
	/*
	 * [Optional] Size of audio file in bytes
	 */
	private Integer fileSize;
	/*
	 * [Optional] Duration of audio file.
	 */
	private Integer playingLength;
}
