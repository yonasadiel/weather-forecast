package com.yonasadiel.weatherdata;

import static org.junit.Assert.*;

import com.yonasadiel.weatherdata.exceptions.UnknownTemperatureUnitException;
import org.junit.Assert;
import org.junit.Test;

public class TemperatureTest {

  @Test
  public void getKelvin() {
    try {
      Temperature temp = new Temperature(2.3, "Kelvin");
      assertEquals(2.3, temp.getKelvin(), 0.000000001);
    } catch (Exception e) {
      Assert.fail(e.getMessage());
    }
  }

  @Test
  public void getCelcius() {
    try {
      Temperature temp = new Temperature(1.9, "Celcius");
      assertEquals(1.9, temp.getCelcius(), 0.000000001);
    } catch (Exception e) {
      Assert.fail(e.getMessage());
    }
  }

  @Test
  public void getFarenheit() {
    try {
      Temperature temp = new Temperature(3.6, "Farenheit");
      assertEquals(3.6, temp.getFarenheit(), 0.000000001);
    } catch (Exception e) {
      Assert.fail(e.getMessage());
    }
  }

  @Test
  public void getReamur() {
    try {
      Temperature temp = new Temperature(7.2, "Reamur");
      assertEquals(7.2, temp.getReamur(), 0.000000001);
    } catch (Exception e) {
      Assert.fail(e.getMessage());
    }
  }

  @Test(expected = UnknownTemperatureUnitException.class)
  public void unknownType() throws Exception {
    Temperature temp = new Temperature(7.3, "wrong unit");
  }
}