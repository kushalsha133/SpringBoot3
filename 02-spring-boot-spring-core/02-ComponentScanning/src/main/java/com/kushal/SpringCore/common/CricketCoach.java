package com.kushal.SpringCore.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Practice Fast Bowling!!!";
    }
}
