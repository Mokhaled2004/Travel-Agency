package com.sda.NotificationSubsystem.command;

import java.util.List;

public interface Command {
    void execute(List<String> placeholders);
}
