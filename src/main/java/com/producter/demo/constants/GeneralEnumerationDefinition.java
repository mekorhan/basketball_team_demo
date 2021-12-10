package com.producter.demo.constants;

import java.util.Objects;

public class GeneralEnumerationDefinition {
    public enum Positions {
        POINT_GUARD("PG"),
        SHOOTING_GUARD("SG"),
        SMALL_FORWARD("SF"),
        POWER_FORWARD("PF"),
        CENTER("C");

        private String code;

        Positions(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}
