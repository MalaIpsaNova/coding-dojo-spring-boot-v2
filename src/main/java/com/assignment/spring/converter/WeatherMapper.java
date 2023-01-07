package com.assignment.spring.converter;

import com.assignment.spring.model.WeatherResponse;
import com.assignment.spring.repository.WeatherEntity;

public interface WeatherMapper {
    WeatherEntity mapWeatherResponse(WeatherResponse response);
}
