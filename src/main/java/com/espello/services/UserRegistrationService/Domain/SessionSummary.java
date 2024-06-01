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
@Table(name = "sessionSummary")
public class SessionSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "sessionId")
    private String sessionId;
    
    @Column(name = "caseTitle")
    private String caseTitle;
    
    @Column(name = "summary")
    private String summary;
   
    @Column(name = "submitDate")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="IST")
    private LocalDateTime submitDate = LocalDateTime.now();

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

	public LocalDateTime getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(LocalDateTime submitDate) {
		this.submitDate = submitDate;
	}

	@Override
	public String toString() {
		return "SessionSummary [id=" + id + ", sessionId=" + sessionId + ", caseTitle=" + caseTitle + ", summary="
				+ summary + ", submitDate=" + submitDate + "]";
	}
    
}
