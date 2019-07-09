package com.example.riad.learning.microservices.playerclient.webclient;

import com.example.riad.learning.microservices.playerclient.domains.Player;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/players")
@Profile("webclient")
@Slf4j
public class PlayerController {
    private PlayerServiceWebClient playerServiceWebClient;

    public PlayerController(PlayerServiceWebClient playerServiceWebClient) {
        this.playerServiceWebClient = playerServiceWebClient;
    }

    @GetMapping(value = "/{id}")
    public Mono<Player> fetchPlayer(@PathVariable("id") Long id){
        System.out.println("Webclient");
        return this.playerServiceWebClient.getPlayerById(id);
    }
}
