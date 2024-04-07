package com.espello.services.UserRegistrationService.Domain;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "sessionDetails")
public class SessionDetails {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "sessionId")
    private String sessionId;
    
    @Column(name = "role")
    private String role;
    
    @Column(name = "sessionStartTime")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="IST")
    private LocalDateTime sessionStartTime = LocalDateTime.now();
    
    @Column(name = "sessionEndTime")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="IST")
    private LocalDateTime sessionEndTime;

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LocalDateTime getSessionStartTime() {
		return sessionStartTime;
	}

	public void setSessionStartTime(LocalDateTime sessionStartTime) {
		this.sessionStartTime = sessionStartTime;
	}

	public LocalDateTime getSessionEndTime() {
		return sessionEndTime;
	}

	public void setSessionEndTime(LocalDateTime sessionEndTime) {
		this.sessionEndTime = sessionEndTime;
	}

	@Override
	public String toString() {
		return "SessionDetails [id=" + id + ", sessionId=" + sessionId + ", role=" + role + ", sessionStartTime="
				+ sessionStartTime + ", sessionEndTime=" + sessionEndTime + "]";
	}
    
}
   