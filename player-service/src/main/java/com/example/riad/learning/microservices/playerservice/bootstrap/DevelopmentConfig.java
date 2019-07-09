package com.example.riad.learning.microservices.playerservice.bootstrap;

import com.example.riad.learning.microservices.playerservice.domains.Player;
import com.example.riad.learning.microservices.playerservice.repos.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DevelopmentConfig {
    @Bean
    public CommandLineRunner dataLoader(PlayerRepository repo){
        return args -> {
            repo.save(new Player("Rohit", "India", Player.Type.BATSMAN));
            repo.save(new Player("Warner", "Australia", Player.Type.BATSMAN));
            repo.save(new Player("Shakib", "Bangladesh", Player.Type.ALLROUNDER));
            repo.save(new Player("Joe Root", "England", Player.Type.BATSMAN));
            repo.save(new Player("F Du plesis", "South Africa", Player.Type.BATSMAN));
            repo.save(new Player("Ben Stokes", "England", Player.Type.ALLROUNDER));
            repo.save(new Player("AT Carey", "Australia", Player.Type.WicketKeeper));
            repo.save(new Player("MA Starc", "Australia", Player.Type.BOWLER));
            repo.save(new Player("Imran Tahir", "South Africa", Player.Type.BOWLER));
            repo.save(new Player("JJ Bumrah", "India",Player.Type.BOWLER));
            repo.save(new Player("Mohammad Amir", "Pakistan", Player.Type.BOWLER));
        };
    }
}
