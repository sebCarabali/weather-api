package com.example.weatherapi.service;

import com.example.weatherapi.model.Weather;
import com.example.weatherapi.service.cache.CacheService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DefaultWeatherService implements WeatherService {

  private static final Logger logger = LoggerFactory.getLogger(DefaultWeatherService.class);

  private final RestTemplate restTemplate;
  private final ObjectMapper objectMapper;
  @Value("${weather.api.uri}")
  private String weatherApiUri;
  @Value("${weather.api.key}")
  private String weatherApiKey;
  private final CacheService cacheService;

  @Autowired
  public DefaultWeatherService(RestTemplate restTemplate, CacheService cacheService) {
    this.restTemplate = restTemplate;
    this.cacheService = cacheService;
    this.objectMapper = new ObjectMapper();
  }

  @Override
  public Weather loadWeather(String city) {

    Weather weather = (Weather) cacheService.get(city);

    if(weather != null) {
      return  weather;
    }

    String formatUri = weatherApiUri.replace("<city>", URLEncoder.encode(city))
        .replace("<key>", weatherApiKey);

    String jsonResponse = restTemplate.getForObject(formatUri, String.class);

    logger.info("APIResponse: {}", jsonResponse);
    try {
      Weather response = findCurrentConditions(jsonResponse);
      cacheService.put(city, response, 12, TimeUnit.HOURS);
      return response;
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e.getMessage(), e);
    }
  }

  private Weather findCurrentConditions(String jsonResponse) throws JsonProcessingException {
    JsonNode root = null;
    root = objectMapper.readTree(jsonResponse);
    JsonNode currentConditions = root.path("currentConditions");
    if (currentConditions != null) {
      return objectMapper.treeToValue(currentConditions, Weather.class);
    }
    return null;
  }
}
