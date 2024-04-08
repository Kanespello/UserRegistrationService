package com.espello.services.UserRegistrationService.Utility;

import java.security.SecureRandom;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.espello.services.UserRegistrationService.Configs.RegistrationConfig;
import com.espello.services.UserRegistrationService.Domain.SessionAnalysis;
import com.espello.services.UserRegistrationService.Domain.SessionDetails;
import com.espello.services.UserRegistrationService.Domain.SessionTranscript;
import com.espello.services.UserRegistrationService.Domain.UserSessionDetails;
import com.espello.services.UserRegistrationService.Dto.SessionAnalysisDTO;
import com.espello.services.UserRegistrationService.Dto.SessionDetailsDTO;
import com.espello.services.UserRegistrationService.Dto.Request.ConversationRequest;
import com.espello.services.UserRegistrationService.Dto.Request.ConversationTuple;
import com.espello.services.UserRegistrationService.Dto.Request.SessionCreateRequest;
import com.espello.services.UserRegistrationService.Dto.Response.SessionDetailsResponse;
import com.espello.services.UserRegistrationService.Dto.Response.SessionTranscriptResponse;

public class DTOBuilder {

	public static String generateSessionId(Integer userId) {
   
        long timestamp = Instant.now().toEpochMilli();

        SecureRandom random = new SecureRandom();
        
        StringBuilder randomPart = new StringBuilder(RegistrationConfig.SESSION_ID_RANDOMPART_LEN);
        for (int i = 0; i < RegistrationConfig.SESSION_ID_RANDOMPART_LEN; i++) {
            int randomIndex = random.nextInt(RegistrationConfig.ALPHANUMERIC_CHARS.length());
            randomPart.append(RegistrationConfig.ALPHANUMERIC_CHARS.charAt(randomIndex));
        }

        return String.format("%d-%d-%s", userId, timestamp, randomPart);
    }
	
	public static SessionDetails buildDto(SessionCreateRequest sessionCreateRequest) {
		
		SessionDetails sessionDetails = new SessionDetails();
		
		sessionDetails.setSessionId(generateSessionId(sessionCreateRequest.getUserId()));
		
		if(sessionCreateRequest.getSessionDetails()!=null) {
			sessionDetails.setCompanyType(sessionCreateRequest.getSessionDetails().getCompanyType());
			sessionDetails.setRole(sessionCreateRequest.getSessionDetails().getRole());
			sessionDetails.setMode(sessionCreateRequest.getSessionDetails().getMode());
			sessionDetails.setIndustry(sessionCreateRequest.getSessionDetails().getIndustry());
		}
		
		return sessionDetails;
		
	}
	
	public static SessionDetailsResponse buildDto(SessionDetails sessionDetails) {
		
		if(sessionDetails==null) {
			return null;
		}
		
		SessionDetailsResponse sessionDetailsResponse = new SessionDetailsResponse();
		
		SessionDetailsDTO sessionDetailsDTO = new SessionDetailsDTO();
		
		sessionDetailsDTO.setCompanyType(sessionDetails.getCompanyType());
		sessionDetailsDTO.setIndustry(sessionDetails.getIndustry());
		sessionDetailsDTO.setRole(sessionDetails.getRole());
		sessionDetailsDTO.setMode(sessionDetails.getMode());
		
		sessionDetailsResponse.setSessionId(sessionDetails.getSessionId());
		sessionDetailsResponse.setSessionDetails(sessionDetailsDTO);
		sessionDetailsResponse.setSessionStartTime(sessionDetails.getSessionStartTime());
		sessionDetailsResponse.setSessionEndTime(sessionDetails.getSessionEndTime());
		
		return sessionDetailsResponse;
	}
	
	
	public static SessionTranscript buildDto(ConversationRequest conversationRequest) {
		
		SessionTranscript sessionTranscript = new SessionTranscript();
		
		sessionTranscript.setSessionId(conversationRequest.getSessionId());
		sessionTranscript.setIntervieweeText(conversationRequest.getConversationTuple().getIntervieweeText());
		sessionTranscript.setInterviewerText(conversationRequest.getConversationTuple().getInterviewerText());
		
		return sessionTranscript;
	}
	
	public static SessionAnalysis buildDto(SessionAnalysisDTO sessionAnalysisDTO) {
		
		SessionAnalysis sessionAnalysis = new SessionAnalysis();
		
		sessionAnalysis.setSessionId(sessionAnalysisDTO.getSessionId());
		sessionAnalysis.setAnlysisParam1(sessionAnalysisDTO.getAnlysisParam1());
		sessionAnalysis.setAnlysisParam2(sessionAnalysisDTO.getAnlysisParam2());
		
		return sessionAnalysis;
	}
	
	public static SessionAnalysisDTO buildDto(SessionAnalysis sessionAnalysis) {
		
		if(sessionAnalysis==null) {
			return null;
		}
		
		SessionAnalysisDTO sessionAnalysisDTO = new SessionAnalysisDTO();
		
		sessionAnalysisDTO.setSessionId(sessionAnalysis.getSessionId());
		sessionAnalysisDTO.setAnlysisParam1(sessionAnalysis.getAnlysisParam1());
		sessionAnalysisDTO.setAnlysisParam2(sessionAnalysis.getAnlysisParam2());
		
		return sessionAnalysisDTO;
	}
	
	public static SessionTranscriptResponse buildDto(List<SessionTranscript> conversations) {
		
		if(CollectionUtils.isEmpty(conversations)) {
			return null;
		}
		
		SessionTranscriptResponse sessionTranscriptResponse = new SessionTranscriptResponse();
		
		List<ConversationTuple> conversationTuples = new ArrayList<>();
		
		if(CollectionUtils.isNotEmpty(conversations)) {
			for (SessionTranscript conversation : conversations) {
				ConversationTuple conversationTuple = new ConversationTuple();
				conversationTuple.setIntervieweeText(conversation.getIntervieweeText());
				conversationTuple.setInterviewerText(conversation.getInterviewerText());
				conversationTuples.add(conversationTuple);
			}
		}
		
		sessionTranscriptResponse.setConversationTuples(conversationTuples);
		
		return sessionTranscriptResponse;
	}
	
	public static UserSessionDetails buildDto(Integer userId, String sessionId) {
		
		UserSessionDetails userSessionDetails = new UserSessionDetails();
		
		userSessionDetails.setSessionId(sessionId);
		userSessionDetails.setUserId(userId);
		
		return userSessionDetails;
	}
}
