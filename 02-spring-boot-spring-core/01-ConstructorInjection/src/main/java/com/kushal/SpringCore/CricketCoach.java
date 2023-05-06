package com.kushal.SpringCore;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Practice Fast Bowling!!!";
    }
}
