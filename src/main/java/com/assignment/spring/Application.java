package com.assignment.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

@SpringBootApplication
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) - could remove data autoconfiguration but then you will encounter
//other db config issues, such as
@EnableJpaRepositories("com.assignment.spring.repository")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
