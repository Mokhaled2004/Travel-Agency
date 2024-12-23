package com.sda.travelagency.model.Event;

public abstract class Event {

    private int id ;
    private String name ;
    private String address ;
    private String date ;
    private boolean AvailableTickets ;
    private int TicketPrice ;

    public Event () {}

    public Event (int id, String name, String address, String date, boolean AvailableTickets, int TicketPrice) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.date = date;
        this.AvailableTickets = AvailableTickets;
        this.TicketPrice = TicketPrice;
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
    public abstract String toString();



}
