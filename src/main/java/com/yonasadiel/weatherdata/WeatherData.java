package com.yonasadiel.weatherdata;

import com.yonasadiel.city.Coordinate;

import java.util.Arrays;
import java.util.Date;

public class WeatherData extends Weather {
  private Coordinate coordinate;
  private String code;
  private String name;

  public WeatherData(Condition condition, Date date,
                     WeatherSummary[] weatherSummaries,
                     double windSpeed, double windDegree,
                     float clouds,
                     Coordinate coordinate,
                     String code, String name) {
    super(condition, date, weatherSummaries, windSpeed, windDegree, clouds);
    this.coordinate = coordinate;
    this.code = code;
    this.name = name;
  }

  public Coordinate getCoordinate() {
    return this.coordinate;
  }

  public String getCode() {
    return this.code;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public String toString() {
    return "WeatherData{" +
           "coordinate=" + coordinate +
           ", code='" + code + '\'' +
           ", name='" + name + '\'' +
           ", condition=" + this.getCondition() +
           ", date=" + this.getDate() +
           ", weatherSummaries=" + Arrays.toString(this.getWeatherSummaries()) +
           ", windSpeed=" + this.getWindSpeed() +
           ", windDegree=" + this.getWindDegree() +
           ", clouds=" + this.getClouds() +
           '}';
  }
}
