package com.yonasadiel.city.listeners;

import com.yonasadiel.city.City;
import com.yonasadiel.weatherdata.views.WeatherDataFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CityResultPanelMouseListener implements MouseListener {
    private City city;

    public CityResultPanelMouseListener(City city) {
        this.city = city;
    }

    public void mouseClicked(MouseEvent e) {
        new WeatherDataFrame(this.city);
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
