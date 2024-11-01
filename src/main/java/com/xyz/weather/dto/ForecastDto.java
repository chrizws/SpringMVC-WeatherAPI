package com.xyz.weather.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.xyz.weather.model.Day;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ForecastDto {

    @JsonProperty("forecastday")
    private List<Forecastday> forecastdays;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Forecastday {
        private String date;
        private DayDto day;
        private AstroDto astro;
    }
}
