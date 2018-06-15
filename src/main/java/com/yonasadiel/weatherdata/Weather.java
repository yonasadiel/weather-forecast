package com.yonasadiel.weatherdata;

public class Weather {
    private String description;
    private String summary;
    private String iconId;
    private int id;

    public Weather(int id, String summary, String description, String iconId) {
        this.summary = summary;
        this.description = description;
        this.id = id;
        this.iconId = iconId;
    }

    public int getId() {
        return id;
    }

    public String getSummary() {
        return summary;
    }

    public String getDescription() {
        return description;
    }

    public String getIconId() {
        return iconId;
    }
}
