package com.assignment.spring.converter.impl;

import com.assignment.spring.constants.Constants;
import com.assignment.spring.converter.WeatherMapper;
import com.assignment.spring.model.MainDto;
import com.assignment.spring.model.SysDto;
import com.assignment.spring.model.WeatherResponse;
import com.assignment.spring.repository.WeatherEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Mapping service for weatherApp.
 * @author cudrea
 */
@Service
public class WeatherMapperImpl implements WeatherMapper {
    /**
     * Weather response mapper to generate database-ready format
     * @param response the WeatherResponse
     * @return the new entity
     */
    public WeatherEntity mapWeatherResponse(WeatherResponse response) {
        WeatherEntity entity = new WeatherEntity();
        //TODO - consider defining a custom Exception and replace with <<orElseThrow>> to properly handle weather api
        //malfunctioning
        entity.setCity(Optional.ofNullable(response.getName()).orElse(Constants.EMPTY));
        entity.setCountry(Optional.ofNullable(response.getSys()).map(SysDto::getCountry).orElse(Constants.EMPTY));
        entity.setTemperature(Optional.ofNullable(response.getMain()).map(MainDto::getTemp).orElse(Double.NaN));
        return entity;
    }
}
