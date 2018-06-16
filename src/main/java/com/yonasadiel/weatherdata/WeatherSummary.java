package com.yonasadiel.weatherdata;

public class WeatherSummary {
    private String description;
    private String summary;
    private String iconId;
    private int id;

    public WeatherSummary(int id, String summary, String description, String iconId) {
        this.summary = summary;
        this.description = description;
        this.id = id;
        this.iconId = iconId;
    }

    public int getId() {
        return this.id;
    }

    public String getSummary() {
        return this.summary;
    }

    public String getDescription() {
        return this.description;
    }

    public String getIconId() {
        return this.iconId;
    }

    @Override
    public String toString() {
        return "WeatherSummary{" +
                "description='" + this.getDescription() + '\'' +
                ", summary='" + this.getSummary() + '\'' +
                ", iconId='" + this.getIconId() + '\'' +
                ", id=" + this.getId() +
                '}';
    }
}
