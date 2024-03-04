package com.espello.services.UserRegistrationService.Enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class VerificationModuleConvertor implements AttributeConverter<VerificationModule, String> {

    @Override
    public String convertToDatabaseColumn(VerificationModule leadField){
        return leadField.getValue();
    }

    @Override
    public VerificationModule convertToEntityAttribute(String leadField){
        return VerificationModule.getByValue(leadField);
    }
}
