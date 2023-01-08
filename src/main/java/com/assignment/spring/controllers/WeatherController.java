package com.assignment.spring.controllers;

import com.assignment.spring.constants.Constants;
import com.assignment.spring.repository.WeatherEntity;
import com.assignment.spring.model.MainDto;
import com.assignment.spring.model.SysDto;
import com.assignment.spring.model.WeatherResponse;
import com.assignment.spring.repository.WeatherRepository;
import com.assignment.spring.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * Weather controller for weather-related operations
 * @author cudrea
 * @version 1.0
 */
@RestController
@RequestMapping("v1")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;


    /**
     * Endpoint to get weather report for provided city
     * @param request - to specify the city and appid token
     * @return WeatherResponse
     */
    @GetMapping("/weather/{city}")
    public WeatherEntity weather(@PathVariable String city) {
        return weatherService.processWeatherResult(city);
    }
}
