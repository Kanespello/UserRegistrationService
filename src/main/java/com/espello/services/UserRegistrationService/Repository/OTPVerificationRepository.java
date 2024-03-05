package com.espello.services.UserRegistrationService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.espello.services.UserRegistrationService.Domain.OTPVerification;
import com.espello.services.UserRegistrationService.Enums.OTPStatus;
import com.espello.services.UserRegistrationService.Enums.VerificationModule;

@Repository
public interface OTPVerificationRepository extends JpaRepository<OTPVerification, Integer> {
    
	@Query("select ol from OTPVerification ol where ol.userId = ?3 AND ol.otpStatus = ?1 AND TIMESTAMPDIFF(MINUTE, ol.addedOn, CURRENT_TIMESTAMP) <= ?2")
	OTPVerification verifyOTP(OTPStatus otpStatus, Integer timeout, Integer userId);

    @Modifying
    @Query("update OTPVerification ol set ol.otpStatus = ?2, ol.verifiedOn = NOW() where ol.verificationCode = ?1 AND ol.userId = ?3")
    int markVerified(String verificationCode, OTPStatus otpStatus, Integer userId);
    
    @Modifying
    @Query("update OTPVerification ol set ol.retryCount = ?2 where ol.verificationModule = ?1 AND ol.userId = ?3")
    int updateRetryCount(VerificationModule verificationModule, Integer retryCount, Integer userId);
}
