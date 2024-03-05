package com.espello.services.UserRegistrationService.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.espello.services.EspelloUtils.Utility.ValidationUtils;
import com.espello.services.UserRegistrationService.Configs.RegistrationConfig;
import com.espello.services.UserRegistrationService.Domain.OTPVerification;
import com.espello.services.UserRegistrationService.Domain.User;
import com.espello.services.UserRegistrationService.Dto.Request.LoginRequest;
import com.espello.services.UserRegistrationService.Dto.Request.OTPVerificationRequest;
import com.espello.services.UserRegistrationService.Dto.Request.RegistrationRequest;
import com.espello.services.UserRegistrationService.Dto.Response.LoginResponse;
import com.espello.services.UserRegistrationService.Dto.Response.OTPVerificationResponse;
import com.espello.services.UserRegistrationService.Dto.Response.RegistrationResponse;
import com.espello.services.UserRegistrationService.Enums.OTPStatus;
import com.espello.services.UserRegistrationService.Enums.VerificationModule;
import com.espello.services.UserRegistrationService.Repository.OTPVerificationRepository;
import com.espello.services.UserRegistrationService.Repository.UserRepository;

import jakarta.transaction.Transactional;

@Component
public class RegistrationService {
	
	private static final Logger logger = LoggerFactory.getLogger(RegistrationService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ValidationUtils validationUtils;
	
	@Autowired
	private RegistrationHelper registrationHelper;
	
	@Autowired
	private OTPVerificationRepository otpVerificationRepository;

	@Transactional
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
		
		String otp = registrationHelper.generateOTP(userResponse.getUserId(), VerificationModule.EMAIL);
		
		//mail to be triggered for otp verification
		
		logger.info("userResponse::::::::::::::{}",userResponse);
		
		registrationResponse.setUserId(userResponse.getUserId());
		
		return registrationResponse;
	}
	
	@Transactional
	public OTPVerificationResponse verifyOTP(OTPVerificationRequest otpVerificationRequest){
		OTPVerificationResponse otpVerificationResponse = new OTPVerificationResponse();
		
		OTPVerification otpVerification = otpVerificationRepository.verifyOTP(OTPStatus.UNVERIFIED, RegistrationConfig.OTPTimeOut, otpVerificationRequest.getUserId());
		
		if(otpVerification!=null) {
			
			if(otpVerification.getVerificationCode().equals(otpVerificationRequest.getOtp())) {
				otpVerificationRepository.markVerified(otpVerificationRequest.getOtp(), OTPStatus.VERIFIED, otpVerificationRequest.getUserId());
				otpVerificationResponse.setVerified(true);
			}
			else {
				otpVerificationResponse.setAttemptLeft(RegistrationConfig.OTPMaxRetry-otpVerification.getRetryCount());
				otpVerificationResponse.setErrorDescription("Wrong OTP");
				
				otpVerificationRepository.updateRetryCount(otpVerificationRequest.getVerificationModule(), otpVerification.getRetryCount()+1, otpVerificationRequest.getUserId());
			}
			
		}
		else {
			otpVerificationResponse.setErrorDescription("Record Not Found");
		}
		
		
		return otpVerificationResponse;
	}
	
	
	public Boolean resendOTP(OTPVerificationRequest otpVerificationRequest){
		
		String otp = registrationHelper.generateOTP(otpVerificationRequest.getUserId(), otpVerificationRequest.getVerificationModule());
		
		//mail to be triggered for otp verification
		
		return true;
	}
	
	 public LoginResponse login(LoginRequest loginRequest){
		 LoginResponse loginResponse = new LoginResponse();
		 
		 User userResponse = userRepository.findUserByEmail(loginRequest.getEmail());
		 
		 if(userResponse!=null && userResponse.getUserId()>0) {
			 
			if(loginRequest.getPassword().equals(userResponse.getPassword())) {
				loginResponse.setLoginSuccess(true);
			}
		 }
		 else {
			 loginResponse.setErrorDescription("Email not exists");
		 }
		 loginResponse.setErrorDescription("Wrong Password");
		 return loginResponse;
	 }
	 
	 
	 
	 @Transactional
	 public Boolean setPassword(LoginRequest loginRequest){
		 
		 userRepository.setPassword(loginRequest.getPassword(), loginRequest.getEmail());
		 
		 return true;
	 }
	
}
