package com.yonasadiel.weatherdata.exceptions;

public class UnknownTemperatureUnitException extends Exception {
  private String unitName;

  public UnknownTemperatureUnitException(String unitName) {
    super("Unknown Temperature unit: " + unitName);
    this.unitName = unitName;
  }
}
