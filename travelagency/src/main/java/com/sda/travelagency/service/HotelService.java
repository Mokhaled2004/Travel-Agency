package com.sda.travelagency.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.travelagency.model.Hotel;
import com.sda.travelagency.util.HotelStorage;




@Service
public class HotelService {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private NotificationService notificationService;

    public HotelService() {
        HotelStorage.loadHotels();
    }

    public String addHotel(Hotel hotel) {
        // Assign a new ID by incrementing the last used ID
        int newId = HotelStorage.getLastHotelId() + 1;
        hotel.setId(newId);

        if (HotelStorage.getHotelById(hotel.getId()) != null) {
            return "Hotel ID already exists"; // Hotel already exists
        }
        if (!verifyHotelDetails(hotel)) {
            return "Invalid hotel details"; // Hotel details are invalid
        }
        HotelStorage.addHotel(hotel);
        return "Hotel added successfully"; // Hotel added successfully
    }

    public boolean verifyHotelDetails(Hotel hotel) {
        return hotel.getName() != null && !hotel.getName().isEmpty()
            && hotel.getLocation() != null && !hotel.getLocation().isEmpty();
    }

    public Hotel updateHotel(long id, Hotel hotel) {
        Hotel existingHotel = HotelStorage.getHotelById(id);
        if (existingHotel == null) {
            return null;
        }
        existingHotel.setName(hotel.getName());
        existingHotel.setLocation(hotel.getLocation());
        existingHotel.setRating(hotel.getRating());
        existingHotel.setPhone(hotel.getPhone());
        existingHotel.setEmail(hotel.getEmail());
        HotelStorage.saveHotels();
        return existingHotel;
    }

    public boolean deleteHotel(Hotel hotel) {
        boolean removed = HotelStorage.hotels.remove(hotel);
        if (removed) {
            HotelStorage.saveHotels();
        }
        return removed;
    }
    public Hotel search(String name) {
        return HotelStorage.getHotelByName(name);
    }


    // Retrieve a hotel by ID from the list
    public Hotel getHotelById(long id) {
        return HotelStorage.getHotelById(id);
    }

    public List<Hotel> getAllHotels() {
        return HotelStorage.getAllHotels();
    }



    public boolean bookHotelRoom(int hotelId, String roomTypeString) {
        Hotel hotel = HotelStorage.getHotelById(hotelId);

        if (hotel == null) {
            throw new IllegalArgumentException("Hotel not found");
        }

        boolean bookingSuccessful = hotel.bookRoom(roomTypeString);

        if (bookingSuccessful) {
            // Compose the notification message
            String message = "Booking successful for Hotel: " + hotel.getName() + ", Room Type: " + roomTypeString;

            // Send the notification
            notificationService.sendNotification(message);
        } else {
            System.out.println("Booking failed for Hotel: " + hotel.getName() + ", Room Type: " + roomTypeString);
        }

        return bookingSuccessful;
    }

}