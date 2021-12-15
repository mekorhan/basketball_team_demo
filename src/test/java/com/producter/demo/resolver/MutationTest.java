//package com.producter.demo.resolver;
//
//import com.producter.demo.constants.GeneralEnumerationDefinition;
//import com.producter.demo.model.Player;
//import com.producter.demo.model.PlayerInput;
//import com.producter.demo.repo.PlayerRepository;
//import org.junit.After;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.util.Assert;
//
//import java.util.Objects;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class MutationTest {
//
//    @Autowired
//    private Mutation mutation;
//
//    @Autowired
//    private PlayerRepository playerRepository;
//
//    @Test
//    void addPlayer() {
//        PlayerInput playerInput = new PlayerInput();
//        playerInput.setName("Enes");
//        playerInput.setSurname("Korhan");
//        playerInput.setPosition(GeneralEnumerationDefinition.Positions.PG.name());
//        Player player = mutation.addPlayer(playerInput);
//        Assert.isTrue(Objects.equals(player.getName(), "Enes"), "PASS");
//        Assert.isTrue(Objects.equals(player.getSurname(), "Korhan"), "PASS");
//        Assert.isTrue(Objects.equals(player.getPosition().name(), "PG"), "PASS");
//        deleteAllPlayers();
//    }
//
//    @Test
//    void deletePlayer() {
//        PlayerInput playerInput = new PlayerInput();
//        playerInput.setName("Enes");
//        playerInput.setSurname("Korhan");
//        playerInput.setPosition("SG");
//
//        mutation.addPlayer(playerInput);
//        Assert.isTrue(playerRepository.findAll().size() == 1
//                , String.valueOf(playerRepository.findAll().size()));
//
//        mutation.deletePlayer(playerRepository.findAll().get(0).getId());
//        Assert.isTrue(playerRepository.findAll().size() == 0,
//                String.valueOf(playerRepository.findAll().size()));
//        deleteAllPlayers();
//    }
//
//    @Test
//    void validatePosition() {
//        PlayerInput playerModel = new PlayerInput();
//        playerModel.setName("Enes");
//        playerModel.setSurname("Korhan");
//        playerModel.setPosition("INVALID_POSITION");
//        Assert.isTrue(playerRepository.findAll().size() == 0,
//                String.valueOf(playerRepository.findAll().size()));
//
//        deleteAllPlayers();
//    }
//
//    @After
//    void deleteAllPlayers() {
//        playerRepository.deleteAll();
//    }
//}