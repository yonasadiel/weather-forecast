package com.yonasadiel.openweatherapi;

import com.yonasadiel.city.City;
import com.yonasadiel.city.Coordinate;
import com.yonasadiel.weatherdata.*;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class ResponseParser {
  private static ResponseParser instance = null;

  private ResponseParser() {
    // do nothing
  }

  public static ResponseParser getInstance() {
    if (instance == null) {
      instance = new ResponseParser();
    }
    return instance;
  }

  private Coordinate parseCoordinate(JSONObject coordinateObj) {
    return new Coordinate(
        coordinateObj.getDouble("lat"),
        coordinateObj.getDouble("lon")
    );
  }

  private City parseCity(JSONObject cityObj) {
    return new City(
        cityObj.getInt("id"),
        cityObj.getString("name"),
        this.parseCoordinate(cityObj.getJSONObject("coord")),
        cityObj.getString("country")
    );
  }

  private Condition parseCondition(JSONObject conditionObj) {
    try {
      return new Condition(
          new Temperature(conditionObj.getDouble("temp"), "Celcius"),
          new Temperature(conditionObj.getDouble("temp_max"), "Celcius"),
          new Temperature(conditionObj.getDouble("temp_min"), "Celcius"),
          conditionObj.getDouble("pressure"),
          conditionObj.getDouble("sea_level"),
          conditionObj.getDouble("grnd_level"),
          (float) conditionObj.getInt("humidity") / 100
      );
    } catch (Exception e) {
      return null;
    }
  }

  private WeatherSummary parseWeatherSummary(JSONObject weatherSummaryObj) {
    return new WeatherSummary(
        weatherSummaryObj.getInt("id"),
        weatherSummaryObj.getString("main"),
        weatherSummaryObj.getString("description"),
        weatherSummaryObj.getString("icon")
    );
  }

  private Forecast parseForecast(JSONObject forecastObj) {
    JSONArray weathersObj = forecastObj.getJSONArray("weather");
    WeatherSummary[] weatherSummaries = new WeatherSummary[weathersObj.length()];
    for (int i = 0; i < weathersObj.length(); i++) {
      weatherSummaries[i] = this.parseWeatherSummary(weathersObj.getJSONObject(i));
    }

    Date dateCalculated;
    try {
      dateCalculated = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
          .parse(forecastObj.getString("dt_txt"));
    } catch (ParseException e) {
      dateCalculated = null;
    }

    return new Forecast(
        this.parseCondition(forecastObj.getJSONObject("main")),
        new Date(forecastObj.getLong("dt") * 1000),
        dateCalculated,
        weatherSummaries,
        forecastObj.getJSONObject("wind").getDouble("speed"),
        forecastObj.getJSONObject("wind").getDouble("deg"),
        (float) forecastObj.getJSONObject("clouds").getInt("all") / 100
    );
  }

  private ForecastData parseForecastData(JSONObject forecastDataObj) {
    JSONArray forecastsObj = forecastDataObj.getJSONArray("list");
    Forecast[] forecasts = new Forecast[forecastsObj.length()];
    for (int i = 0; i < forecastsObj.length(); i++) {
      forecasts[i] = this.parseForecast(forecastsObj.getJSONObject(i));
    }

    return new ForecastData(
        this.parseCity(forecastDataObj.getJSONObject("city")),
        forecasts,
        forecastDataObj.getString("cod"),
        forecastDataObj.getDouble("message"),
        forecastDataObj.getInt("cnt")
    );
  }

  private WeatherData parseWeatherData(JSONObject weatherDataObj) {
    JSONArray weatherSummariesObj = weatherDataObj.getJSONArray("weather");
    WeatherSummary[] weatherSummaries = new WeatherSummary[weatherSummariesObj.length()];
    for (int i = 0; i < weatherSummariesObj.length(); i++) {
      weatherSummaries[i] = this.parseWeatherSummary(weatherSummariesObj.getJSONObject(i));
    }

    return new WeatherData(
        this.parseCondition(weatherDataObj.getJSONObject("main")),
        new Date(weatherDataObj.getLong("dt") * 1000),
        weatherSummaries,
        weatherDataObj.getJSONObject("wind").getDouble("speed"),
        weatherDataObj.getJSONObject("wind").getDouble("deg"),
        (float) weatherDataObj.getJSONObject("clouds").getInt("all") / 100,
        this.parseCoordinate(weatherDataObj.getJSONObject("coord")),
        String.valueOf(weatherDataObj.getInt("cod")),
        weatherDataObj.getString("name")
    );
  }

  public ForecastData parseForecastResponse(String json) {
    JSONObject forecastDataObj = new JSONObject(json);
    return this.parseForecastData(forecastDataObj);
  }

  public WeatherData parseWeatherResponse(String json) {
    JSONObject weatherDataObj = new JSONObject(json);
    return this.parseWeatherData(weatherDataObj);
  }
}
