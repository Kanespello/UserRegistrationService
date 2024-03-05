package com.espello.services.UserRegistrationService.Services;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.espello.services.UserRegistrationService.Configs.RegistrationConfig;
import com.espello.services.UserRegistrationService.Domain.OTPVerification;
import com.espello.services.UserRegistrationService.Enums.VerificationModule;
import com.espello.services.UserRegistrationService.Repository.OTPVerificationRepository;

import jakarta.transaction.Transactional;

@Component
public class RegistrationHelper {
	
	@Autowired
	private OTPVerificationRepository otpVerificationRepository;
	
    public String generateOTP() {
	   
	    int otpLength = RegistrationConfig.OTPLength;
     
        SecureRandom random = new SecureRandom();

        StringBuilder otp = new StringBuilder(otpLength);

        for (int i = 0; i < otpLength; i++) {
            int randomDigit = random.nextInt(10); // This will give numbers from 0 to 9
            otp.append(randomDigit);
        }

        return otp.toString();
     }
   
    @Transactional
    public String generateOTP(Integer userId, VerificationModule verificationModule) {
    	String otp = generateOTP();
	    
	    OTPVerification otpVerification = new OTPVerification();
	    
	    otpVerification.setVerificationCode(otp);
	    otpVerification.setVerificationModule(verificationModule);
	    otpVerification.setUserId(userId);
	    otpVerificationRepository.save(otpVerification);
	    
	    return otp;
	
    }
   
   

}
