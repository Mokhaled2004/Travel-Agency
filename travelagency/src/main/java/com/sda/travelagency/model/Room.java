package com.sda.travelagency.model;

public abstract class Room {
    protected Long id;
    protected String type;
    protected double price;
    protected boolean available;


    public Room(Long id, double price) {
        this.id = id;
        this.price = price;
        this.available = true; // By default, rooms are available
    }

    public abstract String getType();

    public Long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", type='" + getType() + '\'' +
                ", price=" + price +
                ", available=" + available +
                '}';
    }
}
