package com.producter.demo.service.impl;

import com.producter.demo.constants.Constants;
import com.producter.demo.constants.GeneralEnumerationDefinition;
import com.producter.demo.entity.PlayerEntity;
import com.producter.demo.entity.model.PlayerModel;
import com.producter.demo.repo.PlayerRepository;
import com.producter.demo.service.PlayerService;
import com.producter.demo.utils.StringUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PlayerModel addPlayer(PlayerModel playerModel) {
        if (!playerModelValidator(playerModel))
            throw new IllegalStateException("Player is not valid");

        int playerSize = playerRepository.findAll().size();
        if (playerSize >= Constants.BASKETBALL_TEAM_MAXIMUM_CAPACITY)
            throw new IllegalStateException("Team at maximum capacity");

        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setCreateAt(new Date());
        playerEntity.setName(playerModel.getName());
        playerEntity.setSurname(playerModel.getSurname());
        playerEntity.setPosition(playerModel.getPosition());
        playerEntity = playerRepository.save(playerEntity);
        return modelMapper.map(playerEntity, PlayerModel.class);
    }

    @Override
    public void deletePlayer(Long playerId) {
        if (playerId < 1)
            throw new IllegalStateException("player id is not valid");

        playerRepository.deleteById(playerId);
    }

    @Override
    public List<PlayerModel> inquireAllPlayers() {
        List<PlayerEntity> playerEntities = playerRepository.findAll();
        return modelMapper.map(playerEntities, new TypeToken<List<PlayerModel>>() {
        }.getType());
    }

    private boolean playerModelValidator(PlayerModel playerModel) {
        if (StringUtils.isEmptyAndNull(playerModel.getName())
                || StringUtils.isEmptyAndNull(playerModel.getSurname())
                || StringUtils.isEmptyAndNull(playerModel.getPosition()))
            return false;

        if (!validatePosition(playerModel.getPosition()))
            return false;

        return true;
    }

    public boolean validatePosition(String code) {
        boolean isValidated = false;
        for (GeneralEnumerationDefinition.Positions p : GeneralEnumerationDefinition.Positions.values()) {
            if (Objects.equals(code, p.getCode())) {
                isValidated = true;
                break;
            }
        }
        return isValidated;
    }
}
