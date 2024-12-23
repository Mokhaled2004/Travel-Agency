package com.sda.travelagency.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.travelagency.model.Events.LocalEvents;


public class LocalEventStorage {

public static final String FILE_PATH = "localevents.json";
    public static final ObjectMapper objectMapper = new ObjectMapper();
    public static final List<LocalEvents> localevents = loadLocalEvents();



    public static LocalEvents getLocalEventById(long id) {
        return localevents.stream()
                    .filter(Event -> Event.getId() == id)
                    .findFirst()
                    .orElse(null);
    }

    public static LocalEvents getLocalEventByName(String name) {
        return localevents.stream()
                    .filter(Event -> (Event.getName() == null ? name == null : Event.getName().equals(name)))
                    .findFirst()
                    .orElse(null);
    }


    public static List<LocalEvents> getAllLocalEvents() {
        return localevents;
    }



    public static List<LocalEvents> loadLocalEvents() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                System.out.println("File not found: " + FILE_PATH);
                return new ArrayList<>();
            }
            if (file.length() == 0) {
                System.out.println("File is empty: " + FILE_PATH);
                return new ArrayList<>();
            }
            return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, LocalEvents.class));
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to load local events: " + e.getMessage());
            return new ArrayList<>();
        }
    }
    

    public static void saveEvents() {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), localevents);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    




}
