package com.yonasadiel.openweatherapi;

import com.yonasadiel.weatherdata.WeatherData;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class OpenWeatherAPIConnection {
    private int featureCount;
    private String apiKey;
    private String cityName;
    private String featureModel;
    private String featureType;
    private String featureUnit;
    private String plan;

    public OpenWeatherAPIConnection(String plan, String cityName) {
        Dotenv dotenv = Dotenv.load();
        this.apiKey = dotenv.get("API_KEY");
        this.cityName = cityName;
        this.plan = plan;
        this.featureCount = 7;
        this.featureModel = "json";
        this.featureType = "like";
        this.featureUnit = "metric";
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setFeatureCount(int featureCount) {
        this.featureCount = featureCount;
    }

    public void setFeatureModel(String featureModel) {
        this.featureModel = featureModel;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public void setFeatureType(String featureType) {
        this.featureType = featureType;
    }

    public void setFeatureUnit(String featureUnit) {
        this.featureUnit = featureUnit;
    }

    private String getUrl() {
        String queryUrl = "https://api.openweathermap.org/data/2.5/";
        queryUrl += this.plan;
        queryUrl += "?q=" + this.cityName;
        queryUrl += "&appid=" + this.apiKey;
        queryUrl += "&cnt=" + this.featureCount;
        queryUrl += "&model=" + this.featureModel;
        queryUrl += "&type=" + this.featureType;
        queryUrl += "&units=" + this.featureUnit;

        return queryUrl;
    }

    private String getString() throws Exception {
        try {
            URL url = new URL(this.getUrl());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            con.disconnect();

            return content.toString();
        } catch (Exception e) {
            throw e;
        }
    }

    public WeatherData getParsed() throws Exception {
        ResponseParser parser = ResponseParser.getInstance();
        return parser.parseResponse(this.getString());
    }
}
