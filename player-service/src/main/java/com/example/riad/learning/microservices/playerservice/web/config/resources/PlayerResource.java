package com.example.riad.learning.microservices.playerservice.web.config.resources;

import com.example.riad.learning.microservices.playerservice.domains.Player;
import com.example.riad.learning.microservices.playerservice.web.controllers.PlayerController;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Getter
public class PlayerResource extends ResourceSupport {
    private final Player player;

    public PlayerResource(Player player) {
        this.player = player;
        final long id = this.player.getId();
        add(linkTo(PlayerController.class).withSelfRel());
    }
}
