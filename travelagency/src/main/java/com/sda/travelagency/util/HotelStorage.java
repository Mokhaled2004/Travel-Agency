package com.sda.travelagency.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.travelagency.model.Hotel;

public class HotelStorage {

    public static final String FILE_PATH = "hotels.json";
    public static final ObjectMapper objectMapper = new ObjectMapper();
    public static final List<Hotel> hotels = loadHotels();

    public static void addHotel(Hotel hotel) {
        hotels.add(hotel);
        saveHotels();
    }

    public static Hotel getHotelById(long id) {
        return hotels.stream()
                    .filter(hotel -> hotel.getId() == id)
                    .findFirst()
                    .orElse(null);
    }

    public static Hotel getHotelByName(String name) {
        return hotels.stream()
                    .filter(hotel -> (hotel.getName() == null ? name == null : hotel.getName().equals(name)))
                    .findFirst()
                    .orElse(null);
    }


    public static List<Hotel> getAllHotels() {
        return new ArrayList<>(hotels);
    }

    public static int getLastHotelId() {
        if (hotels.isEmpty()) {
            return 0;
        }
        return hotels.stream()
                    .mapToInt(hotel -> (int) hotel.getId())
                    .max()
                    .orElse(0);
    }

    public static List<Hotel> loadHotels() {
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

    public static void saveHotels() {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), hotels);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    
}
