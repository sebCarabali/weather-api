package com.example.weatherapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {

  @Value("${spring.redis.host}")
  private String redisHost;
  @Value(("${spring.redis.port}"))
  private int redisPort;
  @Value(("${spring.redis.password}"))
  private String redisPassword;

  @Bean
  JedisConnectionFactory jedisConnectionFactory() {
    JedisConnectionFactory jedisConFactory = new JedisConnectionFactory();
    jedisConFactory.setHostName(redisHost);
    jedisConFactory.setPort(redisPort);
    jedisConFactory.setPassword(redisPassword);
    return jedisConFactory;
  }

  @Bean
  public RedisTemplate<String, Object> redisTemplate() {
    RedisTemplate<String, Object> template = new RedisTemplate<>();
    template.setConnectionFactory(jedisConnectionFactory());
    return template;
  }
}
