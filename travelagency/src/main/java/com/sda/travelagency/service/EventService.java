package com.sda.travelagency.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.travelagency.model.Event;
import com.sda.travelagency.util.EventStorage;

@Service
public class EventService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public EventService() {
        
        EventStorage.loadEvents();
    }

    public String addEvent(Event event) {
        int newId = EventStorage.getLastEventId() + 1;
        event.setId(newId);

        if (EventStorage.getEventById(event.getId()) != null) {
            return "Event ID already exists"; 
        }
        if (!verifyEventDetails(event)) {
            return "Invalid event details"; 
        }
        EventStorage.addEvent(event);
        return "Event added successfully"; 
    }

    public boolean verifyEventDetails(Event event) {
        return event.getName() != null && !event.getName().isEmpty()
            && event.getAddress() != null && !event.getAddress().isEmpty();
    }

    public Event updateEvent(long id, Event event) {
        Event existingEvent = EventStorage.getEventById(id);
        if (existingEvent == null) {
            return null; 
        }
        existingEvent.setName(event.getName());
        existingEvent.setAddress(event.getAddress());
        existingEvent.setDate(event.getDate());
        existingEvent.setAvailableTickets(event.isAvailableTickets());
        existingEvent.setTicketPrice(event.getTicketPrice());

        EventStorage.saveEvents();
        return existingEvent;
    }

    public boolean deleteEvent(Event event) {
        boolean removed = EventStorage.events.remove(event);
        if (removed) {
            EventStorage.saveEvents();
        }
        return removed;
    }

    public Event searchEventByName(String name) {
        return EventStorage.getEventByName(name);
    }

    public Event getEventById(long id) {
        return EventStorage.getEventById(id);
    }

    public List<Event> getAllEvents() {
        return EventStorage.getAllEvents();
    }
}
