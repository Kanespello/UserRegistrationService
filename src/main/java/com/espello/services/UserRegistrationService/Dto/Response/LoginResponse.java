package com.espello.services.UserRegistrationService.Dto.Response;

import com.espello.services.EspelloUtils.ResponseDto.Error;

public class LoginResponse extends Error{
	
	private Boolean loginSuccess;

	public Boolean getLoginSuccess() {
		return loginSuccess;
	}

	public void setLoginSuccess(Boolean loginSuccess) {
		this.loginSuccess = loginSuccess;
	}

	@Override
	public String toString() {
		return "LoginResponse [loginSuccess=" + loginSuccess + "]";
	}
	
}
