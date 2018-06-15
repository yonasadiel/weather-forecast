package com.yonasadiel.weatherdata;

import com.yonasadiel.city.City;

public class WeatherData {
    private City city;
    private Forecast[] forecasts;
    private String code;
    private double message;
    private int count;

    public WeatherData(City city, Forecast[] forecasts, String code, double message, int count) {
        this.city = city;
        this.forecasts = forecasts;
        this.code = code;
        this.message = message;
        this.count = count;
    }

    public City getCity() {
        return city;
    }

    public Forecast[] getForecasts() {
        return forecasts;
    }

    public String getCode() {
        return code;
    }

    public double getMessage() {
        return message;
    }

    public int getCount() {
        return count;
    }
}
