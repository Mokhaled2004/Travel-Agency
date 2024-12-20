package com.sda.travelagency.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.travelagency.model.Hotel;

public class HotelStorage {

    private static final String FILE_PATH = "hotels.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static List<Hotel> hotels = loadHotels();

    // Add a hotel and save to file
    public static void addHotel(Hotel hotel) {
        hotels.add(hotel);
        saveHotels();
    }

    // Retrieve a hotel by ID
    public static Hotel getHotelById(long id) {
        return hotels.stream()
                     .filter(hotel -> hotel.getId() == id)
                     .findFirst()
                     .orElse(null);
    }


    public static Hotel getHotelByName(String name) {
        return hotels.stream()
                     .filter(hotel -> hotel.getName().equalsIgnoreCase(name))
                     .findFirst()
                     .orElse(null);
    }

    public static Hotel getHotelByLocation(String location) {
        return hotels.stream()
                     .filter(hotel -> hotel.getLocation().equalsIgnoreCase(location))
                     .findFirst()
                     .orElse(null);
    }

    public static Hotel getHotelByRating(double rating) {
        return hotels.stream()
                     .filter(hotel -> hotel.getRating() == rating)
                     .findFirst()
                     .orElse(null);
    }

    // Load hotels from JSON file
    private static List<Hotel> loadHotels() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Hotel.class));
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // Save hotels to JSON file
    private static void saveHotels() {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), hotels);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
