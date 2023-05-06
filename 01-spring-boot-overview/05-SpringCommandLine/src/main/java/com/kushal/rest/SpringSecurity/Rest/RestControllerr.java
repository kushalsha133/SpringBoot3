package com.kushal.rest.SpringSecurity.Rest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerr {
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
}
