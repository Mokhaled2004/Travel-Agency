package com.sda.NotificationSubsystem.Commands;

import java.util.List;

public interface Command {
    void execute(List<String> placeholders);
}
