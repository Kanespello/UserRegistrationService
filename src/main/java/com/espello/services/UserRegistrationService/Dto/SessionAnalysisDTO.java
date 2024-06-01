package com.espello.services.UserRegistrationService.Dto;

import java.util.List;

import jakarta.validation.constraints.NotNull;

public class SessionAnalysisDTO {

	@NotNull
    private String sessionId;
	@NotNull
	private String caseTitle;
	@NotNull
	private String summary;
	@NotNull
	private List<AnalysisParam> analysisParams;
	
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getCaseTitle() {
		return caseTitle;
	}
	public void setCaseTitle(String caseTitle) {
		this.caseTitle = caseTitle;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public List<AnalysisParam> getAnalysisParams() {
		return analysisParams;
	}
	public void setAnalysisParams(List<AnalysisParam> analysisParams) {
		this.analysisParams = analysisParams;
	}
	
	@Override
	public String toString() {
		return "SessionAnalysisDTO [sessionId=" + sessionId + ", caseTitle=" + caseTitle + ", summary=" + summary
				+ ", analysisParams=" + analysisParams + "]";
	}

}
