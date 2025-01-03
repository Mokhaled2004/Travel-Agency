package com.sda.NotificationSubsystem.Templates;

public class SMSTemplate extends NotificationTemplate {



    public SMSTemplate(int templateId, boolean recipient, String language) {
        super(templateId, recipient, language);
    }

    public SMSTemplate() {
        super(0, false, "en");
        this.incrementUsage();
    }

    @Override
    public String prepareHeader() {
        return "SMS Header";
    }

    @Override
    public String prepareBody() {
        return "SMS Body with placeholders";
    }

    @Override
    public String prepareFooter() {
        return "SMS Footer";
    }
}