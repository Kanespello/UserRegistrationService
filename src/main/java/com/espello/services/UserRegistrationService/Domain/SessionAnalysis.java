package com.espello.services.UserRegistrationService.Domain;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sessionAnalysis")
public class SessionAnalysis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "sessionId")
    private String sessionId;
    
    @Column(name = "anlysisParam")
    private String anlysisParam;
    
    @Column(name = "anlysisParamDesc")
    private String anlysisParamDesc;
    
    @Column(name = "anlysisParamScore")
    private Integer anlysisParamScore;
    
    @Column(name = "dateTime")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="IST")
    private LocalDateTime dateTime = LocalDateTime.now();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getAnlysisParam() {
		return anlysisParam;
	}

	public void setAnlysisParam(String anlysisParam) {
		this.anlysisParam = anlysisParam;
	}

	public String getAnlysisParamDesc() {
		return anlysisParamDesc;
	}

	public void setAnlysisParamDesc(String anlysisParamDesc) {
		this.anlysisParamDesc = anlysisParamDesc;
	}

	public Integer getAnlysisParamScore() {
		return anlysisParamScore;
	}

	public void setAnlysisParamScore(Integer anlysisParamScore) {
		this.anlysisParamScore = anlysisParamScore;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "SessionAnalysis [id=" + id + ", sessionId=" + sessionId + ", anlysisParam=" + anlysisParam
				+ ", anlysisParamDesc=" + anlysisParamDesc + ", anlysisParamScore=" + anlysisParamScore + ", dateTime="
				+ dateTime + "]";
	}
}
