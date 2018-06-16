package com.yonasadiel.city.views;

import com.yonasadiel.city.City;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SearchResultPanel extends JPanel {
    private ArrayList<CityPanel> cityPanelArrayList;

    public SearchResultPanel() {
        this.cityPanelArrayList = new ArrayList<CityPanel>();
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    public void setCityResult(ArrayList<City> cityResult) {
        this.cityPanelArrayList.clear();
        for (int i = 0; i < Math.min(5, cityResult.size()); i++) {
            CityPanel cityPanel = new CityPanel(cityResult.get(i));
            cityPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
            this.cityPanelArrayList.add(cityPanel);
            this.add(cityPanel);
        }

        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        topFrame.pack();
    }
}
