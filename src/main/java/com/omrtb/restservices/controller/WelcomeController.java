package com.omrtb.restservices.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
    @GetMapping("/")
    public String list(){
        return "welcome";
    }
    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }
}