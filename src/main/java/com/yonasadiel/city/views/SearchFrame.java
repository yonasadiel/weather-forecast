package com.yonasadiel.city.views;

import javax.swing.*;

public class SearchFrame extends JFrame {

    public SearchFrame() {
        this.setTitle("Weather Forecast");
        this.setContentPane(new SearchPanel());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
}
