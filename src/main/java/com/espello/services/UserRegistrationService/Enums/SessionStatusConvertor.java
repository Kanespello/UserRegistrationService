package com.espello.services.UserRegistrationService.Enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class SessionStatusConvertor implements AttributeConverter<SessionStatus, String> {

    @Override
    public String convertToDatabaseColumn(SessionStatus leadField){
        return leadField.getValue();
    }

    @Override
    public SessionStatus convertToEntityAttribute(String leadField){
        return SessionStatus.getByValue(leadField);
    }
}
