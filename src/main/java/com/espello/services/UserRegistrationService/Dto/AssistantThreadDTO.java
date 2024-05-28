package com.espello.services.UserRegistrationService.Dto;

public class AssistantThreadDTO {

	 private String sessionId;
	    
	 private String threadId;
	    
	 private String assistantId;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getThreadId() {
		return threadId;
	}

	public void setThreadId(String threadId) {
		this.threadId = threadId;
	}

	public String getAssistantId() {
		return assistantId;
	}

	public void setAssistantId(String assistantId) {
		this.assistantId = assistantId;
	}

	@Override
	public String toString() {
		return "AssistantThreadRequest [sessionId=" + sessionId + ", threadId=" + threadId + ", assistantId="
				+ assistantId + "]";
	}
	 
}
