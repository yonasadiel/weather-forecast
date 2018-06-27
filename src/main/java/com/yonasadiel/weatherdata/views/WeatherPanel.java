package com.yonasadiel.weatherdata.views;

import com.yonasadiel.weatherdata.Weather;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class WeatherPanel extends JPanel {
    private JLabel humidityLabel;
    private JLabel pressureLabel;
    private JLabel summaryLabel;
    private JLabel tempLabel;
    private JLabel windLabel;
    private Weather weather;

    public WeatherPanel(Weather weather) {
        this.humidityLabel = new JLabel();
        this.pressureLabel = new JLabel();
        this.summaryLabel = new JLabel();
        this.tempLabel = new JLabel();
        this.windLabel = new JLabel();
        this.setWeather(weather);

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setAlignmentX(LEFT_ALIGNMENT);
        this.setBorder(new CompoundBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10),
                new CompoundBorder(
                        BorderFactory.createLineBorder(Color.getHSBColor((float) 0.55, (float) 0.9, (float) 0.8), 2),
                        BorderFactory.createEmptyBorder(5, 5, 5, 5)
                )
        ));
        this.add(this.summaryLabel);
        this.add(this.tempLabel);
        this.add(this.pressureLabel);
        this.add(this.humidityLabel);
        this.add(this.windLabel);
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
        this.setHumidityLabelText();
        this.setPressureLabelText();
        this.setSummaryLabelText();
        this.setTempLabelText();
        this.setWindLabelText();
    }

    private void setHumidityLabelText() {
        String humidityText = "Humidity: ";
        if (this.weather != null) {
            humidityText += this.weather.getCondition().getHumidity();
            humidityText += "%";
        } else {
            humidityText += "-";
        }
        this.humidityLabel.setText(humidityText);
    }

    private void setPressureLabelText() {
        String pressureText = "Pressure: ";
        if (this.weather != null) {
            pressureText += this.weather.getCondition().getPressure();
            pressureText += "hPa (Ground: ";
            pressureText += this.weather.getCondition().getPressureGround();
            pressureText += "hPa, Sea: ";
            pressureText += this.weather.getCondition().getPressureSea();
            pressureText += "hPa)";
        } else {
            pressureText += "-";
        }
        this.pressureLabel.setText(pressureText);
    }

    private void setSummaryLabelText() {
        String summaryText = "Weather: ";
        if (this.weather != null) {
            summaryText += this.weather.getWeatherSummaries()[0].getSummary();
        } else {
            summaryText += "-";
        }
        this.summaryLabel.setText(summaryText);
    }

    private void setTempLabelText() {
        String tempText = "Temperature: ";
        if (this.weather != null) {
            tempText += this.weather.getCondition().getAvgTemp().getCelcius();
            tempText += "\u00b0C (Min: ";
            tempText += this.weather.getCondition().getMinTemp().getCelcius();
            tempText += "\u00b0C, Max: ";
            tempText += this.weather.getCondition().getMaxTemp().getCelcius();
            tempText += "\u00b0C)";
        } else {
            tempText += "-";
        }
        this.tempLabel.setText(tempText);
    }

    private void setWindLabelText() {
        String windText = "Wind: ";
        if (this.weather != null) {
            windText += this.weather.getWindSpeed();
            windText += "m/s ";
            windText += this.weather.getWindDegree();
            windText += "\u00b0";
        } else {
            windText += "-";
        }
        this.windLabel.setText(windText);
    }
}
