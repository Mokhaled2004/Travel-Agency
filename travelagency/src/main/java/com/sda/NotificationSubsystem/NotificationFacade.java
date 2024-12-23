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
<<<<<<< HEAD
                new EmailTemplate()
=======
                new EmailTemplate(),
                new PopupTemplate(),
                placeholders
>>>>>>> 48e596a5f4586fec4c37d52bcf8ba19fa7e4daec
        );

        // Add the command to the invoker's queue
        notificationInvoker.addCommand(popupCommand);

        // Execute the command (send notification)
        notificationInvoker.execute();
    }

    // Method to get statistics
    public void displayStatistics() {
        System.out.println("Successful Notifications: " + statsManager.getSuccessfulNotification());
        System.out.println("Failed Notifications: " + statsManager.getFailedNotification());
        System.out.println("Most Used Templates: " + statsManager.getMostUsedTemplate());
    }
}


