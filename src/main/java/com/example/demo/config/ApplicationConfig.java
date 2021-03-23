package com.example.demo.config;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
	
	@Bean
	public ConcurrentHashMap<String, String> rcsMaapToken() {
		ConcurrentHashMap<String, String> hashMap = new ConcurrentHashMap<String, String>();
		return hashMap;
	}
}
