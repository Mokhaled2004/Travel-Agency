package com.sda.travelagency.service;

import java.util.List;

import com.sda.travelagency.model.Event;


public interface EventFetchStrategy {
    public List<Event> fetchEvents();
}
