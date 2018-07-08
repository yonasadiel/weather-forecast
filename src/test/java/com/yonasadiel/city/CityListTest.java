package com.yonasadiel.city;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class CityListTest {
  private CityList cityList;

  @Before
  public void setUp() throws Exception {
    this.cityList = CityList.getInstance();
  }

  @Test
  public void findCitiesByName() {
    ArrayList<City> cityListSemarang = this.cityList.findCitiesByName("SemarAng");
    assertEquals(1, cityListSemarang.size());

    ArrayList<City> cityListGeneric = this.cityList.findCitiesByName("a");
    assertNotEquals(0, cityListGeneric.size());

    ArrayList<City> cityListRandom = this.cityList.findCitiesByName("asjkdgahskvdb");
    assertEquals(0, cityListRandom.size());
  }
}