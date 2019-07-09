package com.example.riad.learning.microservices.playerservice.web.controllers;

import com.example.riad.learning.microservices.playerservice.web.config.resources.PlayerResource;
import com.example.riad.learning.microservices.playerservice.domains.Player;
import com.example.riad.learning.microservices.playerservice.services.Interfaces.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/players")
@Slf4j
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @RequestMapping(path="/", method = RequestMethod.GET)
    public ResponseEntity<Resources<PlayerResource>> fetchPlayers(){
        System.out.println("service: player class");
        List<PlayerResource> playerResources = this.playerService.fetchPlayers().stream().map(PlayerResource::new).collect(Collectors.toList());
        final Resources<PlayerResource> resources = new Resources<>(playerResources);
        final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
        resources.add(new Link(uriString, "self"));
        return ResponseEntity.ok(resources);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Player fetchPlayer(@PathVariable Long id){
        System.out.println("service: player class");
        return this.playerService.fetchPlayer(id);
    }




}

