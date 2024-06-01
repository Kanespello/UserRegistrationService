package com.espello.services.UserRegistrationService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.espello.services.UserRegistrationService.Domain.AssistantThreads;

public interface AssistantThreadRepository extends JpaRepository<AssistantThreads, Integer> {

	@Query(value = "SELECT * FROM AssistantThreads WHERE sessionId = :sessionId ORDER BY submit_date DESC LIMIT 1", nativeQuery = true)
	AssistantThreads findBySessionId(String sessionId);
}
