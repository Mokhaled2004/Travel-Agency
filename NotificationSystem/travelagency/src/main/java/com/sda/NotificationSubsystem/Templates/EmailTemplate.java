package com.sda.NotificationSubsystem.Templates;

public class EmailTemplate extends NotificationTemplate {

    public EmailTemplate(int templateId, boolean recipient, String language) {
        super(templateId, recipient, language);
    }

    public EmailTemplate() {
        super(0, false, "EN");
        this.incrementUsage();
    }

    @Override
    public String prepareHeader() {
        return "Email Header";
    }

    @Override
    public String prepareBody() {
        return "Email Body with placeholders";
    }

    @Override
    public String prepareFooter() {
        return "Email Footer";
    }
}