package com.example.demo.samsung.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileMessage {
	/*
	 * [Optional] File name of thumbnail.
	 */
	private String thumbnailFileName;
	/*
	 * [Optional] HTTP URL of thumbnail.
	 */
	private String thumbnailUrl;
	/*
	 * [Optional] MIME type for thumbnail.
	 */
	private String thumbnailMIMEType;
	/*
	 * [Optional] Thumbnail size in bytes.
	 */
	private Integer thumbnailFileSize;
	/*
	 * [Optional] File name.
	 */
	private String fileName;
	/*
	 * Http URL of file.
	 */
	private String fileUrl;
	/*
	 * [Optional] MIME type of file.
	 */
	private String fileMIMEType;
	/*
	 * [Optional] File size in bytes.
	 */
	private Integer fileSize;
}
