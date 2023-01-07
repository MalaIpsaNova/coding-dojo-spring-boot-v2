package com.assignment.spring.repository;

import org.springframework.data.repository.CrudRepository;


public interface WeatherRepository extends CrudRepository<WeatherEntity, Integer> {
}
