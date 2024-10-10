package com.example.weatherapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather implements Serializable {

  private float temp;
  private float humidity;
  private float windspeed;
  private String conditions;
  private String sunrise;
  private int pressure;
  private float cloudcover;
  private float visibility;
  private String icon;

  public float getCloudcover() {
    return cloudcover;
  }

  public void setCloudcover(float cloudcover) {
    this.cloudcover = cloudcover;
  }

  public String getConditions() {
    return conditions;
  }

  public void setConditions(String conditions) {
    this.conditions = conditions;
  }

  public float getHumidity() {
    return humidity;
  }

  public void setHumidity(float humidity) {
    this.humidity = humidity;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public int getPressure() {
    return pressure;
  }

  public void setPressure(int pressure) {
    this.pressure = pressure;
  }

  public String getSunrise() {
    return sunrise;
  }

  public void setSunrise(String sunrise) {
    this.sunrise = sunrise;
  }

  public float getTemp() {
    return temp;
  }

  public void setTemp(float temp) {
    this.temp = temp;
  }

  public float getVisibility() {
    return visibility;
  }

  public void setVisibility(float visibility) {
    this.visibility = visibility;
  }

  public float getWindspeed() {
    return windspeed;
  }

  public void setWindspeed(float windspeed) {
    this.windspeed = windspeed;
  }
}
