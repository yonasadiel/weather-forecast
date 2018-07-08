package com.yonasadiel.city.views;

import javax.swing.*;
import java.awt.*;

public class SearchFrame extends JFrame {
  private SearchPanel searchPanel;

  public SearchFrame() {
    this.searchPanel = new SearchPanel();
    this.setLayout(new BorderLayout());

    this.setTitle("Weather Forecast");
    this.add(this.searchPanel, BorderLayout.CENTER);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.pack();
    this.setVisible(true);
  }
}
