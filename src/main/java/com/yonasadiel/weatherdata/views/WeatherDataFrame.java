package com.yonasadiel.weatherdata.views;

import com.yonasadiel.city.City;
import com.yonasadiel.openweatherapi.OpenWeatherAPIConnection;
import com.yonasadiel.weatherdata.WeatherData;

import javax.swing.*;
import java.awt.*;

public class WeatherDataFrame extends JFrame {
    private City city;
    private HeaderPanel headerPanel;
    private WeatherPanel weatherPanel;

    public WeatherDataFrame(City city) {
        this.city = city;
        this.headerPanel = new HeaderPanel(this.city);
        this.weatherPanel = new WeatherPanel(null);
        this.setLayout(new BorderLayout());

        this.setTitle(city.getName());
        this.add(this.headerPanel, BorderLayout.NORTH);
        this.add(this.weatherPanel, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);

        OpenWeatherAPIConnection con = new OpenWeatherAPIConnection("forecast", this.city.getId());
        try {
            WeatherData weatherData = con.getParsedWeatherData();
        } catch (Exception e) {
            //
        }
    }
}
