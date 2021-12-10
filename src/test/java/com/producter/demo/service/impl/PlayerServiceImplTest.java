package com.producter.demo.service.impl;

import com.producter.demo.constants.Constants;
import com.producter.demo.controller.PlayerController;
import com.producter.demo.entity.model.PlayerModel;
import com.producter.demo.repo.PlayerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import java.util.Objects;

@SpringBootTest
class PlayerServiceImplTest {

    @Autowired
    PlayerController playerController;

    @Autowired
    PlayerRepository playerRepository;

    @Test
    void addPlayer() {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setName("Enes");
        playerModel.setSurname("Korhan");
        playerModel.setPosition("SG");
        playerModel = ((PlayerModel) playerController.addPlayer(playerModel).getBody());
        Assert.isTrue(Objects.equals(playerModel.getName(), "Enes"), "PASS");
        Assert.isTrue(Objects.equals(playerModel.getSurname(), "Korhan"), "PASS");
        Assert.isTrue(Objects.equals(playerModel.getPosition(), "SG"), "PASS");
        deleteAllPlayers();
    }

    @Test
    void deletePlayer() {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setName("Enes");
        playerModel.setSurname("Korhan");
        playerModel.setPosition("SG");

        playerController.addPlayer(playerModel);
        Assert.isTrue(playerController.inquireAllPlayers().getBody().size() == 1
                , String.valueOf(playerController.inquireAllPlayers().getBody().size()));

        playerController.deletePlayer(playerRepository.findAll().get(0).getId());
        Assert.isTrue(playerController.inquireAllPlayers().getBody().size() == 0,
                String.valueOf(playerController.inquireAllPlayers().getBody().size()));
        deleteAllPlayers();
    }

    @Test
    void inquireAllPlayers() {
        for (int i = 0; i < Constants.BASKETBALL_TEAM_MAXIMUM_CAPACITY; i++) {
            PlayerModel playerModel = new PlayerModel();
            playerModel.setName("Enes");
            playerModel.setSurname("Korhan");
            playerModel.setPosition("SG");
            playerController.addPlayer(playerModel);
        }

        Assert.isTrue(playerController.inquireAllPlayers().getBody().size() == Constants.BASKETBALL_TEAM_MAXIMUM_CAPACITY,
                String.valueOf(playerController.inquireAllPlayers().getBody().size()));
        deleteAllPlayers();
    }

    @Test
    void validatePosition() {
        PlayerModel playerModel = new PlayerModel();
        playerModel.setName("Enes");
        playerModel.setSurname("Korhan");
        playerModel.setPosition("INVALID_POSITION");
        ResponseEntity<Object> response = playerController.addPlayer(playerModel);
        Assert.isTrue(response.getStatusCode() == HttpStatus.BAD_REQUEST, response.getStatusCode().name());

        String VALID_POSITION = "SF";
        playerModel = new PlayerModel();
        playerModel.setName("Enes");
        playerModel.setSurname("Korhan");
        playerModel.setPosition(VALID_POSITION);
        ResponseEntity<Object> responseOK = playerController.addPlayer(playerModel);
        Assert.isTrue(responseOK.getStatusCode() == HttpStatus.OK, responseOK.getStatusCode().name());
        deleteAllPlayers();
    }

    void deleteAllPlayers() {
        playerRepository.deleteAll();
    }
}