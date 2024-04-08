package com.espello.services.UserRegistrationService.Dto.Response;

import java.util.List;

import com.espello.services.UserRegistrationService.Dto.Request.ConversationTuple;

public class SessionTranscriptResponse {

	private List<ConversationTuple> conversationTuples;

	public List<ConversationTuple> getConversationTuples() {
		return conversationTuples;
	}

	public void setConversationTuples(List<ConversationTuple> conversationTuples) {
		this.conversationTuples = conversationTuples;
	}

	@Override
	public String toString() {
		return "SessionTranscript [conversationTuples=" + conversationTuples + "]";
	}
}
