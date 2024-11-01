package com.xyz.weather.repository;

import com.xyz.weather.model.Weather;

import java.util.List;

public interface WeatherRepository {


//    @Query("DELETE FROM Weather WHERE id = ?1")

    Weather saveWeather(Weather weather);
    List<Weather> getAllWeather();
    Weather getWeatherById(String id);
    boolean deleteWeatherById(String id);

}
