package com.sda.travelagency.model.Events;

public class LocalEvents extends Event {

    private String localGuideName;
    private boolean isOutdoor;

    public LocalEvents () {}

    public LocalEvents(int id, String name, String address, String date, boolean availableTickets, int ticketPrice,
                       String localGuideName, boolean isOutdoor) {
        super(id, name, address, date, availableTickets, ticketPrice);
        this.localGuideName = localGuideName;
        this.isOutdoor = isOutdoor;
    }

    public String getLocalGuideName() {
        return localGuideName;
    }

    public void setLocalGuideName(String localGuideName) {
        this.localGuideName = localGuideName;
    }

    public boolean isOutdoor() {
        return isOutdoor;
    }

    public void setOutdoor(boolean outdoor) {
        isOutdoor = outdoor;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", name=" + name + '\'' +
                ", address=" + address + '\'' +
                ", date=" + date + '\'' +
                ", available tickets=" + AvailableTickets + '\'' +
                ", localGuideName='" + localGuideName + '\'' +
                ", isOutdoor=" + isOutdoor +
                ", ticket price=" + TicketPrice + '}' ;
    }



}
