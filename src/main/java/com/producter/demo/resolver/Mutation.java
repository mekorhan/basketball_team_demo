package com.producter.demo.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.producter.demo.constants.Constants;
import com.producter.demo.constants.GeneralEnumerationDefinition.Positions;
import com.producter.demo.model.Player;
import com.producter.demo.model.PlayerInput;
import com.producter.demo.repo.PlayerRepository;
import com.producter.demo.utils.PlayerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private PlayerRepository playerRepository;

    public Player addPlayer(PlayerInput playerInput) {
        boolean isValidRequest = PlayerValidator.getInstance().validateRequest(playerInput);

        if (!isValidRequest) {
            throw new IllegalStateException("Request is not valid. Please check this request: " + playerInput.toString());
        }

        int playerSize = playerRepository.findAll().size();
        if (playerSize >= Constants.BASKETBALL_TEAM_MAXIMUM_CAPACITY)
            throw new IllegalStateException("Team at maximum capacity");

        Player player = new Player();
        player.setName(playerInput.getName());
        player.setSurname(playerInput.getSurname());
        player.setPositions(Positions.valueOf(playerInput.getPosition()));
        return playerRepository.save(player);
    }

    public Long deletePlayer(Long id) {
        if (id < 1)
            throw new IllegalStateException("Player id is not valid. id: " + id);

        Optional<Player> player = playerRepository.findById(id);
        if (!player.isPresent())
            throw new IllegalStateException("This player id didn't exist. id: " + id);

        playerRepository.deleteById(id);
        return id;
    }
}
