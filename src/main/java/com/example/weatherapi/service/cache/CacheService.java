package com.example.weatherapi.service.cache;

public interface CacheService {
  void put(String key, Object value);
  Object get(String key);
}
