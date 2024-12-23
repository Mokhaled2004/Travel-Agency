package com.sda.NotificationSubsystem;

import java.util.List;

import com.sda.NotificationSubsystem.Commands.Command;
import com.sda.NotificationSubsystem.Commands.PasswordResetCommand;
import com.sda.NotificationSubsystem.Commands.SendNotificationCommand;
import com.sda.NotificationSubsystem.Templates.EmailTemplate;
import com.sda.NotificationSubsystem.Templates.PopupTemplate;
import com.sda.NotificationSubsystem.Templates.SMSTemplate;

public class NotificationFacade {

    private NotificationInvoker notificationInvoker;
    private NotificationStatisticManager statsManager;

    public NotificationFacade(NotificationInvoker invoker, NotificationStatisticManager statsManager) {
        this.notificationInvoker = invoker;
        this.statsManager = statsManager;
    }

    // Method to send Popup Notification
    public void sendPopupNotification(List<String> placeholders) {
        // Prepare the command to send the popup notification (e.g., reset password or booking)
        Command popupCommand = new ForgetPasswordCommand(
                new SMSTemplate(),
                new EmailTemplate()
                new EmailTemplate(),
                new PopupTemplate(),
                placeholders
        );

        // Add the command to the invoker's queue
        notificationInvoker.addCommand(popupCommand);

        // Execute the command (send notification)
        notificationInvoker.execute();
    }

    public String sendPasswordResetNotification(@RequestBody List<String> placeholders) {
        // Prepare the command to send a password reset notification
        Command resetPasswordCommand = new ForgetPasswordCommand(
                new SMSTemplate(),
                new EmailTemplate(),
                placeholders
        );

        // Add the command to the invoker's queue
        notificationInvoker.addCommand(resetPasswordCommand);

        // Execute the command (send notification)
        notificationInvoker.execute();

        return "Password reset notification sent successfully.";
    }

    // Method to get statistics
    public void displayStatistics() {
        System.out.println("Successful Notifications: " + statsManager.getSuccessfulNotification());
        System.out.println("Failed Notifications: " + statsManager.getFailedNotification());
        System.out.println("Most Used Templates: " + statsManager.getMostUsedTemplate());
    }
}


