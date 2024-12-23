package com.sda.travelagency.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.travelagency.model.Event;


public class EventStorage {

public static final String FILE_PATH = "hotelevents.json";
    public static final ObjectMapper objectMapper = new ObjectMapper();
    public static final List<Event> events = loadEvents();

    public static void addEvent(Event Event) {
        events.add(Event);
        saveEvents();
    }

    public static Event getEventById(long id) {
        return events.stream()
                    .filter(Event -> Event.getId() == id)
                    .findFirst()
                    .orElse(null);
    }

    public static Event getEventByName(String name) {
        return events.stream()
                    .filter(Event -> (Event.getName() == null ? name == null : Event.getName().equals(name)))
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
                    .mapToInt(Event -> (int) Event.getId())
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

    public static Event getEventsByEventName(String name) {

        Event Event = getEventByName(name);
        if (Event == null) {
            return null;
        }
        return Event;
    }

    public static List<Event> getEventsByHotelName(String hotelName) {
        return events.stream()
                    .filter(Event -> (Event.getHotelName() == null ? hotelName == null : Event.getHotelName().equals(hotelName)))
                    .collect(Collectors.toList());
    }


}