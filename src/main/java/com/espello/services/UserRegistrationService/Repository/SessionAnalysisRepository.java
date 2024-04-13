package com.espello.services.UserRegistrationService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.espello.services.UserRegistrationService.Domain.SessionAnalysis;

@Repository
public interface SessionAnalysisRepository extends JpaRepository<SessionAnalysis, Integer> {

	List<SessionAnalysis> findAllSessionAnalysisBySessionId(String sessionId);
}
