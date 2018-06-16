package com.yonasadiel.weatherdata;

import java.util.Arrays;
import java.util.Date;

public class Weather {
    private Condition condition;
    private Date date;
    private WeatherSummary[] weatherSummaries;
    private double windSpeed;
    private double windDegree;
    private float clouds;

    public Weather(Condition condition, Date date,
                    WeatherSummary[] weatherSummaries,
                    double windSpeed, double windDegree,
                    float clouds) {
        this.condition = condition;
        this.date = date;
        this.weatherSummaries = weatherSummaries;
        this.windSpeed = windSpeed;
        this.windDegree = windDegree;
        this.clouds = clouds;
    }

    public Condition getCondition() {
        return this.condition;
    }

    public Date getDate() {
        return this.date;
    }

    public WeatherSummary[] getWeatherSummaries() {
        return this.weatherSummaries;
    }

    public double getWindSpeed() {
        return this.windSpeed;
    }

    public double getWindDegree() {
        return this.windDegree;
    }

    public float getClouds() {
        return this.clouds;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "condition=" + this.getCondition() +
                ", date=" + this.getDate() +
                ", weatherSummaries=" + Arrays.toString(this.getWeatherSummaries()) +
                ", windSpeed=" + this.getWindSpeed() +
                ", windDegree=" + this.getWindDegree() +
                ", clouds=" + this.getClouds() +
                '}';
    }
}
