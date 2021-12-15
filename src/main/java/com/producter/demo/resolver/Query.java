package com.producter.demo.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.producter.demo.model.Player;
import com.producter.demo.repo.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {
    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> players() {
        return playerRepository.findAll();
    }
}
