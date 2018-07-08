package com.yonasadiel.openweatherapi;

import com.yonasadiel.weatherdata.ForecastData;
import com.yonasadiel.weatherdata.WeatherData;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class OpenWeatherAPIConnection {
  private String apiKey;
  private String featureModel;
  private String featureUnit;
  private String plan;
  private int cityId;

  public OpenWeatherAPIConnection(int cityId) {
    Dotenv dotenv = Dotenv.load();
    this.apiKey = dotenv.get("API_KEY");
    this.cityId = cityId;
    this.plan = "weather";
    this.featureModel = "json";
    this.featureUnit = "metric";
  }

  public void setCityId(int cityId) {
    this.cityId = cityId;
  }

  public void setFeatureModel(String featureModel) {
    this.featureModel = featureModel;
  }

  public void setPlan(String plan) {
    this.plan = plan;
  }

  public void setFeatureUnit(String featureUnit) {
    this.featureUnit = featureUnit;
  }

  private String getUrl() {
    String queryUrl = "https://api.openweathermap.org/data/2.5/";
    queryUrl += this.plan;
    queryUrl += "?id=" + this.cityId;
    queryUrl += "&appid=" + this.apiKey;
    queryUrl += "&model=" + this.featureModel;
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

  public ForecastData getParsedForecastData() throws Exception {
    ResponseParser parser = ResponseParser.getInstance();
    this.plan = "forecast";
    return parser.parseForecastResponse(this.getString());
  }

  public WeatherData getParsedWeatherData() throws Exception {
    ResponseParser parser = ResponseParser.getInstance();
    this.plan = "weather";
    return parser.parseWeatherResponse(this.getString());
  }
}
