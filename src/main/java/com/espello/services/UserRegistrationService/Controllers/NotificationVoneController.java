package com.espello.services.UserRegistrationService.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.espello.services.EspelloUtils.ResponseDto.Response;
import com.espello.services.UserRegistrationService.Services.MailerService;

@Validated
@RestController
@RequestMapping(value = "/notification/api/v1")
public class NotificationVoneController {
	
	private static final Logger logger = LoggerFactory.getLogger(NotificationVoneController.class);

	@Autowired
	private MailerService mailerService;
	
	@RequestMapping(value = "/sendEmail", method = RequestMethod.GET)
	public Response<Boolean> sendEmail(){
		Response<Boolean> response = new Response<>();
		
		response.setData(mailerService.sendEmail());
		
		return response;		
	}
}
