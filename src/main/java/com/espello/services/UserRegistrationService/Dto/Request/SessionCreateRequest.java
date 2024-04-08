package com.espello.services.UserRegistrationService.Dto.Request;

import com.espello.services.UserRegistrationService.Dto.SessionDetailsDTO;

import jakarta.validation.constraints.NotNull;

public class SessionCreateRequest {
	
	@NotNull
 	private Integer userId;
 	
    private SessionDetailsDTO sessionDetails;;
 
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public SessionDetailsDTO getSessionDetails() {
		return sessionDetails;
	}

	public void setSessionDetails(SessionDetailsDTO sessionDetails) {
		this.sessionDetails = sessionDetails;
	}

	@Override
	public String toString() {
		return "SessionCreateRequest [userId=" + userId + ", sessionDetails=" + sessionDetails + "]";
	}
	    
}
