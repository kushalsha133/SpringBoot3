package com.kushal.SpringCore.config;

import com.kushal.SpringCore.common.Coach;
import com.kushal.SpringCore.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
