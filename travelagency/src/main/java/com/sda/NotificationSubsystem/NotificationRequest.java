package com.sda.NotificationSubsystem;

import java.util.List;

public class NotificationRequest {
    private List<String> placeholders;

    public List<String> getPlaceholders() {
        return placeholders;
    }

    public void setPlaceholders(List<String> placeholders) {
        this.placeholders = placeholders;
    }
}