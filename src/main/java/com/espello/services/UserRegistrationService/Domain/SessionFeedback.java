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
@Table(name = "sessionFeedback")
public class SessionFeedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "rating")
    private Integer rating;
 
    @Column(name = "comments")
    private String comments;
    
    @Column(name = "sessionId")
    private String sessionId;
   
    @Column(name = "submitDate")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="IST")
    private LocalDateTime submitDate = LocalDateTime.now();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public LocalDateTime getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(LocalDateTime submitDate) {
		this.submitDate = submitDate;
	}

	@Override
	public String toString() {
		return "SessionFeedback [id=" + id + ", rating=" + rating + ", comments=" + comments + ", sessionId="
				+ sessionId + ", submitDate=" + submitDate + "]";
	}

}
