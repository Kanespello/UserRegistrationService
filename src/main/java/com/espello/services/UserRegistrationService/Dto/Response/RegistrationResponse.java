package com.espello.services.UserRegistrationService.Dto.Response;

import com.espello.services.EspelloUtils.ResponseDto.Error;

public class RegistrationResponse extends Error {

	private Integer userId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "RegistrationResponse [userId=" + userId + "]";
	}
}
