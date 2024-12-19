package com.sda.travelagency.model;

public class Hotel {
    private Long id;
    private String name;
    private String location;
    private String address;
    private String phone;
    private String email;

    public Hotel(Long id, String name, String location, String address, String phone, String email) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }



}