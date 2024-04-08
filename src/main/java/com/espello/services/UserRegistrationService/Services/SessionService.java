package com.espello.services.UserRegistrationService.Services;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.espello.services.UserRegistrationService.Domain.SessionAnalysis;
import com.espello.services.UserRegistrationService.Domain.SessionDetails;
import com.espello.services.UserRegistrationService.Domain.SessionTranscript;
import com.espello.services.UserRegistrationService.Domain.Projections.UserSessionProjection;
import com.espello.services.UserRegistrationService.Dto.SessionAnalysisDTO;
import com.espello.services.UserRegistrationService.Dto.Request.ConversationRequest;
import com.espello.services.UserRegistrationService.Dto.Request.SessionCreateRequest;
import com.espello.services.UserRegistrationService.Dto.Response.SessionCreateResponse;
import com.espello.services.UserRegistrationService.Dto.Response.SessionDetailsResponse;
import com.espello.services.UserRegistrationService.Dto.Response.SessionTranscriptResponse;
import com.espello.services.UserRegistrationService.Enums.SessionStatus;
import com.espello.services.UserRegistrationService.Repository.SessionAnalysisRepository;
import com.espello.services.UserRegistrationService.Repository.SessionDetailsRepository;
import com.espello.services.UserRegistrationService.Repository.SessionTranscriptRepository;
import com.espello.services.UserRegistrationService.Repository.UserSessionDetailsRepository;
import com.espello.services.UserRegistrationService.Utility.DTOBuilder;

import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;

@Service
public class SessionService {
	
	private static final Logger logger = LoggerFactory.getLogger(SessionService.class);
	
	@Autowired
	private SessionDetailsRepository sessionDetailsRepository;
	
	@Autowired
	private UserSessionDetailsRepository userSessionDetailsRepository;
	
	@Autowired
	private SessionTranscriptRepository sessionTranscriptRepository;
	
	@Autowired
	private SessionAnalysisRepository sessionAnalysisRepository;
	
	@Transactional
	public SessionCreateResponse createSession(SessionCreateRequest sessionCreateRequest){
		
		SessionCreateResponse sessionCreateResponse = new SessionCreateResponse();
		
		try {
			SessionDetails sessionDetails = DTOBuilder.buildDto(sessionCreateRequest);
			userSessionDetailsRepository.updatePreviousSessionStatusHistory(sessionCreateRequest.getUserId());
			userSessionDetailsRepository.save(DTOBuilder.buildDto(sessionCreateRequest.getUserId(), sessionDetails.getSessionId()));
			sessionDetailsRepository.save(sessionDetails);
			sessionCreateResponse.setSessionId(sessionDetails.getSessionId());
			
		} catch (Exception e) {
			logger.error("Error Creating Session", e);
		}
		
		return sessionCreateResponse;
	}
	
	public SessionDetailsResponse getSessionDetails(String sessionId){
		
		if(StringUtils.isBlank(sessionId)) {
			return null;
		}
		
		SessionDetailsResponse sessionDetailsResponse = null;
		
		try {
			SessionDetails sessionDetails = sessionDetailsRepository.findSessionDetailsBySessionId(sessionId);
			sessionDetailsResponse = DTOBuilder.buildDto(sessionDetails);
		} catch (Exception e) {
			logger.error("Error Fetching Session Details", e);
		}
		
		
		return sessionDetailsResponse;
	}
	
	public SessionDetailsResponse getActiveSessionDetails(Integer userId){
		
		SessionDetailsResponse sessionDetailsResponse = null;
		
		try {
			List<UserSessionProjection> userSessionProjections = userSessionDetailsRepository.findSessionIdsByUserIdAndStatus(userId, SessionStatus.ACTIVE);
			
			if(CollectionUtils.isEmpty(userSessionProjections)) {
				return null;
			}
			else if(userSessionProjections.size()>1) {
				logger.error("Error Fetching Active Session Details, More than 1 session found");
				return null;
			}
			sessionDetailsResponse = getSessionDetails(userSessionProjections.get(0).getSessionId());
		} catch (Exception e) {
			logger.error("Error Fetching Active Session Details", e);
		}
		
		return sessionDetailsResponse;
	}
	
	@Transactional
	public Boolean saveConversation(ConversationRequest conversationRequest){
		
		Boolean response = false;
		try {
			SessionTranscript sessionTranscript = DTOBuilder.buildDto(conversationRequest);
			sessionTranscriptRepository.save(sessionTranscript);
			response = true;
		} catch (Exception e) {
			logger.error("Error Saving Conversation", e);
		}
		
		return response;		
	}
	
	public SessionTranscriptResponse getTranscript(String sessionId){
		SessionTranscriptResponse sessionTranscriptResponse = null;
		
		try {
			List<SessionTranscript> conversations =sessionTranscriptRepository.findAllBySessionId(sessionId);
			sessionTranscriptResponse = DTOBuilder.buildDto(conversations);
			
		} catch (Exception e) {
			logger.error("Error Fetching Transcript", e);
		}
		
		return sessionTranscriptResponse;
	}
	
	public Boolean saveAnalysis(SessionAnalysisDTO sessionAnalysisDTO){
		Boolean response = false;
		try {
			SessionAnalysis sessionAnalysis = DTOBuilder.buildDto(sessionAnalysisDTO);
			sessionAnalysisRepository.save(sessionAnalysis);
			response = true;
		} catch (Exception e) {
			logger.error("Error Saving Analysis", e);
		}
		
		return response;	
	}
	
	public SessionAnalysisDTO getAnalysis(@NotNull String sessionId){
		SessionAnalysisDTO sessionAnalysisDTO = null;
		
		try {
			SessionAnalysis sessionAnalysis = sessionAnalysisRepository.findSessionAnalysisBySessionId(sessionId);
			sessionAnalysisDTO = DTOBuilder.buildDto(sessionAnalysis);
			
		} catch (Exception e) {
			logger.error("Error getting Analysis", e);
		}
		
		return sessionAnalysisDTO;		
	}

}
