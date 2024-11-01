package com.xyz.weather.proxy;

import com.xyz.weather.dto.WeatherDTO;
import com.xyz.weather.model.Weather;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="current", url="${weather.url}")
public interface WeatherProxy {

    @GetMapping("/v1/forecast.json")
    WeatherDTO getForecastWeather(@RequestParam String key, @RequestParam String q,
                              @RequestParam String aqi,
                              @RequestParam String alerts,
                              @RequestParam String days);
}
