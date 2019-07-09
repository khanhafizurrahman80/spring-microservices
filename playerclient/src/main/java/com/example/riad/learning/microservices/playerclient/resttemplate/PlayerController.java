package com.example.riad.learning.microservices.playerclient.resttemplate;

import com.example.riad.learning.microservices.playerclient.domains.Player;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/players")
@Conditional(NotFeignAndNotWebClientCondition.class)
@Slf4j
public class PlayerController {

    private PlayerServiceClient client;

    @Autowired
    public PlayerController(PlayerServiceClient client) {
        this.client = client;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET, produces = "application/json")
    public List<Player> fetchplayerList() {
        System.out.println("playerList");
        return (List<Player>) client.getAllPlayers();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Player fetchPlayer(@PathVariable("id") Long id){
        System.out.println(client.fetchplayer(id).getCountry());
        return client.fetchplayer(id);
    }
}
