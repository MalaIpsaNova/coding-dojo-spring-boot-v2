package com.assignment.spring.service.impl;

import com.assignment.spring.constants.Constants;
import com.assignment.spring.converter.WeatherMapper;
import com.assignment.spring.model.WeatherResponse;
import com.assignment.spring.repository.WeatherEntity;
import com.assignment.spring.repository.WeatherRepository;
import com.assignment.spring.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private WeatherRepository weatherRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WeatherMapper mapper;

    @Value("${weather.apikey}")
    private String apiKey;
    @Override
    public WeatherEntity processWeatherResult(String cityCode) {
        String url = Constants.WEATHER_API_URL.replace("{city}", cityCode).replace("{appid}", apiKey);
        ResponseEntity<WeatherResponse> response = restTemplate.getForEntity(url, WeatherResponse.class);
        return weatherRepository.save(mapper.mapWeatherResponse(response.getBody()));
    }
}
