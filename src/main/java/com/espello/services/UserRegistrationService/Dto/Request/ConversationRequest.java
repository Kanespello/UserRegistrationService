package com.espello.services.UserRegistrationService.Dto.Request;

import jakarta.validation.constraints.NotNull;

public class ConversationRequest {
	
	@NotNull
    private String sessionId;
    
	@NotNull
    private ConversationTuple conversationTuple;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public ConversationTuple getConversationTuple() {
		return conversationTuple;
	}

	public void setConversationTuple(ConversationTuple conversationTuple) {
		this.conversationTuple = conversationTuple;
	}

	@Override
	public String toString() {
		return "ConversationRequest [sessionId=" + sessionId + ", conversationTuple=" + conversationTuple + "]";
	}
    
}
