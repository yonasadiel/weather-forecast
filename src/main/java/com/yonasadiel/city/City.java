package com.yonasadiel.city;

public class City {
    public int id;
    public String name;
    public Coordinate coordinate;
    public String country;

    public City(int id, String name, Coordinate coordinate, String country) {
        this.id = id;
        this.name = name;
        this.coordinate = coordinate;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public String getCountry() {
        return country;
    }

    public boolean similarNameWith(String name) {
        return this.name.toLowerCase().contains(name.toLowerCase());
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinate=" + coordinate +
                ", country='" + country + '\'' +
                '}';
    }
}
