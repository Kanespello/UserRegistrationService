package com.espello.services.UserRegistrationService.Utility;

import java.security.SecureRandom;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;

import com.espello.services.UserRegistrationService.Configs.RegistrationConfig;
import com.espello.services.UserRegistrationService.Domain.AnalysisSubParam;
import com.espello.services.UserRegistrationService.Domain.SessionAnalysis;
import com.espello.services.UserRegistrationService.Domain.SessionDetails;
import com.espello.services.UserRegistrationService.Domain.SessionTranscript;
import com.espello.services.UserRegistrationService.Domain.UserSessionDetails;
import com.espello.services.UserRegistrationService.Dto.AnalysisDetailTuple;
import com.espello.services.UserRegistrationService.Dto.AnalysisParam;
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
	
	public static SessionAnalysis buildDto(String sessionId, AnalysisDetailTuple analysisDetailTuple) {
		
		SessionAnalysis sessionAnalysis = new SessionAnalysis();
		
		sessionAnalysis.setSessionId(sessionId);
		sessionAnalysis.setAnlysisParam(analysisDetailTuple.getAnalysisParam());
		sessionAnalysis.setAnlysisParamDesc(analysisDetailTuple.getAnalysisParamDesc());
		sessionAnalysis.setAnlysisParamScore(analysisDetailTuple.getAnalysisParamScore());
		
		return sessionAnalysis;
	}
	
	public static List<AnalysisSubParam> buildDto(Integer analysisParamId, List<AnalysisDetailTuple> subParamAnalysisDetailTuples) {
		
		List<AnalysisSubParam> analysisSubParams = new ArrayList<>();
		
		for (AnalysisDetailTuple analysisDetailTuple : subParamAnalysisDetailTuples) {
			AnalysisSubParam analysisSubParam = new AnalysisSubParam();
			analysisSubParam.setAnalysisParamId(analysisParamId);
			analysisSubParam.setAnlysisSubParam(analysisDetailTuple.getAnalysisParam());
			analysisSubParam.setAnlysisSubParamDesc(analysisDetailTuple.getAnalysisParamDesc());
			analysisSubParams.add(analysisSubParam);
		}
		
		return analysisSubParams;
	}
	
	public static SessionAnalysisDTO buildDto(List<SessionAnalysis> sessionAnalysises, List<AnalysisSubParam> analysisSubParams) {
		
		if(sessionAnalysises==null || analysisSubParams==null) {
			return null;
		}
		
		SessionAnalysisDTO sessionAnalysisDTO = new SessionAnalysisDTO();
		List<AnalysisParam> analysisParams = new ArrayList<>();
		
		for (SessionAnalysis sessionAnalysis : sessionAnalysises) {
			AnalysisParam analysisParam = new AnalysisParam();
			AnalysisDetailTuple analysisDetailTuple = new AnalysisDetailTuple();
			List<AnalysisDetailTuple> subParamsAnalysisDetailTuple = new ArrayList<>();
			
			analysisDetailTuple.setAnalysisParam(sessionAnalysis.getAnlysisParam());
			analysisDetailTuple.setAnalysisParamDesc(sessionAnalysis.getAnlysisParamDesc());
			analysisDetailTuple.setAnalysisParamScore(sessionAnalysis.getAnlysisParamScore());
			
			List<AnalysisSubParam> filteredSubParams = analysisSubParams.stream()
				    .filter(subParam -> subParam.getAnalysisParamId() == sessionAnalysis.getId())  // Only include items where id matches
				    .collect(Collectors.toList());  // Collect the results into a new list
			
			if(CollectionUtils.isNotEmpty(filteredSubParams)) {
				for (AnalysisSubParam analysisSubParam : filteredSubParams) {
					AnalysisDetailTuple analysisSubParamDetailTuple = new AnalysisDetailTuple();
					analysisSubParamDetailTuple.setAnalysisParam(analysisSubParam.getAnlysisSubParam());
					analysisSubParamDetailTuple.setAnalysisParamDesc(analysisSubParam.getAnlysisSubParamDesc());
					subParamsAnalysisDetailTuple.add(analysisSubParamDetailTuple);
				}
			}
			analysisParam.setAnalysisDetailTuple(analysisDetailTuple);
			analysisParam.setSubParamsAnalysisDetailTuple(subParamsAnalysisDetailTuple);
			analysisParams.add(analysisParam);
		}
		
		sessionAnalysisDTO.setAnalysisParams(analysisParams);
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
