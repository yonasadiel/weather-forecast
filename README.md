# Wheater Forecast

Simple weather forecast java app using [Open Weather API](https://openweathermap.org/api)

## Open Weather API

API is abbreviation from Application Programming Interface.
Basically, it allows interaction between two or more programs.
Usually, web programming using API for its endpoint, so other programs
may use/give information to/from the endpoint.

There are some api in Open Weather API,
but this program only use one API, the [16 day/daily API](https://openweathermap.org/forecast16).
Program will send GET request with city name to search, and get list of cities match with 7 day forecast.

## Package Structure

    weather-forecast/
    |__src
       |__com
          |__yonasadiel
             |__openwheaterapi
             |  |__OpenWeatherAPIConnection
             |  |__ResponseParser
             |__city
             |  |__City
             |  |__Coordinate
             |__weatherdata
             |  |__Condition
             |  |__Forecast
             |  |__Temperature
             |  |__Weather
             |  |__WeatherData
             |__WeatherForecast

The package use yonasadiel.com domain,
because in Java, package may be conflict with other programs,
so it is better to use our own domain to package naming,

The package divided to features not by layer [(ref)](https://dzone.com/articles/package-your-classes-feature),
for some benefits like higher modularity, easier code navigation,
higher level of abstraction, separates features and layers, and some more.

## Checklist

### To Do
* all of exception
* unit test
* Java Swing GUI

### Done
* `openweatherapi` package
* `city` model
* `weatherdata` model