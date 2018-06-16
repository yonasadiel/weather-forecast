package com.yonasadiel.weatherdata;

import com.yonasadiel.city.City;

import java.util.Arrays;

public class ForecastData {
    private City city;
    private Forecast[] forecasts;
    private String code;
    private double message;
    private int count;

    public ForecastData(City city, Forecast[] forecasts, String code, double message, int count) {
        this.city = city;
        this.forecasts = forecasts;
        this.code = code;
        this.message = message;
        this.count = count;
    }

    public City getCity() {
        return this.city;
    }

    public Forecast[] getForecasts() {
        return this.forecasts;
    }

    public String getCode() {
        return this.code;
    }

    public double getMessage() {
        return this.message;
    }

    public int getCount() {
        return this.count;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "city=" + this.getCity() +
                ", forecasts=" + Arrays.toString(this.getForecasts()) +
                ", code='" + this.getCode() + '\'' +
                ", message=" + this.getMessage() +
                ", count=" + this.getCount() +
                '}';
    }
}
