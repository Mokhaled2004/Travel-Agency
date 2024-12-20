/*package com.sda.travelagency.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sda.travelagency.model.Hotel;
import com.sda.travelagency.service.HotelService;
import com.sda.travelagency.util.HotelStorage;

@RestController
@RequestMapping("/HotelController")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/add")
    public ResponseEntity<String> addHotel(@RequestBody Hotel hotel) {
        String result = hotelService.addHotel(hotel);
        if ("Hotel added successfully".equals(result)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotels = hotelService.getAllHotels();
        if (hotels.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(hotels);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable long id, @RequestBody Hotel hotel) {
        Hotel updatedHotel = hotelService.updateHotel(id, hotel);
        if (updatedHotel == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(updatedHotel);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteHotel(@PathVariable long id) {
        Hotel hotel = hotelService.getHotelById(id);
        if (hotel == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel not found");
        }
        boolean deleted = hotelService.deleteHotel(hotel);
        if (deleted) {
            return ResponseEntity.ok("Hotel deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete hotel");
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable long id) {
        Hotel hotel = hotelService.getHotelById(id);
        if (hotel == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(hotel);
    }


    @GetMapping("/searchByName/{name}")
    public ResponseEntity<Hotel> getHotelByName(@PathVariable String name) {
        Hotel hotel = hotelService.getHotelByName(name);
        if (hotel == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(hotel);
    }

    @GetMapping("/searchByLocation/{location}")
    public ResponseEntity<Hotel> getHotelByLocation(@PathVariable String location) {
        Hotel hotel = HotelStorage.getHotelByLocation(location);
        if (hotel == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(hotel);
    }

    @GetMapping("/searchByRating/{rating}")
    public ResponseEntity<List<Hotel>> getHotelsByRating(@PathVariable double rating) {
        List<Hotel> hotels = HotelStorage.hotels.stream()
                .filter(hotel -> hotel.getRating() == rating)
                .toList();
        if (hotels.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(hotels);
    }
}

*/