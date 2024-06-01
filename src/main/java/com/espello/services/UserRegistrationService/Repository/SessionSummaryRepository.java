package com.espello.services.UserRegistrationService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.espello.services.UserRegistrationService.Domain.SessionSummary;

public interface SessionSummaryRepository extends JpaRepository<SessionSummary, Integer> {

	SessionSummary findAllBySessionId(String sessionId);
}
