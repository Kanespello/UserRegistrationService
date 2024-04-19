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
@Table(name = "waitlist")
public class Waitlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "fullName")
    private String fullName;
    
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "message")
    private String message;
    
    @Column(name = "isEnterprise")
    private boolean isEnterprise;
    
    @Column(name = "submitDate")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="IST")
    private LocalDateTime submitDate = LocalDateTime.now();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isEnterprise() {
		return isEnterprise;
	}

	public void setEnterprise(boolean isEnterprise) {
		this.isEnterprise = isEnterprise;
	}

	public LocalDateTime getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(LocalDateTime submitDate) {
		this.submitDate = submitDate;
	}

	@Override
	public String toString() {
		return "Waitlist [id=" + id + ", email=" + email + ", fullName=" + fullName + ", phone=" + phone + ", message="
				+ message + ", isEnterprise=" + isEnterprise + ", submitDate=" + submitDate + "]";
	}
}
