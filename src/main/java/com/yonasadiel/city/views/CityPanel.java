package com.yonasadiel.city.views;

import com.yonasadiel.city.City;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class CityPanel extends JPanel {
    private City city;
    private JLabel cityNameLabel;
    private JLabel cityCoordinateLabel;

    public CityPanel(City city) {
        this.city = city;

        cityNameLabel = new JLabel();
        cityNameLabel.setText(this.city.toString());
        cityNameLabel.setFont(new Font(cityNameLabel.getFont().getName(), Font.BOLD, 20));

        cityCoordinateLabel = new JLabel();
        cityCoordinateLabel.setText(this.city.getCoordinate().toString());

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setAlignmentX(LEFT_ALIGNMENT);
        this.setBorder(new CompoundBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10),
                new CompoundBorder(
                        BorderFactory.createLineBorder(Color.BLACK, 2),
                        BorderFactory.createEmptyBorder(5, 5, 5, 5)
                )
        ));
        this.add(cityNameLabel);
        this.add(cityCoordinateLabel);
    }
}
