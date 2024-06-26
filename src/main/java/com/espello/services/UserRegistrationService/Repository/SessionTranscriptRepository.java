package com.espello.services.UserRegistrationService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.espello.services.UserRegistrationService.Domain.SessionTranscript;

@Repository
public interface SessionTranscriptRepository extends JpaRepository<SessionTranscript, Integer> {

	List<SessionTranscript> findAllBySessionId(String SessionId);
}

