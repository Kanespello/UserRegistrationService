package com.espello.services.UserRegistrationService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.espello.services.UserRegistrationService.Domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findUserByEmail(String email);
	
	User findUserByMobileWithIsd(String mobileWithIsd);
	
	User findUserByUserId(Integer userId);
	
	@Modifying
	@Query(value="UPDATE user SET password = :password WHERE email = :email", nativeQuery = true)
	void setPassword(@Param("password") String password, @Param("email") String email);

}
