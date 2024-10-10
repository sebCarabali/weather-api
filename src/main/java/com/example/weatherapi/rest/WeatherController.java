package com.example.weatherapi.rest;

import com.example.weatherapi.model.Weather;
import com.example.weatherapi.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

  private WeatherService weatherService;

  @Autowired
  public WeatherController(WeatherService weatherService) {
    this.weatherService = weatherService;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Weather> getWeather(@RequestParam("city") String city) {
    return ResponseEntity.ok(weatherService.loadWeather(city));
  }
}
