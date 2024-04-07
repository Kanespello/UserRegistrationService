package com.espello.services.UserRegistrationService.Dto;

import jakarta.validation.constraints.NotNull;

public class SessionAnalysisDTO {

	@NotNull
    private String sessionId;
    
    private String anlysisParam1;
    
    private String anlysisParam2;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getAnlysisParam1() {
		return anlysisParam1;
	}

	public void setAnlysisParam1(String anlysisParam1) {
		this.anlysisParam1 = anlysisParam1;
	}

	public String getAnlysisParam2() {
		return anlysisParam2;
	}

	public void setAnlysisParam2(String anlysisParam2) {
		this.anlysisParam2 = anlysisParam2;
	}

	@Override
	public String toString() {
		return "SessionAnalysisDTO [sessionId=" + sessionId + ", anlysisParam1=" + anlysisParam1 + ", anlysisParam2="
				+ anlysisParam2 + "]";
	}
	
}
