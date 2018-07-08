package com.yonasadiel.weatherdata;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConditionTest {

  @Test
  public void getAvgTemp() {
    try {
      Temperature tempAvg = new Temperature(3.4, "Kelvin");
      Temperature tempMax = new Temperature(4.8, "Celcius");
      Temperature tempMin = new Temperature(2.0, "Reamur");
      Condition condition = new Condition(
          tempAvg, tempMax, tempMin,
          4.5, 7.8, 1.6,
          25);
      assertEquals(tempAvg, condition.getAvgTemp());
    } catch (Exception e) {
      assertFalse(true);
    }
  }

  @Test
  public void getMaxTemp() {
    try {
      Temperature tempAvg = new Temperature(3.4, "Kelvin");
      Temperature tempMax = new Temperature(4.8, "Celcius");
      Temperature tempMin = new Temperature(2.0, "Reamur");
      Condition condition = new Condition(
          tempAvg, tempMax, tempMin,
          4.5, 7.8, 1.6,
          25);
      assertEquals(tempMax, condition.getMaxTemp());
    } catch (Exception e) {
      assertFalse(true);
    }
  }

  @Test
  public void getMinTemp() {
    try {
      Temperature tempAvg = new Temperature(3.4, "Kelvin");
      Temperature tempMax = new Temperature(4.8, "Celcius");
      Temperature tempMin = new Temperature(2.0, "Reamur");
      Condition condition = new Condition(
          tempAvg, tempMax, tempMin,
          4.5, 7.8, 1.6,
          25);
      assertEquals(tempMin, condition.getMinTemp());
    } catch (Exception e) {
      assertFalse(true);
    }
  }

  @Test
  public void getPressure() {
    try {
      Temperature tempAvg = new Temperature(3.4, "Kelvin");
      Temperature tempMax = new Temperature(4.8, "Celcius");
      Temperature tempMin = new Temperature(2.0, "Reamur");
      Condition condition = new Condition(
          tempAvg, tempMax, tempMin,
          4.5, 7.8, 1.6,
          25);
      assertEquals(4.5, condition.getPressure(), 0.000000001);
    } catch (Exception e) {
      assertFalse(true);
    }
  }

  @Test
  public void getPressureSea() {
    try {
      Temperature tempAvg = new Temperature(3.4, "Kelvin");
      Temperature tempMax = new Temperature(4.8, "Celcius");
      Temperature tempMin = new Temperature(2.0, "Reamur");
      Condition condition = new Condition(
          tempAvg, tempMax, tempMin,
          4.5, 7.8, 1.6,
          25);
      assertEquals(7.8, condition.getPressureSea(), 0.000000001);
    } catch (Exception e) {
      assertFalse(true);
    }
  }

  @Test
  public void getPressureGround() {
    try {
      Temperature tempAvg = new Temperature(3.4, "Kelvin");
      Temperature tempMax = new Temperature(4.8, "Celcius");
      Temperature tempMin = new Temperature(2.0, "Reamur");
      Condition condition = new Condition(
          tempAvg, tempMax, tempMin,
          4.5, 7.8, 1.6,
          25);
      assertEquals(1.6, condition.getPressureGround(), 0.000000001);
    } catch (Exception e) {
      assertFalse(true);
    }
  }

  @Test
  public void getHumidity() {
    try {
      Temperature tempAvg = new Temperature(3.4, "Kelvin");
      Temperature tempMax = new Temperature(4.8, "Celcius");
      Temperature tempMin = new Temperature(2.0, "Reamur");
      Condition condition = new Condition(
          tempAvg, tempMax, tempMin,
          4.5, 7.8, 1.6,
          25);
      assertEquals(25, condition.getHumidity(), 0.000000001);
    } catch (Exception e) {
      assertFalse(true);
    }
  }
}