package com.sda.travelagency.model;

public class DoubleRoom extends Room {
    public DoubleRoom(Long id, double price) {
        super(id, price);
    }

    @Override
    public String getType() {
        return "Double Room";
    }
}
