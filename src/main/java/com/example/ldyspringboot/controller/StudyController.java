package com.example.ldyspringboot.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class StudyController {
    private final Logger logger = LogManager.getLogger();

    @GetMapping({"/","home"})
    public String home(){
        return "home";
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }

    @GetMapping("hello")
    public String hello(){
        return "hello";
    }
}
