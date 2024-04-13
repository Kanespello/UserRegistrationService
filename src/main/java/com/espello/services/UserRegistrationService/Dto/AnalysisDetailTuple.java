package com.espello.services.UserRegistrationService.Dto;

public class AnalysisDetailTuple {

	private String analysisParam;
	private String analysisParamDesc;
	private Integer analysisParamScore;
	
	public String getAnalysisParam() {
		return analysisParam;
	}
	public void setAnalysisParam(String analysisParam) {
		this.analysisParam = analysisParam;
	}
	public String getAnalysisParamDesc() {
		return analysisParamDesc;
	}
	public void setAnalysisParamDesc(String analysisParamDesc) {
		this.analysisParamDesc = analysisParamDesc;
	}
	public Integer getAnalysisParamScore() {
		return analysisParamScore;
	}
	public void setAnalysisParamScore(Integer analysisParamScore) {
		this.analysisParamScore = analysisParamScore;
	}
	@Override
	public String toString() {
		return "AnalysisDetailTuple [analysisParam=" + analysisParam + ", analysisParamDesc=" + analysisParamDesc
				+ ", analysisParamScore=" + analysisParamScore + "]";
	}
	
}
