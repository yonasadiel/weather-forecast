package com.yonasadiel.weatherdata;

import com.yonasadiel.weatherdata.exceptions.UnknownTemperatureUnitException;

public class Temperature {
  private double kelvin;

  public Temperature(double value, String unit) throws Exception {
    if (unit.equals("Kelvin")) {
      this.kelvin = value;
    } else if (unit.equals("Celcius")) {
      this.kelvin = value + 273;
    } else if (unit.equals("Farenheit")) {
      this.kelvin = (value - 32) * 5 / 9 + 273;
    } else if (unit.equals("Reamur")) {
      this.kelvin = value * 5 / 4 + 273;
    } else {
      throw new UnknownTemperatureUnitException(unit);
    }
  }

  public double getKelvin() {
    return this.kelvin;
  }

  public double getCelcius() {
    return this.kelvin - 273;
  }

  public double getFarenheit() {
    return (this.kelvin - 273) * 9 / 5 + 32;
  }

  public double getReamur() {
    return (this.kelvin - 273) * 4 / 5;
  }

  @Override
  public String toString() {
    return "Temperature{" +
           "kelvin=" + this.getKelvin() +
           '}';
  }
}
