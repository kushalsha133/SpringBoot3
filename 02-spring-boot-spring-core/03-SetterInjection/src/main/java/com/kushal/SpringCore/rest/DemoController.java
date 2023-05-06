package com.kushal.SpringCore.rest;

import com.kushal.SpringCore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //define a private fieldfordependency
    private Coach myCoach;

//    @Autowired
//    private DemoController(Coach myCoach){
//        this.myCoach = myCoach;
//    }

    //As autowired is used Spring willknow that we have to se this for dependency injection hence
    //we do not have t actually use setter naming convention
    @Autowired
    public void setCoach(Coach myCoach){
        this.myCoach = myCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
