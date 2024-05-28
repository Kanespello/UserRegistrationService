package com.espello.services.UserRegistrationService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.espello.services.UserRegistrationService.Domain.AssistantThreads;

public interface AssistantThreadRepository extends JpaRepository<AssistantThreads, Integer> {

	AssistantThreads findBySessionId(String sessionId);
}
