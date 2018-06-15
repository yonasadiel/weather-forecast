package com.yonasadiel.openweatherapi;

import com.yonasadiel.city.City;
import com.yonasadiel.city.Coordinate;
import com.yonasadiel.weatherdata.*;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    private Weather parseWeather(JSONObject weatherObj) {
        return new Weather(
                weatherObj.getInt("id"),
                weatherObj.getString("main"),
                weatherObj.getString("description"),
                weatherObj.getString("icon")
        );
    }

    private Forecast parseForecast(JSONObject forecastObj) {
        JSONArray weathersObj = forecastObj.getJSONArray("weather");
        Weather[] weathers = new Weather[weathersObj.length()];
        for (int i = 0; i < weathersObj.length(); i++) {
            weathers[i] = this.parseWeather(weathersObj.getJSONObject(i));
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
                new Date(forecastObj.getLong("dt")),
                dateCalculated,
                weathers,
                forecastObj.getJSONObject("wind").getDouble("speed"),
                forecastObj.getJSONObject("wind").getDouble("deg"),
                (float) forecastObj.getJSONObject("clouds").getInt("all") / 100
        );
    }

    private WeatherData parseWeatherData(JSONObject weatherDataObj) {
        JSONArray forecastsObj = weatherDataObj.getJSONArray("list");
        Forecast[] forecasts = new Forecast[forecastsObj.length()];
        for (int i = 0; i < forecastsObj.length(); i++) {
            forecasts[i] = this.parseForecast(forecastsObj.getJSONObject(i));
        }

        return new WeatherData(
                this.parseCity(weatherDataObj.getJSONObject("city")),
                forecasts,
                weatherDataObj.getString("cod"),
                weatherDataObj.getDouble("message"),
                weatherDataObj.getInt("cnt")
        );
    }

    public WeatherData parseResponse(String json) {
        JSONObject weatherDataObj = new JSONObject(json);
        return this.parseWeatherData(weatherDataObj);
    }
}
