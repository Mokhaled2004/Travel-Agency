package com.sda.travelagency.model;

public class Hotel {
    private Long id;
    private String name;
    private String location;
    private String phone;
    private String email;
    private double rating;

    public Hotel(Long id, String name, String location, String phone, String email ,double rating) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.rating=rating;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getemail() {
            return email;
        }

    public void setemail(String email) {
            this.email = email;
        }
     
    public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
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

}