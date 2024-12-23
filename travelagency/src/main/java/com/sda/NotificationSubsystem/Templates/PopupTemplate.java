package com.sda.NotificationSubsystem.Templates;

public class PopupTemplate extends NotificationTemplate {

    public PopupTemplate(int templateId, boolean recipient, String language) {
        super(templateId, recipient, language);
    }

    public PopupTemplate() {
        super(0, false, "en");
        this.incrementUsage();
    }

    @Override
    public String prepareHeader() {
        return "Popup Header";
    }

    @Override
    public String prepareBody() {
        return "Popup Body with placeholders";
    }

    @Override
    public String prepareFooter() {
        return "Popup Footer";
    }
}