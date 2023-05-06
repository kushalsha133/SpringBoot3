package com.kushal.SpringCore.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach{

    public CricketCoach(){
        System.out.println("In Constructor "+getClass().getSimpleName());
    }

    //define init method
    @PostConstruct
    public void startup(){
        System.out.println("In Bean Startup "+getClass().getSimpleName());
    }
    //define destroy method
    //Destroy won't be called for Prototype Scope
    @PreDestroy
    public void PostDestroy(){
        System.out.println("In Bean Cleanup/Destroy "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice Fast Bowling!!! :-)";
    }
}
