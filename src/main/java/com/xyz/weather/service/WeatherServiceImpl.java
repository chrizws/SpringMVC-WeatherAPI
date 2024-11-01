package com.xyz.weather.service;

import com.xyz.weather.dto.ForecastDto;
import com.xyz.weather.dto.WeatherDTO;
import com.xyz.weather.model.Day;
import com.xyz.weather.model.Weather;
import com.xyz.weather.proxy.WeatherProxy;
import com.xyz.weather.repository.DaysRepository;
import com.xyz.weather.repository.DaysRepositoryImpl;
import com.xyz.weather.repository.WeatherRepository;
import com.xyz.weather.repository.WeatherRepositoryImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherServiceImpl {

    private final RestTemplate restTemplate;
    private final WeatherRepository weatherRepository;

    private final WeatherProxy weatherProxy;

    @Value("${weather.api}")
    private String API_KEY;

    @Autowired
    public WeatherServiceImpl(RestTemplate restTemplate, WeatherRepository weatherRepository, WeatherProxy weatherProxy) {
        this.restTemplate = restTemplate;
        this.weatherRepository = weatherRepository;
        this.weatherProxy = weatherProxy;
    }

    public WeatherDTO getWeatherDto(String location, String days, String aqi, String alerts) {

        WeatherDTO dto = weatherProxy.getForecastWeather(API_KEY, location, aqi, alerts, days);
        return dto;
    }


    public Weather getWeather(String location, String days, String aqi, String alerts) {
        WeatherDTO dto = getWeatherDto(location, days, aqi, alerts);

        //convert to entity
        Weather weather = weatherDtoToEntity(dto);

        saveWeather(weather);

        return weather;
    }

    private Weather weatherDtoToEntity(WeatherDTO dto) {

        Weather weather = Weather.builder()
                .days(createDaysEntity(dto.getForecast()))
                .name(dto.getLocation().getName())
                .region(dto.getLocation().getRegion())
                .country(dto.getLocation().getCountry())
                .lat(dto.getLocation().getLat())
                .lon(dto.getLocation().getLon())
                .timezone(dto.getLocation().getTz_id())
                .local_time(dto.getLocation().getLocaltime())
                .last_updated(dto.getCurrent().getLast_updated())
                .temp_c(dto.getCurrent().getTemp_c())
                .temp_f(dto.getCurrent().getTemp_f())
                .humidity(dto.getCurrent().getHumidity())
                .weatherIcon(dto.getCurrent().getCondition().getIcon())
                .weatherStatus(dto.getCurrent().getCondition().getText())
                .build();

        return weather;

    }

    private List<Day> createDaysEntity(ForecastDto forecastDto) {

        List<Day> days = new ArrayList<>();
        forecastDto.getForecastdays().forEach(forecastday -> {
            Day day = Day.builder()
                    .date(forecastday.getDate())
                    //.weather(weather)
                    .avghumidity(forecastday.getDay().getAvghumidity())
                    .avgtemp_c(forecastday.getDay().getAvgtemp_c())
                    .avgtemp_f(forecastday.getDay().getAvgtemp_f())
                    .daily_chance_of_rain(forecastday.getDay().getDaily_chance_of_rain())
                    .daily_chance_of_snow(forecastday.getDay().getDaily_chance_of_snow())
                    .maxtemp_c(forecastday.getDay().getMaxtemp_c())
                    .maxtemp_f(forecastday.getDay().getMaxtemp_f())
                    .mintemp_c(forecastday.getDay().getMintemp_c())
                    .mintemp_f(forecastday.getDay().getMintemp_f())
                    .totalprecip_mm(forecastday.getDay().getTotalprecip_mm())
                    .totalsnow_cm(forecastday.getDay().getTotalsnow_cm())
                    .weatherIcon(forecastday.getDay().getCondition().getIcon())
                    .weatherStatus(forecastday.getDay().getCondition().getText())
                    .weatherCode(forecastday.getDay().getCondition().getCode())
                    .sunrise(forecastday.getAstro().getSunrise())
                    .sunset(forecastday.getAstro().getSunset())
                    .moonrise(forecastday.getAstro().getMoonrise())
                    .moonset(forecastday.getAstro().getMoonset())
                    .build();

            days.add(day);
        });
        return days;
    }


    public void saveWeather(Weather cw) {
        weatherRepository.saveWeather(cw);
    }

    public Iterable<Weather> getAllWeather() {
        return weatherRepository.getAllWeather();
    }
    public Weather getWeatherById(String id) {
        return weatherRepository.getWeatherById(id);
    }

    @Transactional
    public boolean deleteWeatherById(String id) {
        return weatherRepository.deleteWeatherById(id);
    }
}
