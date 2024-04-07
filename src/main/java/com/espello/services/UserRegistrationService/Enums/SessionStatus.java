package com.espello.services.UserRegistrationService.Enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SessionStatus {
	ACTIVE("active"),
    HISTORY("history");

    private String value;

    SessionStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    public static SessionStatus getByValue(String value) {
        for (SessionStatus ctaAction : SessionStatus.values()){
            if (ctaAction.getValue().equals(value)){
                return ctaAction;
            }
        }
        throw new UnsupportedOperationException("The code " + value + " is not supported!");
    }
}
