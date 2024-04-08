package com.espello.services.UserRegistrationService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.espello.services.UserRegistrationService.Domain.UserSessionDetails;
import com.espello.services.UserRegistrationService.Domain.Projections.UserSessionProjection;
import com.espello.services.UserRegistrationService.Enums.SessionStatus;

@Repository
public interface UserSessionDetailsRepository extends JpaRepository<UserSessionDetails, Integer> {

	List<UserSessionProjection> findSessionIdsByUserIdAndStatus(Integer userId, SessionStatus status);
	
	@Modifying
	@Query(value="UPDATE userSessionDetails SET status = 'history' WHERE userId = :userId", nativeQuery = true)
	void updatePreviousSessionStatusHistory(@Param("userId") Integer userId);
}

