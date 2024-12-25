package com.sda.NotificationSubsystem.Commands;

import java.util.List;

import com.sda.NotificationSubsystem.Templates.NotificationTemplate;

public class PasswordResetCommand implements Command {
    private NotificationTemplate sms;
    private NotificationTemplate email;
    private List<String> placeholders;

    public PasswordResetCommand(NotificationTemplate sms, NotificationTemplate email, List<String> placeholders) {
        this.sms = sms;
        this.email = email;
        this.placeholders = placeholders;
    }

    @Override
    public void execute(List<String> placeholders) {
        this.placeholders = placeholders;

        // Generate notifications using the templates
        String smsContent = sms.generateTemplate(placeholders);
        String emailContent = email.generateTemplate(placeholders);

        // Simulate sending notifications (logging in this case)
        System.out.println("Sending SMS: " + smsContent);
        System.out.println("Sending Email: " + emailContent);

        // Increment the usage count for each template
        sms.incrementUsage();
        email.incrementUsage();
    }

}
