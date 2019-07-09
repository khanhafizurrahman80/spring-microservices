package com.example.riad.learning.microservices.playerclient.webclient;

import com.example.riad.learning.microservices.playerclient.domains.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Profile("webclient")
public class PlayerServiceWebClient {

    private WebClient.Builder wcBuilder;

    @Autowired
    public PlayerServiceWebClient(@LoadBalanced WebClient.Builder wcBuilder) {
        this.wcBuilder = wcBuilder;
    }

    public Mono<Player> getPlayerById(Long id){
        return wcBuilder.build()
                .get()
                .uri("http://player-service/players/{id}", id)
                .retrieve().bodyToMono(Player.class);
    }
}
