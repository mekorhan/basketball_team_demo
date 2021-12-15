//package com.producter.demo.resolver;
//
//import com.producter.demo.constants.Constants;
//import com.producter.demo.constants.GeneralEnumerationDefinition;
//import com.producter.demo.model.Player;
//import com.producter.demo.repo.PlayerRepository;
//import org.junit.Test;
//import org.junit.jupiter.api.AfterAll;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.util.Assert;
//
//class QueryTest {
//    @Autowired
//    private PlayerRepository playerRepository;
//
//    @Test
//    void players() {
//        for (int i = 0; i < Constants.BASKETBALL_TEAM_MAXIMUM_CAPACITY; i++) {
//            Player playerInput = new Player();
//            playerInput.setName("Enes");
//            playerInput.setSurname("Korhan");
//            playerInput.setPositions(GeneralEnumerationDefinition.Positions.PF);
//            playerRepository.save(playerInput);
//        }
//
//        Assert.isTrue(playerRepository.findAll().size() == Constants.BASKETBALL_TEAM_MAXIMUM_CAPACITY,
//                String.valueOf(playerRepository.findAll().size()));
//        deleteAllPlayers();
//    }
//
//    @AfterAll
//    void deleteAllPlayers() {
//        playerRepository.deleteAll();
//    }
//}