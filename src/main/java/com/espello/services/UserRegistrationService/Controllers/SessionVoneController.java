package com.espello.services.UserRegistrationService.Controllers;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.espello.services.EspelloUtils.Enums.ApiResponseStatus;
import com.espello.services.EspelloUtils.ResponseDto.Response;
import com.espello.services.UserRegistrationService.Dto.AssistantThreadDTO;
import com.espello.services.UserRegistrationService.Dto.SessionAnalysisDTO;
import com.espello.services.UserRegistrationService.Dto.Request.ConversationRequest;
import com.espello.services.UserRegistrationService.Dto.Request.SessionCreateRequest;
import com.espello.services.UserRegistrationService.Dto.Response.SessionCreateResponse;
import com.espello.services.UserRegistrationService.Dto.Response.SessionDetailsResponse;
import com.espello.services.UserRegistrationService.Dto.Response.SessionTranscriptResponse;
import com.espello.services.UserRegistrationService.Services.SessionService;

import jakarta.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping(value = "/session/api/v1")
public class SessionVoneController {

	private static final Logger logger = LoggerFactory.getLogger(SessionVoneController.class);
	
	@Autowired
	private SessionService sessionService;
	
	
	@RequestMapping(value = "/createSession", method = RequestMethod.POST)
	public Response<SessionCreateResponse> createSession(@Validated @RequestBody SessionCreateRequest sessionCreateRequest){
		
		Response<SessionCreateResponse> response = new Response<>();
		
		response.setData(sessionService.createSession(sessionCreateRequest));
		
		return response;
	}
	
	@RequestMapping(value = "/getSessionDetails", method = RequestMethod.GET)
	public Response<SessionDetailsResponse> getSessionDetails(@NotNull String sessionId){
		Response<SessionDetailsResponse> response = new Response<>();
		
		SessionDetailsResponse sessionDetails = sessionService.getSessionDetails(sessionId);
		response.setData(sessionDetails);
		if(StringUtils.isNotBlank(sessionDetails.getErrorDescription())) {
			response.setStatus(ApiResponseStatus.FAILED);
		}
		
		return response;
	}
	
	@RequestMapping(value = "/getActiveSessionDetails", method = RequestMethod.GET)
	public Response<SessionDetailsResponse> getActiveSessionDetails(@NotNull Integer userId){
		Response<SessionDetailsResponse> response = new Response<>();
		
		response.setData(sessionService.getActiveSessionDetails(userId));
		
		return response;
	}
	
	@RequestMapping(value = "/saveConversation", method = RequestMethod.POST)
	public Response<Boolean> saveConversation(@Validated @RequestBody ConversationRequest conversationRequest){
		Response<Boolean> response = new Response<>();
		
		response.setData(sessionService.saveConversation(conversationRequest));
		
		return response;		
	}
	
	@RequestMapping(value = "/getTranscript", method = RequestMethod.GET)
	public Response<SessionTranscriptResponse> getTranscript(@NotNull String sessionId){
		Response<SessionTranscriptResponse> response = new Response<>();
		
		response.setData(sessionService.getTranscript(sessionId));
		
		return response;
	}
	
	@RequestMapping(value = "/saveAnalysis", method = RequestMethod.POST)
	public Response<Boolean> saveAnalysis(@Validated @RequestBody SessionAnalysisDTO sessionAnalysisDTO){
		Response<Boolean> response = new Response<>();
		
		response.setData(sessionService.saveAnalysis(sessionAnalysisDTO));
		
		return response;	
	}
	
	@RequestMapping(value = "/getAnalysis", method = RequestMethod.GET)
	public Response<SessionAnalysisDTO> getAnalysis(@NotNull String sessionId){
		Response<SessionAnalysisDTO> response = new Response<>();
		
		response.setData(sessionService.getAnalysis(sessionId));
		
		return response;		
	}
	
	@RequestMapping(value = "/joinWaitlist", method = RequestMethod.GET)
	public Response<Boolean> joinWaitlist(String email, String phone, String name ,String message, boolean isEnterprise){
		Response<Boolean> response = new Response<>();
		response.setData(sessionService.joinWaitlist(email, phone, name, message, isEnterprise));
		return response;		
	}
	
	@RequestMapping(value = "/submitSessionFeedback", method = RequestMethod.GET)
	public Response<Boolean> submitSessionFeedback(Integer rating, String comments, String sessionId){
		Response<Boolean> response = new Response<>();
		response.setData(sessionService.submitSessionFeedback(rating, comments, sessionId));
		return response;		
	}
	
	@RequestMapping(value = "/saveAssistantThread", method = RequestMethod.POST)
	public Response<Boolean> saveAssistantThread(@Validated @RequestBody AssistantThreadDTO assistantThreadRequest){
		Response<Boolean> response = new Response<>();
		response.setData(sessionService.saveAssistantThread(assistantThreadRequest));
		return response;		
	}
	
	@RequestMapping(value = "/getAssistantThread", method = RequestMethod.GET)
	public Response<AssistantThreadDTO> getAssistantThread(@NotNull String sessionId){
		Response<AssistantThreadDTO> response = new Response<>();
		response.setData(sessionService.getAssistantThread(sessionId));
		return response;		
	}
	
}
