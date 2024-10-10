package com.example.weatherapi.service;

import com.example.weatherapi.model.Weather;

public interface WeatherService {

  Weather loadWeather(String city);
}
