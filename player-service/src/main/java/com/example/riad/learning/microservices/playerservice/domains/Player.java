package com.example.riad.learning.microservices.playerservice.domains;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
    private Type type;

    public Player(String name, String country, Type type) {
        this.name = name;
        this.country = country;
        this.type = type;
    }

    public static enum Type{
        BATSMAN, BOWLER, ALLROUNDER, WicketKeeper
    }

}
