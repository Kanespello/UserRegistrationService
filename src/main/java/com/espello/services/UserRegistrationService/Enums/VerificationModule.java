package com.espello.services.UserRegistrationService.Enums;
import com.fasterxml.jackson.annotation.JsonValue;


public enum VerificationModule {
	EMAIL("email"),
    MOBILE("mobile");

    private String value;

    VerificationModule(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    public static VerificationModule getByValue(String value) {
        for (VerificationModule ctaAction : VerificationModule.values()){
            if (ctaAction.getValue().equals(value)){
                return ctaAction;
            }
        }
        throw new UnsupportedOperationException("The code " + value + " is not supported!");
    }
}
