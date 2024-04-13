package com.espello.services.UserRegistrationService.Dto;

import java.util.List;

import jakarta.validation.constraints.NotNull;

public class SessionAnalysisDTO {

	@NotNull
    private String sessionId;
    
	@NotNull
	private List<AnalysisParam> analysisParams;

	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public List<AnalysisParam> getAnalysisParams() {
		return analysisParams;
	}
	public void setAnalysisParams(List<AnalysisParam> analysisParams) {
		this.analysisParams = analysisParams;
	}

	@Override
	public String toString() {
		return "SessionAnalysisDTO [sessionId=" + sessionId + ", analysisParams=" + analysisParams + "]";
	}
}
