package com.xyz.weather.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.xyz.weather.model.Weather;
import com.xyz.weather.service.WeatherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.JobStateReasons;
import java.util.List;

@Controller
public class WeatherController {

    private final WeatherServiceImpl weatherServiceImpl;

    @Autowired
    public WeatherController(WeatherServiceImpl weatherServiceImpl) {
        this.weatherServiceImpl = weatherServiceImpl;
    }

    @GetMapping("/")
    public String data(Model model) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        Iterable<Weather> weather = weatherServiceImpl.getAllWeather();
        model.addAttribute("jsonObj", mapper.writeValueAsString(weather));

        return "index";
    }

    @GetMapping(value = "/find", produces = "application/json")
    @ResponseBody
    public String find(@RequestParam(value="location") String location,
                       @RequestParam(value = "days", required = false, defaultValue = "1") String days) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        //mapper.registerModule(new JavaTimeModule());

        Weather weather = weatherServiceImpl.getWeather(location, days, "no", "no");
        return mapper.writeValueAsString(weather);
    }

}
