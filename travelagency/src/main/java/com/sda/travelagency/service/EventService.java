package com.sda.travelagency.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.travelagency.model.Event;
import com.sda.travelagency.model.User;
import com.sda.travelagency.util.EventStorage;
import com.sda.travelagency.util.UserStorage;

@Service
public class EventService {

    private static final String EVENT_FILE_PATH = "events.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public EventService() {
        loadEventsFromJson();
    }

    // Add an event to the list
    public boolean addEvent(Event event) {
        EventStorage.events.add(event);
        saveEventsToJson();
        return true;
    }

    // Update an event in the list
    public Event updateEvent(int id, Event event) {
        Event existingEvent = getEventById(id);
        if (existingEvent == null) {
            return null;
        }
        existingEvent.setName(event.getName());
        existingEvent.setAddress(event.getAddress());
        existingEvent.setDate(event.getDate());
        existingEvent.setAvailableTickets(event.isAvailableTickets());
        existingEvent.setTicketPrice(event.getTicketPrice());
        saveEventsToJson();
        return existingEvent;
    }

    public Event deleteEvent(int id) {
        Event event = getEventById(id);
        if (event == null) {
            return null;
        } else {
            EventStorage.events.remove(event);
            saveEventsToJson();
            return event;
        }

    }

    // Retrieve an event by ID
    public Event getEventById(int id) {
        Optional<Event> event = EventStorage.events.stream()
                .filter(e -> e.getName() == name)
                .findFirst();
        return event.orElse(null);
    }

    // Retrieve all events
    public List<Event> getAllEvents() {
        return EventStorage.events;
    }

    // Save the list of events to the JSON file
    private void saveEventsToJson() {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(EVENT_FILE_PATH), EventStorage.events);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load events from the JSON file into the list
    private void loadEventsFromJson() {
        try {
            File file = new File(EVENT_FILE_PATH);
            if (file.exists()) {
                List<Event> events = objectMapper.readValue(file,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, Event.class));
                if (events != null) {
                    EventStorage.events = events;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
