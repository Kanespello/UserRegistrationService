package com.espello.services.UserRegistrationService.Enums;
import com.fasterxml.jackson.annotation.JsonValue;


public enum OTPStatus {
	VERIFIED("verified"),
    UnVERIFIED("unverified");

    private String value;

    OTPStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    public static OTPStatus getByValue(String value) {
        for (OTPStatus ctaAction : OTPStatus.values()){
            if (ctaAction.getValue().equals(value)){
                return ctaAction;
            }
        }
        throw new UnsupportedOperationException("The code " + value + " is not supported!");
    }
}
