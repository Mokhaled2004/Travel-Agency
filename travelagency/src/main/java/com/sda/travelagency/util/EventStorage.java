package com.sda.travelagency.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.travelagency.model.Event;

public class EventStorage {

    public static final String FILE_PATH = "events.json";
    public static final ObjectMapper objectMapper = new ObjectMapper();
    public static final List<Event> events = loadEvents();


    public static void addEvent(Event event) {
        events.add(event);
        saveEvents();
    }

   
    public static Event getEventById(long id) {
        return events.stream()
                    .filter(event -> event.getId() == id)
                    .findFirst()
                    .orElse(null);
    }


    public static Event getEventByName(String name) {
        return events.stream()
                    .filter(event -> (event.getName() == null ? name == null : event.getName().equals(name)))
                    .findFirst()
                    .orElse(null);
    }

    public static List<Event> getAllEvents() {
        return new ArrayList<>(events);
    }

    public static int getLastEventId() {
        if (events.isEmpty()) {
            return 0;
        }
        return events.stream()
                    .mapToInt(event -> (int) event.getId())
                    .max()
                    .orElse(0);
    }

    public static List<Event> loadEvents() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Event.class));
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void saveEvents() {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), events);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
