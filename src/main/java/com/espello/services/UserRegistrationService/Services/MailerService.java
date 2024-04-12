package com.espello.services.UserRegistrationService.Services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MailerService {
	
	
	private static final Logger logger = LoggerFactory.getLogger(MailerService.class);
	
	public boolean sendEmail() {
	    // Define the API URL
	    String apiUrl = "https://api.brevo.com/v3/smtp/email";

	    // Create the JSON payload
	    String jsonPayload = String.format("""
	        {
	          "sender": {"email": "welcome@espello.com", "name": "Espello.ai"},
	          "to": [{"email": "agarwalnavneet080@gmail.com"}],
	          "subject": "Welcome to the Espello",
	          "htmlContent": "Welcome to the Espello"
	        }""");

	    // Create the HttpClient
	    HttpClient client = HttpClient.newHttpClient();

	    // Build the HttpRequest
	    HttpRequest request = HttpRequest.newBuilder()
	            .uri(URI.create(apiUrl))
	            .header("Accept", "application/json")
	            .header("Content-Type", "application/json")
	            .POST(BodyPublishers.ofString(jsonPayload))
	            .build();

	    try {
	        // Send the request
	        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

	        // Check the response status code
	        if (response.statusCode() == 201) { // 201 Created
	            System.out.println("Email sent successfully");
	            return true;
	        } else {
	            // Handle failure
	            System.err.println("Failed to send email: " + response.body());
	            return false;
	        }
	    } catch (IOException | InterruptedException e) {
	        // Handle errors
	        e.printStackTrace();
	        return false;
	    }
	}
}
