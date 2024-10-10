package com.example.weatherapi.service.cache;

import java.util.concurrent.TimeUnit;

public interface CacheService {
  void put(String key, Object value, int time, TimeUnit units);
  Object get(String key);
}
