package com.yonasadiel.city.views;

import com.yonasadiel.city.City;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SearchResultPanel extends JPanel {
  private ArrayList<CityResultPanel> cityResultPanelArrayList;

  public SearchResultPanel() {
    this.cityResultPanelArrayList = new ArrayList<CityResultPanel>();
    this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
  }

  public void setCityResult(ArrayList<City> cityResult) {
    this.cityResultPanelArrayList.clear();
    this.removeAll();
    for (int i = 0; i < Math.min(5, cityResult.size()); i++) {
      CityResultPanel cityResultPanel = new CityResultPanel(cityResult.get(i));
      cityResultPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
      this.cityResultPanelArrayList.add(cityResultPanel);
      this.add(cityResultPanel);
    }

    JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
    topFrame.pack();
  }
}
