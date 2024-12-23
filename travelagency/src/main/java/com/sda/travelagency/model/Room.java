package com.sda.travelagency.model;

public class Room {

    protected Long id;
    protected double price;
    protected boolean available;
    String String;

    public Room(Long id, double price, boolean available, String String) {
        this.id = id;
        this.price = price;
        this.available = available;
        this.String = String;
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

    public String getString() {
        return String;
    }

    public void setString(String String) {
        this.String = String;
    }
}


