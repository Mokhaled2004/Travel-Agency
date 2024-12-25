package com.sda.travelagency.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {

    private final RestTemplate restTemplate;

    public NotificationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String sendNotification(String message) {
        String receiverApiUrl = "http://localhost:8080/api/receive"; // URL of the ReceiverApplication
        try {
            return restTemplate.postForObject(receiverApiUrl, message, String.class);
        } catch (Exception e) {
            return "Failed to send notification: " + e.getMessage();
        }
    }
}
