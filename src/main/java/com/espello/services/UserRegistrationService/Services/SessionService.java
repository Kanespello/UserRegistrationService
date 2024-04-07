package com.espello.services.UserRegistrationService.Services;

import org.springframework.stereotype.Service;

import com.espello.services.UserRegistrationService.Domain.SessionTranscript;
import com.espello.services.UserRegistrationService.Dto.SessionAnalysisDTO;
import com.espello.services.UserRegistrationService.Dto.Request.ConversationRequest;
import com.espello.services.UserRegistrationService.Dto.Request.SessionCreateRequest;
import com.espello.services.UserRegistrationService.Dto.Response.SessionCreateResponse;
import com.espello.services.UserRegistrationService.Dto.Response.SessionDetailsResponse;

import jakarta.validation.constraints.NotNull;

@Service
public class SessionService {
	
	public SessionCreateResponse createSession(SessionCreateRequest sessionCreateRequest){
		
		SessionCreateResponse sessionCreateResponse = null;
		
		return sessionCreateResponse;
	}
	
	public SessionDetailsResponse getSessionDetails(String sessionId){
		SessionDetailsResponse sessionDetailsResponse = null;
		
		return sessionDetailsResponse;
	}
	
	public SessionDetailsResponse getActiveSessionDetails(Integer userId){
		SessionDetailsResponse sessionDetailsResponse = null;
		
		return sessionDetailsResponse;
	}
	
	public Boolean saveConversion(ConversationRequest conversationRequest){
		Boolean response = null;
		
		return response;		
	}
	
	public SessionTranscript getTranscript(String sessionId){
		SessionTranscript sessionTranscript = null;
		
		return sessionTranscript;
	}
	
	public Boolean saveAnalysis(SessionAnalysisDTO sessionAnalysis){
		Boolean response = null;
		
		return response;	
	}
	
	public SessionAnalysisDTO getAnalysis(@NotNull String sessionId){
		SessionAnalysisDTO sessionAnalysis = null;
		
		return sessionAnalysis;		
	}

	
	
}
