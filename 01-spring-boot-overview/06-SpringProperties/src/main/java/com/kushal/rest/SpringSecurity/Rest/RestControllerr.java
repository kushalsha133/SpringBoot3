package com.kushal.rest.SpringSecurity.Rest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerr {

    @Value("${coach.name}")
    String coachName;
    @Value("${team.name}")
    String teamName;

    @GetMapping("/")
    public String sayHello(){
        return "Hello";
    }

    //expose new endpoint
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }
    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Lucky day ahead";
    }

    @GetMapping("/team")
    public String teamInfo(){
        return "TeamName = "+teamName+" Coach Name = "+coachName;
    }
}
