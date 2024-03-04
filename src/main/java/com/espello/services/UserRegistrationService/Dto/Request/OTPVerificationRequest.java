package com.espello.services.UserRegistrationService.Dto.Request;

import jakarta.validation.constraints.NotNull;

public class OTPVerificationRequest {

	@NotNull
	private Integer userId;
	@NotNull
	private Integer otp;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getOtp() {
		return otp;
	}
	public void setOtp(Integer otp) {
		this.otp = otp;
	}
	@Override
	public String toString() {
		return "EmailVerificationRequest [userId=" + userId + ", otp=" + otp + "]";
	}
	
}
