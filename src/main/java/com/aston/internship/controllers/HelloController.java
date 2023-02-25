package com.aston.internship.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/** Test controller*/

@RestController
public class HelloController {
    @GetMapping(value = "/hello")
    public String hello (){
        return "Hello!";
    }
}
