package com.espello.services.UserRegistrationService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.espello.services.UserRegistrationService.Domain.SessionFeedback;

@Repository
public interface SessionFeedbackRepository extends JpaRepository<SessionFeedback, Integer>{
	
}
