package com.espello.services.UserRegistrationService.Dto.Request;

import jakarta.validation.constraints.NotNull;

public class RegistrationRequest {

	@NotNull
	public String name;
	@NotNull
	public String email;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "RegistrationRequest [name=" + name + ", email=" + email + "]";
	}

}
