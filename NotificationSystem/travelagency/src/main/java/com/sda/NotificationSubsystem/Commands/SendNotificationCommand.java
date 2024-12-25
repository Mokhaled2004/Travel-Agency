package com.sda.NotificationSubsystem.Commands;

import java.util.List;

import com.sda.NotificationSubsystem.Templates.NotificationTemplate;

public class SendNotificationCommand implements Command {
    private NotificationTemplate sms;
    private NotificationTemplate email;
    private NotificationTemplate popup;
    private List<String> placeholders;

    public SendNotificationCommand(NotificationTemplate sms, NotificationTemplate email, NotificationTemplate popup, List<String> placeholders) {
        this.sms = sms;
        this.email = email;
        this.popup = popup;
        this.placeholders = placeholders;
    }

    @Override
    public void execute(List<String> placeholders) {
        try {
            if (placeholders == null || placeholders.isEmpty()) {
                throw new IllegalArgumentException("Placeholders must not be null or empty");
            }
    
            this.placeholders = placeholders;
    
            if (popup != null) {
                String popupContent = popup.generateTemplate(placeholders);
                System.out.println("Sending Popup: " + popupContent);
                popup.incrementUsage();
            }
    
            if (sms != null) {
                String smsContent = sms.generateTemplate(placeholders);
                System.out.println("Sending SMS: " + smsContent);
                sms.incrementUsage();
            }
    
            if (email != null) {
                String emailContent = email.generateTemplate(placeholders);
                System.out.println("Sending Email: " + emailContent);
                email.incrementUsage();
            }
        } catch (Exception e) {
            System.err.println("Error executing command: " + e.getMessage());
        }
    }
    
}
