package com.example.riad.learning.microservices.playerservice.services.Interfaces;

import com.example.riad.learning.microservices.playerservice.domains.Player;

import java.util.List;

public interface PlayerService {
    public List<Player> fetchPlayers();
    public Player fetchPlayer(Long id);
}
