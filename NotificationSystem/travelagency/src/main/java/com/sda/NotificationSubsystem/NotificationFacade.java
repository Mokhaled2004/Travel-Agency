package com.sda.NotificationSubsystem;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sda.NotificationSubsystem.Commands.Command;
import com.sda.NotificationSubsystem.Commands.SendNotificationCommand;
import com.sda.NotificationSubsystem.Templates.PopupTemplate;

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