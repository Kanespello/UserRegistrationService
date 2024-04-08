package com.espello.services.UserRegistrationService.Configs;

public class RegistrationConfig {
	
	public static final Integer OTPTimeOut = 2;
	public static final Integer OTPMaxRetry = 3;
	public static final Integer OTPNextRetryTime = 30;
	public static final Integer OTPLength = 4;
	
	public static final String ALPHANUMERIC_CHARS = "abcdefghijklmnopqrstuvwxyz0123456789";
	public static final int SESSION_ID_RANDOMPART_LEN = 5;

}
