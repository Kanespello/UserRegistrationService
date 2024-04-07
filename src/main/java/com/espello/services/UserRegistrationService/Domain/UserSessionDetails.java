package com.espello.services.UserRegistrationService.Domain;

import com.espello.services.UserRegistrationService.Enums.SessionStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "userSessionDetails")
public class UserSessionDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "userId")
    private int userId;
    
    @Column(name = "sessionId")
    private String sessionId;
    
    @Column(name = "status")
    private SessionStatus status = SessionStatus.ACTIVE;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public SessionStatus getStatus() {
		return status;
	}

	public void setStatus(SessionStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UserSessionDetails [id=" + id + ", userId=" + userId + ", sessionId=" + sessionId + ", status=" + status
				+ "]";
	}
}
