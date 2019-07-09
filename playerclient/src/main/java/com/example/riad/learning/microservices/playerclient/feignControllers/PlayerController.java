package com.example.riad.learning.microservices.playerclient.feignControllers;

import com.example.riad.learning.microservices.playerclient.domains.Player;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players")
@Profile("feign")
@Slf4j
public class PlayerController {
    private PlayerClient client;


    public PlayerController(PlayerClient client) {
        this.client = client;
    }

    @GetMapping(value = "/{id}")
    public Player fetchPlayer(@PathVariable("id") Long id){
        System.out.println("fetch player");
        System.out.println(this.client.fetchPlayer(id).toString());
        return this.client.fetchPlayer(id);
//        return "reached";
    }

}
