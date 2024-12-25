package com.sda.NotificationSubsystem;

import java.util.HashMap;
import java.util.Map;

public class NotificationStatisticManager implements Subscriber {

    private int successfulNotification;
    private int failedNotification;
    private Map<String, Integer> templates;

    public NotificationStatisticManager() {
        this.successfulNotification = 0;
        this.failedNotification = 0;
        this.templates = new HashMap<>();
    }

    @Override
    public void update() {
        successfulNotification++;
        System.out.println("Updated notification statistics" );
    }

    public int getSuccessfulNotification() {
        return successfulNotification;
    }

    public int getFailedNotification() {
        return failedNotification;
    }

    public String getMostUsedTemplate() {
        return templates.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No templates used");
    }

}