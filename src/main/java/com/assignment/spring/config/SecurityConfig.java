package com.assignment.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    @Profile("dev")
    public UserDetailsService userDetailsServiceDev(PasswordEncoder encoder) {
        UserDetails admin = User.withUsername("admin")
                .password(encoder.encode("password"))
                .roles("ADMIN").build();
        return new InMemoryUserDetailsManager(admin);
    }

    @Bean
    @Profile("prod")
    public UserDetailsService userDetailsServiceProd(PasswordEncoder encoder) {
        UserDetails admin = User.withUsername("user")
                .password(encoder.encode("password"))
                .roles("USER").build();
        return new InMemoryUserDetailsManager(admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/**").hasAnyRole("USER","ADMIN")
                .antMatchers("/swagger-ui/**", "/v3/**").hasRole("ADMIN")
                .anyRequest()
                .authenticated().and().formLogin()
                .and()
                .httpBasic();
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}