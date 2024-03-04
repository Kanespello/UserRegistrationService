package com.espello.services.UserRegistrationService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.espello.services.UserRegistrationService.Domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findUserByEmail(String email);
	
	User findUserByMobileWithIsd(String mobileWithIsd);
	
	User findUserByUserId(Integer userId);
	
}
