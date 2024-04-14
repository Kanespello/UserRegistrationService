package com.espello.services.UserRegistrationService.Domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "analysisSubParam")
public class AnalysisSubParam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "analysisParamId")
    private Integer analysisParamId;
    
    @Column(name = "anlysisSubParam")
    private String anlysisSubParam;
    
    @Column(name = "anlysisSubParamDesc")
    private String anlysisSubParamDesc;
    
    @Column(name = "anlysisSubParamScore")
    private Integer anlysisSubParamScore;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getAnalysisParamId() {
		return analysisParamId;
	}

	public void setAnalysisParamId(Integer analysisParamId) {
		this.analysisParamId = analysisParamId;
	}

	public String getAnlysisSubParam() {
		return anlysisSubParam;
	}

	public void setAnlysisSubParam(String anlysisSubParam) {
		this.anlysisSubParam = anlysisSubParam;
	}

	public String getAnlysisSubParamDesc() {
		return anlysisSubParamDesc;
	}

	public void setAnlysisSubParamDesc(String anlysisSubParamDesc) {
		this.anlysisSubParamDesc = anlysisSubParamDesc;
	}

	public Integer getAnlysisSubParamScore() {
		return anlysisSubParamScore;
	}

	public void setAnlysisSubParamScore(Integer anlysisSubParamScore) {
		this.anlysisSubParamScore = anlysisSubParamScore;
	}

	@Override
	public String toString() {
		return "AnalysisSubParam [id=" + id + ", analysisParamId=" + analysisParamId + ", anlysisSubParam="
				+ anlysisSubParam + ", anlysisSubParamDesc=" + anlysisSubParamDesc + ", anlysisSubParamScore="
				+ anlysisSubParamScore + "]";
	}
}
