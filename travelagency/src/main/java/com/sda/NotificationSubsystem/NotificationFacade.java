package com.sda.NotificationSubsystem;

public class NotificationFacade {

    private NotificationInvoker invoker;

    public NotificationFacade(NotificationInvoker invoker) {
        this.invoker = invoker;
    }

    // Trigger the password reset notification
    public void sendPasswordResetNotification(List<String> placeholders) {
        // Create the password reset command with the appropriate templates
        Command passwordResetCommand = new PasswordResetCommand(
                new SMSTemplate(),
                new EmailTemplate(),
                new PopupTemplate()
        );
        invoker.addCommand(passwordResetCommand);
        invoker.execute();
    }

    // Trigger a general notification (could be booking, offer, etc.)
    public void sendGeneralNotification(List<String> placeholders) {
        // Create a general send notification command
        Command sendNotificationCommand = new SendNotificationCommand(
                new SMSTemplate(),
                new EmailTemplate(),
                new PopupTemplate()
        );
        invoker.addCommand(sendNotificationCommand);
        invoker.execute();
    }
}

