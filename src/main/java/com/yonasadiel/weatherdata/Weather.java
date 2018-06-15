package com.yonasadiel.weatherdata;

public class Weather {
    private Condition condition;
    private String description;
    private int id;
    private int iconId;

    public Weather(Condition condition, String description, int id, int iconId) {
        this.condition = condition;
        this.description = description;
        this.id = id;
        this.iconId = iconId;
    }

    public Condition getCondition() {
        return condition;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public int getIconId() {
        return iconId;
    }
}
