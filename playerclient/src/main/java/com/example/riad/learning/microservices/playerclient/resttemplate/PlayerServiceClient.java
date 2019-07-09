package com.example.riad.learning.microservices.playerclient.resttemplate;

import com.example.riad.learning.microservices.playerclient.domains.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Conditional(NotFeignAndNotWebClientCondition.class)
public class PlayerServiceClient {

    private RestTemplate rest;

    @Autowired
    public PlayerServiceClient(@LoadBalanced RestTemplate rest) {
        this.rest = rest;
    }

    public List<Player> getAllPlayers(){
        System.out.println("getAllPlayers");
//        System.out.println(rest.getForObject("http://localhost:8000/players/", Player.class).getCountry());
//        Player [] players = rest.getForObject("http://localhost:8000/players/", Player[].class);
        ResponseEntity<List<Player>> responseEntity = rest.exchange("http://localhost:8000/players/", HttpMethod.GET, null, new ParameterizedTypeReference<List<Player>>() {});
        return responseEntity.getBody();
    }

    public Player fetchplayer(Long playerId){
        return rest.getForObject("http://player-service/players/{id}", Player.class, playerId);
    }


}
