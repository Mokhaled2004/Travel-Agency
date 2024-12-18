package com.sda.travelagency.model;

public class FamilyRoom extends Room {
    public FamilyRoom(Long id, double price) {
        super(id, price);
    }

    @Override
    public String getType() {
        return "Family Room";
    }
}