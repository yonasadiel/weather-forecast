package com.yonasadiel;

import com.yonasadiel.city.views.SearchFrame;
import mdlaf.MaterialLookAndFeel;

import javax.swing.*;

public class WeatherForecast {

  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel(new MaterialLookAndFeel());
      new SearchFrame();
    }
    catch (UnsupportedLookAndFeelException e) {
      e.printStackTrace ();
    }
  }
}
