package com.espello.services.UserRegistrationService.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.espello.services.EspelloUtils.Utility.ValidationUtils;
import com.espello.services.UserRegistrationService.Domain.User;
import com.espello.services.UserRegistrationService.Dto.Request.LoginRequest;
import com.espello.services.UserRegistrationService.Dto.Request.OTPVerificationRequest;
import com.espello.services.UserRegistrationService.Dto.Request.RegistrationRequest;
import com.espello.services.UserRegistrationService.Dto.Response.LoginResponse;
import com.espello.services.UserRegistrationService.Dto.Response.OTPVerificationResponse;
import com.espello.services.UserRegistrationService.Dto.Response.RegistrationResponse;
import com.espello.services.UserRegistrationService.Repository.UserRepository;

@Component
public class RegistrationService {
	
	private static final Logger logger = LoggerFactory.getLogger(RegistrationService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ValidationUtils validationUtils;

	public RegistrationResponse register(RegistrationRequest registrationRequest){
		RegistrationResponse registrationResponse = new RegistrationResponse();
		
		if(!validationUtils.isValidName(registrationRequest.getName())) {
			registrationResponse.setErrorDescription("Invalid name");
			return registrationResponse;
		}
		
		if(!validationUtils.isValidEmail(registrationRequest.getEmail())) {
			registrationResponse.setErrorDescription("Invalid email");
			return registrationResponse;
		}
		
		User userResponse = userRepository.findUserByEmail(registrationRequest.getEmail());
		
		if(userResponse!=null && userResponse.getUserId()>0) {
			registrationResponse.setErrorDescription("Email already exists");
			return registrationResponse;
		}
		
		User userRequest = new User();
		
		userRequest.setEmail(registrationRequest.getEmail());
		
		userRequest.setFullName(registrationRequest.getName());
		
		userResponse = userRepository.save(userRequest);
		
		logger.info("userResponse::::::::::::::{}",userResponse);
		
		registrationResponse.setUserId(userResponse.getUserId());
		
		return registrationResponse;
	}
	
	public OTPVerificationResponse verifyOTP(OTPVerificationRequest otpVerificationRequest){
		OTPVerificationResponse otpVerificationResponse = new OTPVerificationResponse();
		
		return otpVerificationResponse;
	}
	
	 public LoginResponse login(LoginRequest loginRequest){
		 LoginResponse loginResponse = new LoginResponse();
		 return loginResponse;
	 }
	
}
