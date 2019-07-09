package com.example.riad.learning.microservices.playerservice.services;

import com.example.riad.learning.microservices.playerservice.domains.Player;
import com.example.riad.learning.microservices.playerservice.services.Interfaces.PlayerService;
import com.example.riad.learning.microservices.playerservice.repos.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<Player> fetchPlayers() {
        List<Player> players = new ArrayList<Player>();
        playerRepository.findAll().forEach(players::add);
        return players;
    }

    @Override
    public Player fetchPlayer(Long id) {
        return this.playerRepository.findById(id).get();
    }
}
