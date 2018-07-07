package com.yonasadiel.city;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoordinateTest {

  @Test
  public void getLat() {
    Coordinate coordinate = new Coordinate(2.3, 4.5);
    assertEquals(2.3, coordinate.getLat(), 0.000000001);
  }

  @Test
  public void getLon() {
    Coordinate coordinate = new Coordinate(2.3, 4.5);
    assertEquals(4.5, coordinate.getLon(), 0.000000001);
  }

  @Test
  public void testToString() {
    Coordinate coordinate = new Coordinate(2.3, 4.5);
    assertEquals("lat=2.3, lon=4.5", coordinate.toString());
  }
}