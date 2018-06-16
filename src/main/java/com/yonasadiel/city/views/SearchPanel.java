package com.yonasadiel.city.views;

import com.yonasadiel.city.City;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SearchPanel extends JPanel {
    private SearchBarPanel searchBarPanel;
    private SearchResultPanel searchResultPanel;
    private ArrayList<City> cityResult;

    public SearchPanel() {
        this.cityResult = new ArrayList<City>();
        this.searchBarPanel = new SearchBarPanel();
        this.searchResultPanel = new SearchResultPanel();

        this.setLayout(new BorderLayout());
        this.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.searchBarPanel.setSearchResultPanel(this.searchResultPanel);

        this.add(this.searchBarPanel, BorderLayout.NORTH);
        this.add(this.searchResultPanel, BorderLayout.CENTER);
    }
}
