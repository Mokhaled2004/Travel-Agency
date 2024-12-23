package com.sda.travelagency.service;

import java.util.List;

import com.sda.travelagency.model.Hotel;

public interface HotelFetchStrategy {
    public List<Hotel> fetchHotels();

}
