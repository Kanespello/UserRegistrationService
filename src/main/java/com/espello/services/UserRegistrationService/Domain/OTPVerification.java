package com.espello.services.UserRegistrationService.Domain;

import java.time.LocalDateTime;

import com.espello.services.UserRegistrationService.Enums.OTPStatus;
import com.espello.services.UserRegistrationService.Enums.VerificationModule;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "OTPVerification")
public class OTPVerification {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "verificationCode")
    private String verificationCode;
    
    @Column(name = "userId")
    private Integer userId;
    
    @Column(name = "status")
    private OTPStatus otpStatus;
    
    @Column(name = "module")
    private VerificationModule verificationModule;
    
    @Column(name = "verified_on")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="IST")
    private LocalDateTime verified_on;
    
    @Column(name = "added_on")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="IST")
    private LocalDateTime added_on;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public OTPStatus getOtpStatus() {
		return otpStatus;
	}

	public void setOtpStatus(OTPStatus otpStatus) {
		this.otpStatus = otpStatus;
	}

	public VerificationModule getVerificationModule() {
		return verificationModule;
	}

	public void setVerificationModule(VerificationModule verificationModule) {
		this.verificationModule = verificationModule;
	}

	public LocalDateTime getVerified_on() {
		return verified_on;
	}

	public void setVerified_on(LocalDateTime verified_on) {
		this.verified_on = verified_on;
	}

	public LocalDateTime getAdded_on() {
		return added_on;
	}

	public void setAdded_on(LocalDateTime added_on) {
		this.added_on = added_on;
	}

	@Override
	public String toString() {
		return "OTPVerification [id=" + id + ", verificationCode=" + verificationCode + ", userId=" + userId
				+ ", otpStatus=" + otpStatus + ", verificationModule=" + verificationModule + ", verified_on="
				+ verified_on + ", added_on=" + added_on + "]";
	}
  
}
