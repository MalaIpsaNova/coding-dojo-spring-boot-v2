package com.assignment.spring.aop;

import com.assignment.spring.repository.WeatherEntity;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WeatherAspect {
    private static final Logger log = LoggerFactory.getLogger(WeatherAspect.class.getName());

    @Pointcut("execution(public * com.assignment.spring.controllers.WeatherController.*(..))")
    public void weatherControllerMethods() {
    }

    @AfterReturning(value = "weatherControllerMethods())", returning = "result")
    public void weatherDataAdvice(JoinPoint joinPoint, WeatherEntity result) {
        log.info("After method: {}", joinPoint.getSignature());
        log.info("Return Weather temperature: {} for country code: {}", result.getTemperature(), result.getCountry());
    }

    @AfterThrowing(value = "weatherControllerMethods()", throwing = "ex")
    public void weatherDataAdviceThrowing(JoinPoint joinPoint, Exception ex) {
        log.error("After Throwing exception in method: {}", joinPoint.getSignature());
        log.error("Exception is: {}, {}", ex.getMessage(), ex.getCause());
    }
}
