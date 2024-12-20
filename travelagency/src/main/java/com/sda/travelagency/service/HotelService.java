package com.sda.travelagency.service;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.travelagency.model.Hotel;
import com.sda.travelagency.util.HotelStorage;


public class HotelService {


    private static final String FILE_PATH = "hotel.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public HotelService() {
        loadHotelsFromJson();
    }

    public boolean add(Hotel hotel) {
        HotelStorage.hotels.add(hotel);
        saveHotelsToJson();
        return true;
    }

    public boolean verifyHotelDetails(Hotel hotel) {
        return hotel.getName() != null && !hotel.getName().isEmpty()
            && hotel.getLocation() != null && !hotel.getLocation().isEmpty();
    }


    public String addHotel(Hotel hotel) {
        if (getHotelById(hotel.getId()) != null) {
            return "Hotel ID already exists"; // Hotel already exists
        }
        if (!verifyHotelDetails(hotel)) {
            return "Invalid hotel details"; // Hotel details are invalid
        }
        add(hotel);
        return "Hotel added successfully"; // Hotel added successfully
    }

    public Hotel updateHotel(long id, Hotel hotel) {
        Hotel existingHotel = getHotelById(id);
        if (existingHotel == null) {
            return null;
        }
        existingHotel.setName(hotel.getName());
        existingHotel.setLocation(hotel.getLocation());
        existingHotel.setRating(hotel.getRating());
        existingHotel.setphone(hotel.getphone());
        existingHotel.setemail(hotel.getemail());
        saveHotelsToJson();
        return existingHotel;
    }

   
    public boolean deleteHotel(Hotel hotel) {
        boolean removed = HotelStorage.hotels.remove(hotel);
        if (removed) {
            saveHotelsToJson();
        }
        return removed;
    }




    public boolean book() {
        // Logic for booking a hotel
        // Placeholder for now
        return true;
    }


    public boolean view() {
        // Logic for viewing hotels
        // Placeholder for now
        return true;
    }

    public boolean search() {
        // Logic for searching hotels
        // Placeholder for now
        return true;
    }

 //   public boolean bookRoom(int userId, PaymentStrategy paymentStrategy) {
        // Logic for booking a room with a payment strategy
        // Placeholder for now
     //   return true;
   // }

    // Retrieve a hotel by ID from the list
    public Hotel getHotelById(long id) {
        Optional<Hotel> hotel = HotelStorage.hotels.stream()
            .filter(h -> h.getId() == id)
            .findFirst();
        return hotel.orElse(null);
    }

    public Hotel getHotelByName(String name) {
        Optional<Hotel> hotel = HotelStorage.hotels.stream()
            .filter(h -> h.getName().equalsIgnoreCase(name))
            .findFirst();
        return hotel.orElse(null);
    }

    public List<Hotel> getHotelsByLocation(String location) {
        return HotelStorage.hotels.stream()
            .filter(h -> h.getLocation().equalsIgnoreCase(location))
            .collect(Collectors.toList());
    }

    public List<Hotel> getHotelsByRating(double rating) {
        return HotelStorage.hotels.stream()
            .filter(h -> h.getRating() == rating)
            .collect(Collectors.toList());
    }

    public List<Hotel> getAllHotels() {
        return HotelStorage.hotels;
    }

    // Save the list of hotels to the JSON file
    private void saveHotelsToJson() {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), HotelStorage.hotels);
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load hotels from the JSON file into the list
    private void loadHotelsFromJson() {
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                List<Hotel> hotels = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Hotel.class));
                if (hotels != null) {
                  
                    HotelStorage.hotels=hotels;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
