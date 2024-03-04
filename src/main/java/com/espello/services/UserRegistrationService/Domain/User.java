package com.espello.services.UserRegistrationService.Domain;


import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
    private Integer userId;

    @Column(name = "fullName")
    private String fullName;
    
    @Column(name = "firstName")
    private String firstName;
    
    @Column(name = "lastName")
    private String lastName;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "isdCode")
    private String isdCode;
    
    @Column(name = "mobile")
    private String mobile;
    
    @Column(name = "mobileWithIsd")
    private String mobileWithIsd;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "userCreationDate")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="IST")
    private LocalDateTime userCreationDate = LocalDateTime.now();

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIsdCode() {
		return isdCode;
	}

	public void setIsdCode(String isdCode) {
		this.isdCode = isdCode;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMobileWithIsd() {
		return mobileWithIsd;
	}

	public void setMobileWithIsd(String mobileWithIsd) {
		this.mobileWithIsd = mobileWithIsd;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getUserCreationDate() {
		return userCreationDate;
	}

	public void setUserCreationDate(LocalDateTime userCreationDate) {
		this.userCreationDate = userCreationDate;
	}

	@Override
	public String toString() {
		return "user [userId=" + userId + ", fullName=" + fullName + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", isdCode=" + isdCode + ", mobile=" + mobile + ", mobileWithIsd="
				+ mobileWithIsd + ", password=" + password + ", userCreationDate=" + userCreationDate + "]";
	}

}
