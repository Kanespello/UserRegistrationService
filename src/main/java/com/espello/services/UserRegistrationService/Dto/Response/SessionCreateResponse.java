package com.espello.services.UserRegistrationService.Dto.Response;

import com.espello.services.EspelloUtils.ResponseDto.Error;

public class SessionCreateResponse extends Error {

	private String sessionId;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@Override
	public String toString() {
		return "SessionCreateResponse [sessionId=" + sessionId + "]";
	}
}
