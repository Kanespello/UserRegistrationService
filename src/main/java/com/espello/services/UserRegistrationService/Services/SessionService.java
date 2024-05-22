package com.espello.services.UserRegistrationService.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.espello.services.UserRegistrationService.Domain.AnalysisSubParam;
import com.espello.services.UserRegistrationService.Domain.SessionAnalysis;
import com.espello.services.UserRegistrationService.Domain.SessionDetails;
import com.espello.services.UserRegistrationService.Domain.SessionFeedback;
import com.espello.services.UserRegistrationService.Domain.SessionTranscript;
import com.espello.services.UserRegistrationService.Domain.Waitlist;
import com.espello.services.UserRegistrationService.Domain.Projections.UserSessionProjection;
import com.espello.services.UserRegistrationService.Dto.AnalysisParam;
import com.espello.services.UserRegistrationService.Dto.SessionAnalysisDTO;
import com.espello.services.UserRegistrationService.Dto.Request.ConversationRequest;
import com.espello.services.UserRegistrationService.Dto.Request.SessionCreateRequest;
import com.espello.services.UserRegistrationService.Dto.Response.SessionCreateResponse;
import com.espello.services.UserRegistrationService.Dto.Response.SessionDetailsResponse;
import com.espello.services.UserRegistrationService.Dto.Response.SessionTranscriptResponse;
import com.espello.services.UserRegistrationService.Enums.SessionStatus;
import com.espello.services.UserRegistrationService.Repository.AnalysisSubParamRepository;
import com.espello.services.UserRegistrationService.Repository.SessionAnalysisRepository;
import com.espello.services.UserRegistrationService.Repository.SessionDetailsRepository;
import com.espello.services.UserRegistrationService.Repository.SessionFeedbackRepository;
import com.espello.services.UserRegistrationService.Repository.SessionTranscriptRepository;
import com.espello.services.UserRegistrationService.Repository.UserSessionDetailsRepository;
import com.espello.services.UserRegistrationService.Repository.WaitlistRepository;
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
	
	@Autowired
	private AnalysisSubParamRepository analysisSubParamRepository;
	
	@Autowired
	private WaitlistRepository waitlistRepository;
	
	@Autowired
	private SessionFeedbackRepository sessionFeedbackRepository;
	
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
	
	@Transactional
	public Boolean saveAnalysis(SessionAnalysisDTO sessionAnalysisDTO){
		Boolean response = false;
		try {
			
			for (AnalysisParam analysisParam  : sessionAnalysisDTO.getAnalysisParams()) {
				
				SessionAnalysis sessionAnalysis = DTOBuilder.buildDto(sessionAnalysisDTO.getSessionId(), analysisParam.getAnalysisDetailTuple());
				
				SessionAnalysis savedAnalysis = sessionAnalysisRepository.save(sessionAnalysis);
				
				if(CollectionUtils.isNotEmpty(analysisParam.getSubParamsAnalysisDetailTuple())) {
					
					List<AnalysisSubParam> analysisSubParams = DTOBuilder.buildDto(savedAnalysis.getId(), analysisParam.getSubParamsAnalysisDetailTuple());
					analysisSubParamRepository.saveAll(analysisSubParams);
				}
				
			}
			response = true;
		} catch (Exception e) {
			logger.error("Error Saving Analysis", e);
		}
		
		return response;	
	}
	
	public SessionAnalysisDTO getAnalysis(@NotNull String sessionId){
		SessionAnalysisDTO sessionAnalysisDTO = null;
		
		try {
			List<SessionAnalysis> sessionAnalysises = sessionAnalysisRepository.findAllSessionAnalysisBySessionId(sessionId);
			
			if(CollectionUtils.isNotEmpty(sessionAnalysises)) {
				
				List<Integer> analysisIds = sessionAnalysises.stream().map(SessionAnalysis::getId).collect(Collectors.toList());
				
				List<AnalysisSubParam> analysisSubParams = analysisSubParamRepository.findAllAnalysisSubParamByAnalysisParamIdIn(analysisIds);
				
				sessionAnalysisDTO = DTOBuilder.buildDto(sessionAnalysises, analysisSubParams);
				
			}
			
		} catch (Exception e) {
			logger.error("Error getting Analysis", e);
		}
		
		return sessionAnalysisDTO;		
	}
	
	public Boolean joinWaitlist (String email, String phone, String name ,String message, boolean isEnterprise) {
		
		try {
			Waitlist waitlist = new Waitlist();
			waitlist.setEmail(email);
			waitlist.setPhone(phone);
			waitlist.setEnterprise(isEnterprise);
			waitlist.setFullName(name);
			waitlist.setMessage(message);
			
			if(StringUtils.isNotBlank(email)) {
				waitlistRepository.save(waitlist);
			}
		} catch (Exception e) {
			return false;
		}
		
		return true;
		
	}
	
	public Boolean submitSessionFeedback (Integer rating, String comments, String sessionId) {
		
		try {
			SessionFeedback sessionFeedback = new SessionFeedback();
			sessionFeedback.setComments(comments);
			sessionFeedback.setRating(rating);
			sessionFeedback.setSessionId(sessionId);
			
			sessionFeedbackRepository.save(sessionFeedback);
			
		} catch (Exception e) {
			return false;
		}
		
		return true;
		
	}

}
