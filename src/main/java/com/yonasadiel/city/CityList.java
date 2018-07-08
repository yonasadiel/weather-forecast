package com.yonasadiel.city;

import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

public class CityList {
  private static CityList instance = new CityList();
  private ArrayList<City> cities = new ArrayList<City>();

  public ArrayList<City> findCitiesByName(String name) {
    ArrayList<City> similarCities = new ArrayList<City>();
    for (City city : this.cities) {
      if (city.similarNameWith(name)) {
        similarCities.add(city);
      }
    }
    return similarCities;
  }

  public static CityList getInstance() {
    return instance;
  }

  private CityList() {
    try {
      this.loadCSV();
    } catch (FileNotFoundException e) {
      Logger.getLogger("CityList").info(e.toString());
    } catch (IOException e) {
      Logger.getLogger("CityList").info(e.toString());
    }
  }

  private void loadCSV() throws IOException {
    String fileName = "com/yonasadiel/city/city.csv";
    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource(fileName).getFile());
    CSVReader reader = new CSVReader(new FileReader(file));
    String [] nextLine;

    while ((nextLine = reader.readNext()) != null) {
      // nextLine[] is an array of values from the line
      this.cities.add(new City(
          Integer.parseInt(nextLine[0]),
          nextLine[1],
          new Coordinate(
              Double.parseDouble(nextLine[3]),
              Double.parseDouble(nextLine[4])),
          nextLine[2]
      ));
    }
  }
}
