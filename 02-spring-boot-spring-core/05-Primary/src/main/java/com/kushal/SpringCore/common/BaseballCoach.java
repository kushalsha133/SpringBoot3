package com.kushal.SpringCore.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Spend 30mins in Daily Practice";
    }
}
