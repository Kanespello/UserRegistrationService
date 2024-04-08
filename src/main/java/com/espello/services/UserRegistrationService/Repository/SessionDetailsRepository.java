package com.espello.services.UserRegistrationService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.espello.services.UserRegistrationService.Domain.SessionDetails;

@Repository
public interface SessionDetailsRepository extends JpaRepository<SessionDetails, Integer> {

	SessionDetails findSessionDetailsBySessionId(String sessionId);
	
}
