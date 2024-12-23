package com.sda.travelagency.model;
enum RoomType {
    singleroom,
    doubleroom,
    tripleroom
}

public class Room {
    protected Long id;
    protected double price;
    protected boolean available;
    RoomType roomType;

    public Room(Long id, double price, boolean available, RoomType roomType) {
        this.id = id;
        this.price = price;
        this.available = available;
        this.roomType = roomType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }
}


