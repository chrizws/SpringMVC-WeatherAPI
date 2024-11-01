package com.xyz.weather.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDTO {

    private Location location;
    private Current current;
    @JsonProperty("forecast")
    private ForecastDto forecast;

    @Data
    @NoArgsConstructor
    public static class Location {
        private String name;
        private String region;
        private String country;
        private double lat;
        private double lon;
        private String tz_id;
        private String localtime;

    }

    @Data
    @NoArgsConstructor
    public static class Current {
        private String last_updated;
        private double temp_c;
        private double temp_f;
        private int is_day;
        private double humidity;

        @JsonProperty("condition")
        private ConditionDto condition;

    }


}
