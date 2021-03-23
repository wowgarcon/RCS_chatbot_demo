package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import lombok.Getter;

@EnableAsync(proxyTargetClass = true)
@Configuration
public class AsyncConfig {
	
	@Value("${custom.send.thread.pool.core}")
	private Integer corePoolSize;
	
	@Getter
	@Value("${custom.send.thread.pool.max}")
	private Integer maxPoolSize;
	
	@Bean(name = "customExcutor")
	public ThreadPoolTaskExecutor bizExcutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(corePoolSize);
		taskExecutor.setMaxPoolSize(maxPoolSize);
		taskExecutor.setQueueCapacity(corePoolSize * maxPoolSize);
		taskExecutor.setThreadNamePrefix("customExcutor-");
		taskExecutor.initialize();
		return taskExecutor;
	}
}