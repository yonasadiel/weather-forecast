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
    return this.avgTemp;
  }

  public Temperature getMaxTemp() {
    return this.maxTemp;
  }

  public Temperature getMinTemp() {
    return this.minTemp;
  }

  public double getPressure() {
    return this.pressure;
  }

  public double getPressureSea() {
    return this.pressureSea;
  }

  public double getPressureGround() {
    return this.pressureGround;
  }

  public float getHumidity() {
    return this.humidity;
  }

  @Override
  public String toString() {
    return "Condition{" +
           "avgTemp=" + avgTemp +
           ", maxTemp=" + maxTemp +
           ", minTemp=" + minTemp +
           ", pressure=" + pressure +
           ", pressureGround=" + pressureGround +
           ", pressureSea=" + pressureSea +
           ", humidity=" + humidity +
           '}';
  }
}
