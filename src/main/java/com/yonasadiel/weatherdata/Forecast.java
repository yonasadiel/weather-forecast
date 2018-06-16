package com.yonasadiel.weatherdata;

import java.util.Arrays;
import java.util.Date;

public class Forecast extends Weather {
    private Date dateCalculated;

    public Forecast(Condition condition,
                    Date date, Date dateCalculated,
                    WeatherSummary[] weatherSummaries,
                    double windSpeed, double windDegree,
                    float clouds) {
        super(condition, date,
              weatherSummaries,
              windSpeed, windDegree,
              clouds);
        this.dateCalculated = dateCalculated;
    }

    public Date getDateCalculated() {
        return this.dateCalculated;
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "condition=" + this.getCondition() +
                ", date=" + this.getDate() +
                ", dateCalculated=" + this.getDateCalculated() +
                ", weathers=" + Arrays.toString(this.getWeatherSummaries()) +
                ", windSpeed=" + this.getWindSpeed() +
                ", windDegree=" + this.getWindDegree() +
                ", clouds=" + this.getClouds() +
                '}';
    }
}
