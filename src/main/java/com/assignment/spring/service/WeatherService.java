package com.assignment.spring.service;

import com.assignment.spring.repository.WeatherEntity;

public interface WeatherService {
    WeatherEntity processWeatherResult(String cityCode);
}
