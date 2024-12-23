package com.sda.NotificationSubsystem.Templates;
import java.util.List;


public abstract class NotificationTemplate {

    protected int templateId;
    protected boolean recipient;
    protected String language;
    protected int numberOfUsages;

    public NotificationTemplate(int templateId, boolean recipient, String language) {
        this.templateId = templateId;
        this.recipient = recipient;
        this.language = language;
        this.numberOfUsages = 0; // Initializes usage count to 0
    }

    public int getTemplateId() {
        return templateId;
    }

    public boolean isRecipient() {
        return recipient;
    }

    public String getLanguage() {
        return language;
    }

    public int getNumberOfUsages() {
        return numberOfUsages;
    }

    public void incrementUsage() {
        this.numberOfUsages++;
    }

    // Abstract methods to be implemented by subclasses
    public abstract String prepareHeader();
    public abstract String prepareBody();
    public abstract String prepareFooter();

    public String generateTemplate(List<String> placeholders) {
        // This method generates the full template by replacing placeholders in the body
        String body = prepareBody();
        for (int i = 0; i < placeholders.size(); i++) {
            body = body.replace("{" + i + "}", placeholders.get(i));
        }
        return prepareHeader() + "\n" + body + "\n" + prepareFooter();
    }
}