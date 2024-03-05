package com.espello.services.UserRegistrationService.Dto.Response;

import com.espello.services.EspelloUtils.ResponseDto.Error;

public class LoginResponse extends Error{
	
	private boolean loginSuccess;

	public boolean isLoginSuccess() {
		return loginSuccess;
	}

	public void setLoginSuccess(boolean loginSuccess) {
		this.loginSuccess = loginSuccess;
	}

	@Override
	public String toString() {
		return "LoginResponse [loginSuccess=" + loginSuccess + "]";
	}
	
}
