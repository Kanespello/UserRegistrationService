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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "verificationCode")
    private String verificationCode;
    
    @Column(name = "userId")
    private Integer userId;
    
    @Column(name = "retryCount")
    private Integer retryCount=0;
    
    @Column(name = "status")
    private OTPStatus otpStatus = OTPStatus.UNVERIFIED;
    
    @Column(name = "module")
    private VerificationModule verificationModule;
    
    @Column(name = "verifiedOn")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="IST")
    private LocalDateTime verifiedOn;
    
    @Column(name = "addedOn")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="IST")
    private LocalDateTime addedOn=LocalDateTime.now();

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

	public Integer getRetryCount() {
		return retryCount;
	}

	public void setRetryCount(Integer retryCount) {
		this.retryCount = retryCount;
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

	public LocalDateTime getVerifiedOn() {
		return verifiedOn;
	}

	public void setVerifiedOn(LocalDateTime verifiedOn) {
		this.verifiedOn = verifiedOn;
	}

	public LocalDateTime getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(LocalDateTime addedOn) {
		this.addedOn = addedOn;
	}

	@Override
	public String toString() {
		return "OTPVerification [id=" + id + ", verificationCode=" + verificationCode + ", userId=" + userId
				+ ", retryCount=" + retryCount + ", otpStatus=" + otpStatus + ", verificationModule="
				+ verificationModule + ", verifiedOn=" + verifiedOn + ", addedOn=" + addedOn + "]";
	}

}
