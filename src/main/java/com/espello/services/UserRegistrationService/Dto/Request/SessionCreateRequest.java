package com.espello.services.UserRegistrationService.Dto.Request;

import jakarta.validation.constraints.NotNull;

public class SessionCreateRequest {
	
	@NotNull
 	private Integer userId;
 	
    private String role;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "SessionCreateRequest [userId=" + userId + ", role=" + role + "]";
	}
	    
}
