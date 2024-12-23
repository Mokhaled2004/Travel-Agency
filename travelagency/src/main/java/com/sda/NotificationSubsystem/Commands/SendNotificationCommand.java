package com.sda.NotificationSubsystem.Commands;

import java.util.List;

import com.sda.NotificationSubsystem.Templates.NotificationTemplate;

public class SendNotificationCommand implements Command {
    private NotificationTemplate sms;
    private NotificationTemplate email;
    private NotificationTemplate popup;
    private List<String> placeholders;

    public SendNotificationCommand(NotificationTemplate sms, NotificationTemplate email, NotificationTemplate popup) {
        this.sms = sms;
        this.email = email;
        this.popup = popup;
    }

    @Override
    public void execute(List<String> placeholders) {
        this.placeholders = placeholders;

        // Generate notifications using the templates
        String smsContent = sms.generateTemplate(placeholders);
        String emailContent = email.generateTemplate(placeholders);
        String popupContent = popup.generateTemplate(placeholders);

        // Simulate sending notifications (logging in this case)
        System.out.println("Sending SMS: " + smsContent);
        System.out.println("Sending Email: " + emailContent);
        System.out.println("Sending Popup: " + popupContent);

        // Increment the usage count for each template
        sms.incrementUsage();
        email.incrementUsage();
        popup.incrementUsage();
    }
}
