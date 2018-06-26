import com.yonasadiel.city.views.SearchFrame;
import com.yonasadiel.openweatherapi.OpenWeatherAPIConnection;
import com.yonasadiel.weatherdata.WeatherData;
import mdlaf.MaterialLookAndFeel;

import javax.swing.*;
import java.util.logging.Logger;

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
