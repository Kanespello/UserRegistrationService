package com.espello.services.UserRegistrationService.Enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum RegistrationMedium {
	EMAIl("email"),
	MOBILE("mobile"),
    GSIGNUP("gsignup");

    private String value;

    RegistrationMedium(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    public static RegistrationMedium getByValue(String value) {
        for (RegistrationMedium ctaAction : RegistrationMedium.values()){
            if (ctaAction.getValue().equals(value)){
                return ctaAction;
            }
        }
        throw new UnsupportedOperationException("The code " + value + " is not supported!");
    }
}

