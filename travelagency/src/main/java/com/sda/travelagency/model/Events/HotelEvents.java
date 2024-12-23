package com.sda.travelagency.model.Events;

public class HotelEvents extends Event {

    private String hotelName;

    public HotelEvents () {}

    public HotelEvents (int id, String name, String address, String date, boolean AvailableTickets, int TicketPrice, String hotelName) {
        super(id, name, address, date, AvailableTickets, TicketPrice);
        this.hotelName = hotelName;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", name=" + name + '\'' +
                ", address=" + address + '\'' +
                ", date=" + date + '\'' +
                ", available tickets=" + AvailableTickets + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", ticket price=" + TicketPrice + '}' ;
    }



}
