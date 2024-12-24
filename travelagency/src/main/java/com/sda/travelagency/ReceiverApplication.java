package com.sda.NotificationReceiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class ReceiverApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReceiverApplication.class, args);
    }
}

@RestController
@RequestMapping("/api/receive")
class ReceiverController {

    @PostMapping
    public String receiveNotification(@RequestBody String notificationContent) {
        System.out.println("Received Notification: " + notificationContent);
        return "Notification received!";
    }
}