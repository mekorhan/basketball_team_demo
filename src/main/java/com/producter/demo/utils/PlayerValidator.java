package com.producter.demo.utils;

import com.producter.demo.constants.GeneralEnumerationDefinition;
import com.producter.demo.model.PlayerInput;

import java.util.Objects;

public final class PlayerValidator {
    private static PlayerValidator playerValidator = null;

    private PlayerValidator() {

    }

    public synchronized static PlayerValidator getInstance() {
        if (Objects.isNull(playerValidator)) {
            playerValidator = new PlayerValidator();
            return playerValidator;
        }
        return playerValidator;
    }

    public boolean validateRequest(PlayerInput playerInput) {
        boolean isValid = false;

        if (StringUtils.isEmptyAndNull(playerInput.getName())
                || StringUtils.isEmptyAndNull(playerInput.getSurname())
                || StringUtils.isEmptyAndNull(playerInput.getPosition()))
            return false;

        for (GeneralEnumerationDefinition.Positions p : GeneralEnumerationDefinition.Positions.values()) {
            if (Objects.equals(p.name(), playerInput.getPosition())) {
                isValid = true;
                break;
            }
        }
        if (!isValid) {
            return false;
        }

        return true;
    }
}
