package com.example.riad.learning.microservices.playerclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

// 3 ways: WebClient, Resttemplate, Feign
@EnableEurekaClient
@SpringBootApplication
public class PlayerclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlayerclientApplication.class, args);
    }

}
