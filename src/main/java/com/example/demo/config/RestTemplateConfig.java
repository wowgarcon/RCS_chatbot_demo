package com.example.demo.config;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	
	@Value("${custom.send.thread.pool.max}")
	private Integer maxPoolSize;
	
	// 지속적인 통신을 위한 서비스 에서는 SimpleClientHttpRequestFactory가 좋지 않다(매번 Connection 생성)
	// 따라서 ConnectionPool 사용을 위해 HttpComponentsClientHttpRequestFactor를 사용
	@Bean
	public RestTemplate restTemplate() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
		TrustStrategy strategy = (X509Certificate[] chain, String authType) -> true;

		SSLContext sslContext = SSLContexts.custom()
				.loadTrustMaterial(null, strategy)
				.build();

		SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);

		CloseableHttpClient httpClient = HttpClients.custom()
				.setSSLSocketFactory(csf)
				.setMaxConnTotal(maxPoolSize) // maxConnTotal은 연결을 유지할 최대 숫자
				.setMaxConnPerRoute(maxPoolSize) // maxConnPerRoute는 특정 경로당 최대 숫자
				.build();

		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setConnectionRequestTimeout(5000);
		requestFactory.setReadTimeout(5000);
		
		requestFactory.setHttpClient(httpClient);
		return new RestTemplate(requestFactory);
	}
}