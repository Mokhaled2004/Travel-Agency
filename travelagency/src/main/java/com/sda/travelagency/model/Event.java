package com.sda.travelagency.model;

public class Event {

    private int id ;
    private String name ;
    private String address ;
    private String date ;
    private boolean AvailableTickets ;
    private int TicketPrice ;
    private String HotelName;

 public Event () {}

 public Event (int id, String name, String address, String date, boolean AvailableTickets, int TicketPrice, String HotelName) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.date = date;
    this.AvailableTickets = AvailableTickets;
    this.TicketPrice = TicketPrice;
    this.HotelName = HotelName;
}

public String getHotelName() {
    return HotelName;
}

public void setHotelName(String hotelName) {
    HotelName = hotelName;
}

public void setId(int id) {
    this.id = id;
}

public void setName(String name) {
    this.name = name;
}

public void setAddress(String address) {
    this.address = address;
}

public void setDate(String date) {
    this.date = date;
}

public void setAvailableTickets(boolean availableTickets) {
    AvailableTickets = availableTickets;
}

public void setTicketPrice(int ticketPrice) {
    TicketPrice = ticketPrice;
}

public int getId() {
    return id;
}

public String getName() {
    return name;
}

public String getAddress() {
    return address;
}

public String getDate() {
    return date;
}

public boolean isAvailableTickets() {
    return AvailableTickets;
}

public int getTicketPrice() {
    return TicketPrice;
}

@Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", name=" + name + '\'' +
                ", address=" + address + '\'' +
                ", date=" + date + '\'' +
                ", available tickets=" + AvailableTickets + '\'' +
                ", ticket price=" + TicketPrice + '}' ;
    }

}
