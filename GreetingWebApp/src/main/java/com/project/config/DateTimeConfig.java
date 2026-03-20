package com.project.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalTime;

@Configuration
public class DateTimeConfig {

    @Bean
    public LocalTime generateTime(){
        return LocalTime.now();
    }

}
