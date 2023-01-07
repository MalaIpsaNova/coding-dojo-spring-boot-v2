package com.assignment.spring;

import com.assignment.spring.repository.WeatherRepository;
import org.springframework.boot.test.mock.mockito.MockBean;

public abstract class BaseControllerServicesTest {
    @MockBean
    protected WeatherRepository weatherRepository;
}
