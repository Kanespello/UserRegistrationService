package com.espello.services.UserRegistrationService.Dto;

import java.util.List;

public class AnalysisParam {

    private AnalysisDetailTuple analysisDetailTuple;
    
    private List<AnalysisDetailTuple> subParamsAnalysisDetailTuple;

	public AnalysisDetailTuple getAnalysisDetailTuple() {
		return analysisDetailTuple;
	}

	public void setAnalysisDetailTuple(AnalysisDetailTuple analysisDetailTuple) {
		this.analysisDetailTuple = analysisDetailTuple;
	}

	public List<AnalysisDetailTuple> getSubParamsAnalysisDetailTuple() {
		return subParamsAnalysisDetailTuple;
	}

	public void setSubParamsAnalysisDetailTuple(List<AnalysisDetailTuple> subParamsAnalysisDetailTuple) {
		this.subParamsAnalysisDetailTuple = subParamsAnalysisDetailTuple;
	}

	@Override
	public String toString() {
		return "AnalysisParam [analysisDetailTuple=" + analysisDetailTuple + ", subParamsAnalysisDetailTuple="
				+ subParamsAnalysisDetailTuple + "]";
	}
}