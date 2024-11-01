package com.xyz.weather.controller;

import com.xyz.weather.service.WeatherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class WeatherDeleteController {

    private final WeatherServiceImpl weatherServiceImpl;

    @Autowired
    public WeatherDeleteController(WeatherServiceImpl weatherServiceImpl) {
        this.weatherServiceImpl = weatherServiceImpl;
    }

    @PostMapping(value = "/delete/{id}", produces = "application/json")
    public String deleteWeather(@PathVariable String id) {
        boolean isDeleted = weatherServiceImpl.deleteWeatherById(id);

        if (isDeleted) {
            return "{\n" +
                    "\t\"status\": \"success\"\n" +
                    "}";
        } else {
            return "{\n" +
                    "\t\"status\": \"failed\"\n" +
                    "}";
        }
    }
}
