package com.sda.NotificationSubsystem;

import java.util.Collections;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class NotificationClient {
    private static final String BASE_URL = "http://localhost:8080/notification/api/notifications/send";

    public String sendNotification() {
        RestTemplate restTemplate = new RestTemplate();
        NotificationRequest request = new NotificationRequest(Collections.singletonList("John Doe"));

        ResponseEntity<String> response = restTemplate.postForEntity(BASE_URL, request, String.class);

        return response.getBody();
    }
}

class NotificationRequest {
    private List<String> placeholders;

    public NotificationRequest(List<String> placeholders) {
        this.placeholders = placeholders;
    }

    public List<String> getPlaceholders() {
        return placeholders;
    }

    public void setPlaceholders(List<String> placeholders) {
        this.placeholders = placeholders;
    }
}
