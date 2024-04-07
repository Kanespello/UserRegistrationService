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
    
    @Column(name = "anlysisParam1")
    private String anlysisParam1;
    
    @Column(name = "anlysisParam2")
    private String anlysisParam2;
    
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

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "SessionAnalysis [id=" + id + ", sessionId=" + sessionId + ", anlysisParam1=" + anlysisParam1
				+ ", anlysisParam2=" + anlysisParam2 + ", dateTime=" + dateTime + "]";
	}
}
