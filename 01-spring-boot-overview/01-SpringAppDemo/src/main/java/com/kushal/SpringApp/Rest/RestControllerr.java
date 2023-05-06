package com.kushal.SpringApp.Rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerr {
    @GetMapping("/")
    public String sayHello(){
        return "Hello";
    }
}
