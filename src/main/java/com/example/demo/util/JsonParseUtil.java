package com.example.demo.util;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParseUtil {
	
	// String 형태로 넘어오는 JSON을 OBJECT로 변환
	@SuppressWarnings(value = "unchecked")
	public static <T> T getStringToObjectData(String data, Object obj) {
		ObjectMapper mapper = null;
		try {
			if (StringUtils.isEmpty(data)) {
				return null;
			} else {
				mapper = new ObjectMapper();
//				mapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
				mapper.setSerializationInclusion(Include.NON_NULL);
				return (T) mapper.readValue(data, obj.getClass());
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	// Null값을 제외하고 String Data로 변환
	public static String getOBjectToStringData(Object data) {
		ObjectMapper mapper;
		try {
			if (data == null) {
				return null;
			} else {
				mapper = new ObjectMapper();
				mapper.setSerializationInclusion(Include.NON_NULL);
				return mapper.writeValueAsString(data);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
