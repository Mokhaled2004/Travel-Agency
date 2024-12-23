package com.sda.NotificationSubsystem;

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
                new EmailTemplate(),
                new PopupTemplate(),
                placeholders
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


