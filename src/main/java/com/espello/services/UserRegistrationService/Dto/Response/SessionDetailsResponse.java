package com.espello.services.UserRegistrationService.Dto.Response;

import java.time.LocalDateTime;

import com.espello.services.EspelloUtils.ResponseDto.Error;
import com.espello.services.UserRegistrationService.Dto.SessionDetailsDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

public class SessionDetailsResponse extends Error {

    private String sessionId;
    
    private SessionDetailsDTO sessionDetails;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="IST")
    private LocalDateTime sessionStartTime;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="IST")
    private LocalDateTime sessionEndTime;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public SessionDetailsDTO getSessionDetails() {
		return sessionDetails;
	}

	public void setSessionDetails(SessionDetailsDTO sessionDetails) {
		this.sessionDetails = sessionDetails;
	}

	public LocalDateTime getSessionStartTime() {
		return sessionStartTime;
	}

	public void setSessionStartTime(LocalDateTime sessionStartTime) {
		this.sessionStartTime = sessionStartTime;
	}

	public LocalDateTime getSessionEndTime() {
		return sessionEndTime;
	}

	public void setSessionEndTime(LocalDateTime sessionEndTime) {
		this.sessionEndTime = sessionEndTime;
	}

	@Override
	public String toString() {
		return "SessionDetailsResponse [sessionId=" + sessionId + ", sessionDetails=" + sessionDetails
				+ ", sessionStartTime=" + sessionStartTime + ", sessionEndTime=" + sessionEndTime + "]";
	}
}
