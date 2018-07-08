package com.yonasadiel.weatherdata.listeners;

import com.yonasadiel.weatherdata.Weather;
import com.yonasadiel.weatherdata.views.WeatherPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ForecastPanelMouseListener implements MouseListener {
  private WeatherPanel weatherPanel;
  private Weather weather;

  public ForecastPanelMouseListener(WeatherPanel weatherPanel, Weather weather) {
    this.weatherPanel = weatherPanel;
    this.weather = weather;
  }

  public void mouseClicked(MouseEvent e) {
    this.weatherPanel.setWeather(weather);
  }

  public void mousePressed(MouseEvent e) {}

  public void mouseReleased(MouseEvent e) {}

  public void mouseEntered(MouseEvent e) {}

  public void mouseExited(MouseEvent e) {}
}
