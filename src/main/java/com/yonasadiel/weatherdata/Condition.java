package com.yonasadiel.weatherdata;

public class Condition {
    private Temperature avgTemp;
    private Temperature maxTemp;
    private Temperature minTemp;
    private double pressure;
    private double pressureGround;
    private double pressureSea;
    private float humidity;

    public Condition(Temperature avgTemp, Temperature maxTemp, Temperature minTemp,
                     double pressure, double pressureSea, double pressureGround,
                     float humidity) {
        this.avgTemp = avgTemp;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.pressure = pressure;
        this.pressureSea = pressureSea;
        this.pressureGround = pressureGround;
        this.humidity = humidity;
    }

    public Temperature getAvgTemp() {
        return avgTemp;
    }

    public Temperature getMaxTemp() {
        return maxTemp;
    }

    public Temperature getMinTemp() {
        return minTemp;
    }

    public double getPressure() {
        return pressure;
    }

    public double getPressureSea() {
        return pressureSea;
    }

    public double getPressureGround() {
        return pressureGround;
    }

    public float getHumidity() {
        return humidity;
    }
}
