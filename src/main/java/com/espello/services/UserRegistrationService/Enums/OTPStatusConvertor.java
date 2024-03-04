package com.espello.services.UserRegistrationService.Enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class OTPStatusConvertor implements AttributeConverter<OTPStatus, String> {

    @Override
    public String convertToDatabaseColumn(OTPStatus leadField){
        return leadField.getValue();
    }

    @Override
    public OTPStatus convertToEntityAttribute(String leadField){
        return OTPStatus.getByValue(leadField);
    }
}
