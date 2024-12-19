package com.sda.travelagency.model;

import java.util.List;

public abstract class NotificationTemplate {
    protected int templateId;
    protected String language;

    public abstract String prepareHeader();
    public abstract String prepareBody();
    public abstract String prepareFooter();

    public String generateTemplate(List<String> placeholders) {
        return prepareHeader() + "\n" + prepareBody() + "\n" + prepareFooter();
    }
}