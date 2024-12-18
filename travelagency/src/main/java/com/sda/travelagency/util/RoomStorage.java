package com.sda.travelagency.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.travelagency.model.Room;
import com.sda.travelagency.model.SingleRoom;
import com.sda.travelagency.model.DoubleRoom;
import com.sda.travelagency.model.FamilyRoom;

public class RoomStorage {

    private static final String FILE_PATH = "rooms.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static List<Room> rooms = loadRooms();

    // Add a room and save to file
    public static void addRoom(Room room) {
        rooms.add(room);
        saveRooms();
    }

    // Retrieve a room by ID
    public static Room getRoomById(Long id) {
        return rooms.stream()
                .filter(room -> room.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Load rooms from JSON file
    private static List<Room> loadRooms() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            // Read rooms from the file, and map them to the correct concrete Room types
            return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Room.class));
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // Save rooms to JSON file
    private static void saveRooms() {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), rooms);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
