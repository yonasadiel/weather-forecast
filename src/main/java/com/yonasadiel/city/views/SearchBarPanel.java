package com.yonasadiel.city.views;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

public class SearchBarPanel extends JPanel {
    private JButton searchButton;
    private JLabel citySearchTextFieldLabel;
    private JTextField citySearchTextField;

    public SearchBarPanel() {
        citySearchTextFieldLabel = new JLabel();
        citySearchTextFieldLabel.setText("City Name: ");

        citySearchTextField = new JTextField();
        citySearchTextField.setColumns(30);
        citySearchTextField.setBorder(new CompoundBorder(
                citySearchTextField.getBorder(),
                BorderFactory.createEmptyBorder(0, 10, 0, 10)
        ));

        searchButton = new JButton();
        searchButton.setText("Search");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Logger.getLogger("a").info(citySearchTextField.getText());
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        this.add(citySearchTextFieldLabel);
        this.add(citySearchTextField);
        this.add(searchButton);
    }
}
