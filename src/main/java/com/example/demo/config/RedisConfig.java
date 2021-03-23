//package com.example.demo.config;
//
//import java.util.Collection;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisClusterConfiguration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//@Configuration
////@EnableCaching
//public class RedisConfig {
//	
//	@Value("${spring.redis.cluster.nodes}")
//	private Collection<String> clusterNodes;
//	
//	// redisTemplate
//	@Bean
//	public RedisTemplate<String, Object> redisTemplateForObject(RedisConnectionFactory connectionFactory) {
//		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//		redisTemplate.setConnectionFactory(connectionFactory);
//		redisTemplate.setKeySerializer(new StringRedisSerializer());
//		redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(String.class));
//		return redisTemplate;
//	}
//	
//	// Thread-safe Lettuce
//	@Bean
//	public RedisConnectionFactory redisConnectionFactory() {
//		RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration(clusterNodes);
////		redisClusterConfiguration.setPassword(RedisPassword.of("myPassWord"));
//		LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(redisClusterConfiguration);
//		return lettuceConnectionFactory;
//	}
//}
