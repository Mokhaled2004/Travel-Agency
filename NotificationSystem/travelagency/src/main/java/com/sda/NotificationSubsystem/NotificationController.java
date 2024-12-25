package com.sda.NotificationSubsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sda.NotificationSubsystem.Commands.SendNotificationCommand;
import com.sda.NotificationSubsystem.Templates.EmailTemplate;
import com.sda.NotificationSubsystem.Templates.PopupTemplate;
import com.sda.NotificationSubsystem.Templates.SMSTemplate;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationFacade notificationFacade;

    @PostMapping("/send")
    public String sendNotification(@RequestBody NotificationRequest request) {

        if (request.getPlaceholders() == null || request.getPlaceholders().isEmpty()) {
            return "Placeholders must not be null or empty!";
        }
    

        // Create templates
        SMSTemplate smsTemplate = new SMSTemplate();
        EmailTemplate emailTemplate = new EmailTemplate();
        PopupTemplate popupTemplate = new PopupTemplate();

        // Create command
        SendNotificationCommand command = new SendNotificationCommand(
                smsTemplate, emailTemplate, popupTemplate, request.getPlaceholders()
        );

        // Execute command
        notificationFacade.executeCommand(command);

        return "Notification sent successfully!";
    
   

        
    }
}

