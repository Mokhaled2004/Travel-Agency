package com.sda.travelagency.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sda.travelagency.model.Event;
import com.sda.travelagency.model.Events.LocalEvents;
import com.sda.travelagency.util.EventStorage;
import com.sda.travelagency.util.LocalEventStorage;



@Service
public class EventService implements EventFetchStrategy {

    public EventService() {
        LocalEventStorage.loadLocalEvents();
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
        existingEvent.setHotelName(event.getHotelName());

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

    private int getLastEventId() {
        return EventStorage.getLastEventId();  
    }

    public List<Event> getEventsByHotelName(String hotelName) {
        return EventStorage.getEventsByHotelName(hotelName);
    }

    public Event getEventByName(String name) {
        return EventStorage.getEventByName(name);
    }

    public List<LocalEvents> getAllLocalEvents() {
        return LocalEventStorage.getAllLocalEvents();
    }

    public LocalEvents getLocalEventById(long id) {
        return LocalEventStorage.getLocalEventById(id);
    }

    @Override
    public List<Event> fetchEvents() {
        List<Event> allEvents = EventStorage.getAllEvents(); // Fetch all general events
        List<LocalEvents> allLocalEvents = LocalEventStorage.getAllLocalEvents(); // Fetch all local events
    
        // Add all local events to the general events list
        allEvents.addAll((List<? extends Event>) (List<?>) allLocalEvents);
    
        return allEvents;
    }
    
    


    


}