package com.example.riad.learning.microservices.playerclient.domains;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Player {
    private Long id;
    private String name;
    private String country;
    private Type type;

    public enum Type{
        BATSMAN, BOWLER, ALLROUNDER, WicketKeeper
    }
}
