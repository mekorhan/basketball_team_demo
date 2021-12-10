package com.producter.demo.service;

import com.producter.demo.entity.model.PlayerModel;

import java.util.List;

public interface PlayerService {
    PlayerModel addPlayer(PlayerModel playerModel);

    void deletePlayer(Long playerId);

    List<PlayerModel> inquireAllPlayers();
}
