package com.yonasadiel.weatherdata.views;

import com.yonasadiel.weatherdata.Weather;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ForecastPanel extends JPanel {
  private JLabel dateLabel;
  private JLabel weatherSummaryLabel;
  private Weather weather;

  public ForecastPanel(int difference) {
    this.weather = null;
    this.dateLabel = new JLabel();
    this.dateLabel.setFont(new Font(dateLabel.getFont().getName(), Font.BOLD, 20));
    this.setDay(difference);

    this.weatherSummaryLabel = new JLabel();
    this.weatherSummaryLabel.setText("Loading ...");

    this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    this.setAlignmentX(LEFT_ALIGNMENT);
    this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    this.setBorder(new CompoundBorder(
        BorderFactory.createEmptyBorder(10, 10, 10, 10),
        new CompoundBorder(
            BorderFactory.createLineBorder(Color.getHSBColor((float) 0.55, (float) 0.9, (float) 0.8), 2),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)
        )
    ));
    this.add(dateLabel);
    this.add(weatherSummaryLabel);
  }

  public void setDay(int difference) {
    Date date = new Date();
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat formatter = new SimpleDateFormat("dd MMM");

    calendar.setTime(date);
    calendar.add(Calendar.DATE, difference);
    date = calendar.getTime();
    this.dateLabel.setText(formatter.format(date));
  }

  public void setWeather(Weather weather) {
    this.weather = weather;
    this.weatherSummaryLabel.setText(weather.getWeatherSummaries()[0].getSummary());
    this.repaint();
  }
}
