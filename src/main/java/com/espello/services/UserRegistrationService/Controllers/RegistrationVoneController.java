package com.espello.services.UserRegistrationService.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.espello.services.EspelloUtils.ResponseDto.Response;
import com.espello.services.UserRegistrationService.Dto.Request.LoginRequest;
import com.espello.services.UserRegistrationService.Dto.Request.OTPVerificationRequest;
import com.espello.services.UserRegistrationService.Dto.Request.RegistrationRequest;
import com.espello.services.UserRegistrationService.Dto.Response.LoginResponse;
import com.espello.services.UserRegistrationService.Dto.Response.OTPVerificationResponse;
import com.espello.services.UserRegistrationService.Dto.Response.RegistrationResponse;
import com.espello.services.UserRegistrationService.Services.RegistrationService;


@Validated
@RestController
@RequestMapping(value = "/registration/api/v1")
public class RegistrationVoneController {
	
	private static final Logger logger = LoggerFactory.getLogger(RegistrationVoneController.class);

	@Autowired
	private RegistrationService registrationService;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	 public Response<RegistrationResponse> register(@Validated @RequestBody RegistrationRequest registrationRequest){
		
		logger.info("registrationRequest::::::::::::{}",registrationRequest);
		
		Response<RegistrationResponse> response = new Response<>();
		
		RegistrationResponse registrationResponse = registrationService.register(registrationRequest);
		
		response.setData(registrationResponse);
		
		logger.info("RegistrationResponse::::::::::::{}",registrationResponse);
		return response;
	}
	
	@RequestMapping(value = "/verifyOTP", method = RequestMethod.POST)
	 public Response<OTPVerificationResponse> verifyOTP(@Validated @RequestBody OTPVerificationRequest otpVerificationRequest){
		
		logger.info("otpVerificationRequest::::::::::::{}",otpVerificationRequest);
		
		Response<OTPVerificationResponse> response = new Response<>();
		
		OTPVerificationResponse otpVerificationResponse = registrationService.verifyOTP(otpVerificationRequest);
		
		response.setData(otpVerificationResponse);
		
		logger.info("otpVerificationResponse::::::::::::{}",otpVerificationResponse);
		return response;
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	 public Response<LoginResponse> login(@Validated @RequestBody LoginRequest loginRequest){
		
		logger.info("loginRequest::::::::::::{}",loginRequest);
		
		Response<LoginResponse> response = new Response<>();
		
		LoginResponse loginResponse = new LoginResponse();
		
		response.setData(loginResponse);
		
		logger.info("LoginResponse::::::::::::{}",loginResponse);
		return response;
	}
}
