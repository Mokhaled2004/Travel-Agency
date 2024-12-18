package com.sda.travelagency.model;

public class SingleRoom extends Room {
    public SingleRoom(Long id, double price) {
        super(id, price);
    }

    @Override
    public String getType() {
        return "Single Room";
    }
}
