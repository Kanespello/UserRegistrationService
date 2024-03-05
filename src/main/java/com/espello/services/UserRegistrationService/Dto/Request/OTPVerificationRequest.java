package com.espello.services.UserRegistrationService.Dto.Request;

import com.espello.services.UserRegistrationService.Enums.VerificationModule;

import jakarta.validation.constraints.NotNull;

public class OTPVerificationRequest {

	@NotNull
	private Integer userId;
	
	@NotNull
	private VerificationModule verificationModule;
	
	@NotNull
	private String otp;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public VerificationModule getVerificationModule() {
		return verificationModule;
	}
	public void setVerificationModule(VerificationModule verificationModule) {
		this.verificationModule = verificationModule;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	@Override
	public String toString() {
		return "OTPVerificationRequest [userId=" + userId + ", verificationModule=" + verificationModule + ", otp="
				+ otp + "]";
	}
	
}
