package com.xyz.weather.data;

import com.xyz.weather.dto.WeatherDTO;
import com.xyz.weather.model.Weather;

import java.util.*;

public class Data {

    public static WeatherDTO getWeatherDto() {
        WeatherDTO dto = new WeatherDTO();

        WeatherDTO.Location location = new WeatherDTO.Location();
        location.setName("Oakville");
        location.setRegion("Ontario");
        location.setCountry("Canada");
        location.setLat(43.4333);
        location.setLon(-79.6667);
        location.setTz_id("America/Toronto");
        location.setLocaltime("2024-10-28 14:10");

        WeatherDTO.Current current = new WeatherDTO.Current();
        current.setLast_updated("2024-10-28 14:00");
        current.setTemp_c(11.6);
        current.setTemp_f(52.9);
        current.setIs_day(1);
        current.setHumidity(68);

//        WeatherDTO.Current.Condition condition = new WeatherDTO.Current.Condition();
//        condition.setText("Sunny");
//        condition.setIcon("sunny.jpg");
//
//        current.setCondition(condition);

        dto.setLocation(location);
        dto.setCurrent(current);

        return dto;
    }


    public static String getCurrentWeather() {
        return """
                {
                \t"location": {
                \t\t"name": "Oakville",
                \t\t"region": "Ontario",
                \t\t"country": "Canada",
                \t\t"lat": 43.4333,
                \t\t"lon": -79.6667,
                \t\t"tz_id": "America/Toronto",
                \t\t"localtime_epoch": 1730139041,
                \t\t"localtime": "2024-10-28 14:10"
                \t},
                \t"current": {
                \t\t"last_updated_epoch": 1730138400,
                \t\t"last_updated": "2024-10-28 14:00",
                \t\t"temp_c": 11.6,
                \t\t"temp_f": 52.9,
                \t\t"is_day": 1,
                \t\t"condition": {
                \t\t\t"text": "Sunny",
                \t\t\t"icon": "//cdn.weatherapi.com/weather/64x64/day/113.png",
                \t\t\t"code": 1000
                \t\t},
                \t\t"wind_mph": 11.0,
                \t\t"wind_kph": 17.6,
                \t\t"wind_degree": 98,
                \t\t"wind_dir": "E",
                \t\t"pressure_mb": 1028.0,
                \t\t"pressure_in": 30.37,
                \t\t"precip_mm": 0.0,
                \t\t"precip_in": 0.0,
                \t\t"humidity": 69,
                \t\t"cloud": 0,
                \t\t"feelslike_c": 9.6,
                \t\t"feelslike_f": 49.3,
                \t\t"windchill_c": 8.9,
                \t\t"windchill_f": 48.1,
                \t\t"heatindex_c": 11.3,
                \t\t"heatindex_f": 52.4,
                \t\t"dewpoint_c": 7.6,
                \t\t"dewpoint_f": 45.6,
                \t\t"vis_km": 10.0,
                \t\t"vis_miles": 6.0,
                \t\t"uv": 2.2,
                \t\t"gust_mph": 12.6,
                \t\t"gust_kph": 20.3
                \t}
                }""";
    }

    public static String getForecastWeather() {
        return "";
    }
}
