package com.yonasadiel.city.views;

import com.yonasadiel.city.City;
import com.yonasadiel.weatherdata.views.WeatherDataFrame;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CityPanel extends JPanel implements MouseListener {
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
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setBorder(new CompoundBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10),
                new CompoundBorder(
                        BorderFactory.createLineBorder(Color.getHSBColor((float) 0.55, (float) 0.9, (float) 0.8), 2),
                        BorderFactory.createEmptyBorder(5, 5, 5, 5)
                )
        ));
        this.add(cityNameLabel);
        this.add(cityCoordinateLabel);
        this.addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        new WeatherDataFrame(this.city);
    }

    public void mousePressed(MouseEvent e) {
        //
    }

    public void mouseReleased(MouseEvent e) {
        //
    }

    public void mouseEntered(MouseEvent e) {
        //
    }

    public void mouseExited(MouseEvent e) {
        //
    }
}
