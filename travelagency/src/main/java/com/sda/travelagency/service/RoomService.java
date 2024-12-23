/*package com.sda.travelagency.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.travelagency.model.Room;
import com.sda.travelagency.util.RoomStorage;

public class RoomFactory {

    public static Room createRoom(String roomType, Long id, double price) {
        if (roomType == null || roomType.isEmpty()) {
            throw new IllegalArgumentException("Room type cannot be null or empty");
        }

        switch (roomType.toLowerCase()) {
            case "single":
                return new SingleRoom(id, price);
            case "double":
                return new DoubleRoom(id, price);
            case "family":
                return new FamilyRoom(id, price);
            default:
                throw new IllegalArgumentException("Unknown room type: " + roomType);
        }
    }
}

 */