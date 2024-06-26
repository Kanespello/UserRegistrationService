package com.espello.services.UserRegistrationService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.espello.services.UserRegistrationService.Domain.AssistantThreads;

public interface AssistantThreadRepository extends JpaRepository<AssistantThreads, Integer> {

	@Query(value = "SELECT * FROM assistantThreads WHERE sessionId = :sessionId ORDER BY submitDate DESC LIMIT 1", nativeQuery = true)
	AssistantThreads findBySessionId(String sessionId);
}
