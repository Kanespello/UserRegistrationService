package com.espello.services.UserRegistrationService.Dto.Response;

import com.espello.services.EspelloUtils.ResponseDto.Error;

public class OTPVerificationResponse extends Error {

	private boolean verified;
	private int attemptLeft = 0 ;

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public int getAttemptLeft() {
		return attemptLeft;
	}

	public void setAttemptLeft(int attemptLeft) {
		this.attemptLeft = attemptLeft;
	}

	@Override
	public String toString() {
		return "EmailVerificationResponse [verified=" + verified + ", attemptLeft=" + attemptLeft + "]";
	}
	
}
