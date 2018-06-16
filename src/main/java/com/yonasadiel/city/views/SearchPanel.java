package com.yonasadiel.city.views;

import javax.swing.*;
import java.awt.*;

public class SearchPanel extends JPanel {
    private SearchBarPanel searchBarPanel;
    private SearchResultPanel searchResultPanel;

    public SearchPanel() {
        this.searchBarPanel = new SearchBarPanel();
        this.searchResultPanel = new SearchResultPanel();

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.searchBarPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.searchResultPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.add(this.searchBarPanel);
        this.add(this.searchResultPanel);
    }
}
