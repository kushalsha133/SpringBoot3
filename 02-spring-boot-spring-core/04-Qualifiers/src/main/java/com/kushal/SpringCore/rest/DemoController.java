package com.kushal.SpringCore.rest;

import com.kushal.SpringCore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //define a private field for dependency
    private Coach myCoach;

    //if you have multiple implementations of a bean, like in this case Coach,
    //you can mark one as @Primary then we wont have to give @Qualifier but the primary implementation will be used always
    @Autowired
    private DemoController(@Qualifier("tennisCoach") Coach myCoach){
        this.myCoach = myCoach;
    }

    //As autowired is used Spring will know that we have to se this for dependency injection hence
    //we do not have t actually use setter naming convention
//    @Autowired
//    public void setCoach(Coach myCoach){
//        this.myCoach = myCoach;
//    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
