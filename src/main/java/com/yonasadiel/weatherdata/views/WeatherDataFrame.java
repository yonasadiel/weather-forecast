package com.yonasadiel.weatherdata.views;

import com.yonasadiel.city.City;
import com.yonasadiel.openweatherapi.OpenWeatherAPIConnection;
import com.yonasadiel.weatherdata.listeners.ForecastPanelMouseListener;
import com.yonasadiel.weatherdata.Forecast;
import com.yonasadiel.weatherdata.ForecastData;
import com.yonasadiel.weatherdata.Weather;
import com.yonasadiel.weatherdata.WeatherData;

import javax.swing.*;
import java.awt.*;

public class WeatherDataFrame extends JFrame {
    private City city;
    private HeaderPanel headerPanel;
    private WeatherPanel weatherPanel;
    private Weather[] weatherPerDay;

    public WeatherDataFrame(City city) {
        this.city = city;
        this.weatherPanel = new WeatherPanel(null);
        this.headerPanel = new HeaderPanel(this.city);
        this.weatherPerDay = new Weather[5];
        this.setLayout(new BorderLayout());

        this.setTitle(city.getName());
        this.add(this.headerPanel, BorderLayout.NORTH);
        this.add(this.weatherPanel, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);

        OpenWeatherAPIConnection con = new OpenWeatherAPIConnection(this.city.getId());
        try {
            WeatherData weatherData = con.getParsedWeatherData();
            ForecastData forecastData = con.getParsedForecastData();
            Forecast[] forecasts = forecastData.getForecasts();
            this.weatherPerDay[0] = weatherData;
            for (int i = 7, j = 1; i < forecasts.length && j < this.weatherPerDay.length; i += 8, j++) {
                this.weatherPerDay[j] = forecasts[i];
            }
            this.updateForecastPanelsSummary();
        } catch (Exception e) {
            //
        }
    }

    private void updateForecastPanelsSummary() {
        ForecastsPanel forecastsPanel = this.headerPanel.getForecastsPanel();
        for (int i = 0; i < this.weatherPerDay.length; i++) {
            ForecastPanel forecastPanel = forecastsPanel.getForecastPanels(i);
            forecastPanel.setWeather(this.weatherPerDay[i]);
            forecastPanel.addMouseListener(
                    new ForecastPanelMouseListener(this.weatherPanel, this.weatherPerDay[i])
            );
        }
    }
}
