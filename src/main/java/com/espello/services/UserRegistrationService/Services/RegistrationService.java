package com.espello.services.UserRegistrationService.Services;

import org.springframework.stereotype.Component;

import com.espello.services.UserRegistrationService.Dto.Request.EmailVerificationRequest;
import com.espello.services.UserRegistrationService.Dto.Request.LoginRequest;
import com.espello.services.UserRegistrationService.Dto.Request.RegistrationRequest;
import com.espello.services.UserRegistrationService.Dto.Response.EmailVerificationResponse;
import com.espello.services.UserRegistrationService.Dto.Response.LoginResponse;
import com.espello.services.UserRegistrationService.Dto.Response.RegistrationResponse;

@Component
public class RegistrationService {

	public RegistrationResponse register(RegistrationRequest registrationRequest){
		RegistrationResponse registrationResponse = new RegistrationResponse();
		return registrationResponse;
	}
	
	public EmailVerificationResponse verifyEmail(EmailVerificationRequest emailVerificationRequest){
		EmailVerificationResponse emailVerificationResponse = new EmailVerificationResponse();
		
		return emailVerificationResponse;
	}
	
	 public LoginResponse login(LoginRequest loginRequest){
		 LoginResponse loginResponse = new LoginResponse();
		 return loginResponse;
	 }
	
}
