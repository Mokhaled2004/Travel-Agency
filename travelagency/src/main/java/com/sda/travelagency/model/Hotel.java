package com.sda.travelagency.model;
import java.util.List;

public class Hotel {
    private int id;
    private String name;
    private String location;
    private String phone;
    private String email;
    private double rating;
    private List<Room> rooms;

    public Hotel(int id, String name, String location, String phone, String email ,double rating) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.rating=rating;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getEmail() {
            return email;
        }

    public void setEmail(String email) {
            this.email = email;
        }
    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", rating=" + rating +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


    public boolean bookRoom(RoomType roomType) {
        for (Room room : rooms) {
            if (room.getRoomType() == roomType && room.isAvailable()) {
                room.setAvailable(false);
                return true;
            }
        }
        return false;
    }
    


}