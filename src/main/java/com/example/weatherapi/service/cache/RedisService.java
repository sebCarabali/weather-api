package com.example.weatherapi.service.cache;

import org.springframework.boot.autoconfigure.cache.CacheProperties.Redis;
import org.springframework.stereotype.Service;

@Service
public class RedisService implements CacheService {

  @Override
  public Object get(String key) {
    return null;
  }

  @Override
  public void put(String key, Object value) {

  }
}
