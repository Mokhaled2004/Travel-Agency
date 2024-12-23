package com.sda.NotificationSubsystem;

import com.sda.NotificationSubsystem.Commands.Command;
import com.sda.NotificationSubsystem.Templates.EmailTemplate;
import com.sda.NotificationSubsystem.Templates.PopupTemplate;
import com.sda.NotificationSubsystem.Templates.SMSTemplate;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Initialize the NotificationStatisticManager
        NotificationStatisticManager statsManager = new NotificationStatisticManager();

        // Initialize the NotificationInvoker
        NotificationInvoker notificationInvoker = new NotificationInvoker();

        // Create the NotificationFacade
        NotificationFacade notificationFacade = new NotificationFacade(notificationInvoker, statsManager);

        // Example 1: Send a Popup Notification
        System.out.println("Sending Popup Notification...");
        notificationFacade.sendPopupNotification(Arrays.asList("John Doe", "Your booking is confirmed!"));

        // Example 2: Send a Password Reset Notification
        System.out.println("\nSending Password Reset Notification...");
        String response = notificationFacade.sendPasswordResetNotification(Arrays.asList("John Doe", "Reset your password here: example.com/reset"));
        System.out.println(response);

        // Display statistics on the dashboard
        System.out.println("\nDisplaying Statistics:");
        notificationFacade.displayStatistics();
    }
}
