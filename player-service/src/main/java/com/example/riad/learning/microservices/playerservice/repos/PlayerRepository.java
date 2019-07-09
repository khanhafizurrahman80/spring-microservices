package com.example.riad.learning.microservices.playerservice.repos;

import com.example.riad.learning.microservices.playerservice.domains.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {

}
