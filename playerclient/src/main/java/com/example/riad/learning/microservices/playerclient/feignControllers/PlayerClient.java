package com.example.riad.learning.microservices.playerclient.feignControllers;

import com.example.riad.learning.microservices.playerclient.domains.Player;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient("player-service")
@FeignClient("zuul-api-gateway")
public interface PlayerClient {

    @GetMapping("/player-service/players/{id}")
    Player fetchPlayer(@PathVariable("id") Long id);
}
