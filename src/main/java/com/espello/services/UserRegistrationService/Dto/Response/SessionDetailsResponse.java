package com.espello.services.UserRegistrationService.Dto.Response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SessionDetailsResponse {

    private String sessionId;
    
    private String role;
    
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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
		return "SessionDetailsResponse [sessionId=" + sessionId + ", role=" + role + ", sessionStartTime="
				+ sessionStartTime + ", sessionEndTime=" + sessionEndTime + "]";
	}

}
