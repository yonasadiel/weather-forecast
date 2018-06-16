package com.yonasadiel.city.views;

import com.yonasadiel.city.City;
import com.yonasadiel.city.Coordinate;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.util.ArrayList;

public class SearchResultPanel extends JPanel {
    private ArrayList<CityPanel> cityPanelArrayList;

    public SearchResultPanel() {
        this.cityPanelArrayList = new ArrayList<CityPanel>();
        this.cityPanelArrayList.add(new CityPanel(
                new City(
                        1,
                        "Jakarta",
                        new Coordinate(12, 13),
                        "ID"
                )
        ));
        this.cityPanelArrayList.add(new CityPanel(
                new City(
                        2,
                        "Semarang",
                        new Coordinate(12, 13),
                        "ID"
                )
        ));

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        for (CityPanel cityPanel: cityPanelArrayList) {
            cityPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
            this.add(cityPanel);
        }
    }
}
