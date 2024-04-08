package com.espello.services.UserRegistrationService.Dto;

public class SessionDetailsDTO {
	
    private String role;
    
    private String mode;
    
    private String industry;
    
    private String companyType;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	@Override
	public String toString() {
		return "SessionDetailsDTO [role=" + role + ", mode=" + mode + ", industry=" + industry + ", companyType="
				+ companyType + "]";
	}
}
