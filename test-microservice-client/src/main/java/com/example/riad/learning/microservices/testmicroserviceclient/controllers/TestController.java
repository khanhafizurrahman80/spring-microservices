package com.example.riad.learning.microservices.testmicroserviceclient.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tests")
@Slf4j
public class TestController {
    @GetMapping
    public String getString(){
        System.out.println("hi");
        return "Hello world!";
    }
}
