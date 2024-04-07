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
@Table(name = "sessionTranscript")
public class SessionTranscript {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "sessionId")
    private String sessionId;
    
    @Column(name = "intervieweeText")
    private String intervieweeText;
    
    @Column(name = "interviewerText")
    private String interviewerText;
    
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

	public String getIntervieweeText() {
		return intervieweeText;
	}

	public void setIntervieweeText(String intervieweeText) {
		this.intervieweeText = intervieweeText;
	}

	public String getInterviewerText() {
		return interviewerText;
	}

	public void setInterviewerText(String interviewerText) {
		this.interviewerText = interviewerText;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "SessionTranscript [id=" + id + ", sessionId=" + sessionId + ", intervieweeText=" + intervieweeText
				+ ", interviewerText=" + interviewerText + ", dateTime=" + dateTime + "]";
	}

}
