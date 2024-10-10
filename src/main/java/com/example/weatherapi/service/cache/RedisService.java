package com.example.weatherapi.service.cache;

import java.util.concurrent.TimeUnit;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService implements CacheService {

  private final RedisTemplate<String, Object> redisTemplate;

  public RedisService(RedisTemplate<String, Object> redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  @Override
  public void put(String key, Object value, int time, TimeUnit units) {
    this.redisTemplate.opsForValue().set(key, value, time, units);
  }

  @Override
  public Object get(String key) {
    return this.redisTemplate.opsForValue().get(key);
  }
}
