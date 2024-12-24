package com.sda.NotificationSubsystem;

import com.sda.NotificationSubsystem.Commands.Command;
import org.springframework.stereotype.Component;

@Component
public class NotificationFacade {

    public void executeCommand(Command command) {
        command.execute(null); // Passing null since placeholders are already set in the command
    }
    public void sendPopupNotification(List<String> placeholders) {
        // Create PopupTemplate
        PopupTemplate popupTemplate = new PopupTemplate();

        // Create Command
        SendNotificationCommand command = new SendNotificationCommand(null, null, popupTemplate, placeholders);

        // Execute the command
        command.execute(placeholders);
    }
}