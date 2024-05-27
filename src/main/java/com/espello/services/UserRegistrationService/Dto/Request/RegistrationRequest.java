package com.espello.services.UserRegistrationService.Dto.Request;

import com.espello.services.UserRegistrationService.Enums.RegistrationMedium;

import jakarta.validation.constraints.NotNull;

public class RegistrationRequest {

	@NotNull
	private String name;
	@NotNull
	private String email;
	@NotNull
	private RegistrationMedium registrationMedium = RegistrationMedium.GSIGNUP;
	
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
	public RegistrationMedium getRegistrationMedium() {
		return registrationMedium;
	}
	public void setRegistrationMedium(RegistrationMedium registrationMedium) {
		this.registrationMedium = registrationMedium;
	}
	@Override
	public String toString() {
		return "RegistrationRequest [name=" + name + ", email=" + email + ", registrationMedium=" + registrationMedium
				+ "]";
	}
}
