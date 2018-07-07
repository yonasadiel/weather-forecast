package com.yonasadiel.city;

import static org.junit.Assert.*;

public class CityTest {

  @org.junit.Test
  public void getId() {
    Coordinate coordinate = new Coordinate(2.3, 4.5);
    City city = new City(34, "Jakarta", coordinate, "ID");
    assertEquals(34, city.getId());
  }

  @org.junit.Test
  public void getName() {
    Coordinate coordinate = new Coordinate(2.3, 4.5);
    City city = new City(34, "Jakarta", coordinate, "ID");
    assertEquals("Jakarta", city.getName());
  }

  @org.junit.Test
  public void getCoordinate() {
    Coordinate coordinate = new Coordinate(2.3, 4.5);
    City city = new City(34, "Jakarta", coordinate, "ID");
    assertEquals(coordinate, city.getCoordinate());
  }

  @org.junit.Test
  public void getCountry() {
    Coordinate coordinate = new Coordinate(2.3, 4.5);
    City city = new City(34, "Jakarta", coordinate, "ID");
    assertEquals("ID", city.getCountry());
  }

  @org.junit.Test
  public void similarNameWith() {
    Coordinate coordinate = new Coordinate(2.3, 4.5);
    City city = new City(34, "Jakarta", coordinate, "ID");
    assertTrue(city.similarNameWith("jakArTA"));
    assertTrue(city.similarNameWith("akAr"));
    assertFalse(city.similarNameWith("bakar"));
  }

  @org.junit.Test
  public void testToString() {
    Coordinate coordinate1 = new Coordinate(2.3, 4.5);
    City city1 = new City(34, "Jakarta", coordinate1, "ID");
    assertEquals("Jakarta, ID", city1.toString());

    Coordinate coordinate2 = new Coordinate(2.3, 4.5);
    City city2 = new City(34, "Washington, DC", coordinate2, "US");
    assertEquals("Washington, DC, US", city2.toString());
  }
}