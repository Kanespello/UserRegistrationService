package com.espello.services.UserRegistrationService.Dto.Request;

public class ConversationTuple {
	
    private String intervieweeText;
    
    private String interviewerText;

	public String getIntervieweeText() {
		return intervieweeText;
	}

	public void setIntervieweeText(String intervieweeText) {
		this.intervieweeText = intervieweeText;
	}

	public String getInterviewerText() {
		return interviewerText;
	}

	public void setInterviewerText(String interviewerText) {
		this.interviewerText = interviewerText;
	}

	@Override
	public String toString() {
		return "ConversationTuple [intervieweeText=" + intervieweeText + ", interviewerText=" + interviewerText + "]";
	}
    
}
