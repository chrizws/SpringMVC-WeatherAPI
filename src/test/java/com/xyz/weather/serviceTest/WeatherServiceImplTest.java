package com.xyz.weather.serviceTest;

import com.xyz.weather.data.Data;
import com.xyz.weather.dto.WeatherDTO;
import com.xyz.weather.proxy.WeatherProxy;
import com.xyz.weather.repository.WeatherRepository;
import com.xyz.weather.service.WeatherServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class WeatherServiceImplTest {

    @Mock
    private WeatherRepository weatherRepositoryMock;

    @Mock
    private WeatherProxy weatherProxyMock;

    @InjectMocks
    private WeatherServiceImpl weatherServiceImpl;

    @Test
    void testGetCurrentWeather() {
        String key = "abc";

        WeatherDTO dto = Data.getWeatherDto();
//        when(weatherProxyMock.getCurrentWeather(key, "abc", 2, "y", "s"))
//                .thenReturn(dto);
//
//        WeatherDTO weatherDTO = weatherService.getWeather(key,"abc", 2, "y", "s");
//
//        Assertions.assertThat(weatherDTO).isNotNull();
//        Assertions.assertThat(weatherDTO).isEqualTo(dto);



    }


}
