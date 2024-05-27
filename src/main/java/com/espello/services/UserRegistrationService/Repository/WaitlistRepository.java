package com.espello.services.UserRegistrationService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.espello.services.UserRegistrationService.Domain.Waitlist;

@Repository
public interface WaitlistRepository extends JpaRepository<Waitlist, Integer>{

	List<Waitlist> findUserByEmail(String email);
	
}
