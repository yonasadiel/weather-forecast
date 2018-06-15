package com.yonasadiel.weatherdata;

import java.util.Date;

public class Forecast {
    private Condition condition;
    private Date date;
    private Date dateCalculated;
    private Weather[] weathers;
    private double windSpeed;
    private double windDegree;
    private float clouds;

    public Forecast(Condition condition,
                    Date date, Date dateCalculated,
                    Weather[] weathers,
                    double windSpeed, double windDegree,
                    float clouds) {
        this.condition = condition;
        this.date = date;
        this.dateCalculated = dateCalculated;
        this.weathers = weathers;
        this.windSpeed = windSpeed;
        this.windDegree = windDegree;
        this.clouds = clouds;
    }

    public Condition getCondition() {
        return condition;
    }

    public Date getDate() {
        return date;
    }

    public Date getDateCalculated() {
        return dateCalculated;
    }

    public Weather[] getWeathers() {
        return weathers;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public double getWindDegree() {
        return windDegree;
    }

    public float getClouds() {
        return clouds;
    }
}
