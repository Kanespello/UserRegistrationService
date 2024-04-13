package com.espello.services.UserRegistrationService.Enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RegistrationMediumConvertor implements AttributeConverter<RegistrationMedium, String> {

    @Override
    public String convertToDatabaseColumn(RegistrationMedium leadField){
        return leadField.getValue();
    }

    @Override
    public RegistrationMedium convertToEntityAttribute(String leadField){
        return RegistrationMedium.getByValue(leadField);
    }
}


