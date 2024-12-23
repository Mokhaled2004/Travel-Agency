package com.sda.travelagency.model.Events;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocalEvents extends Event {

    @JsonProperty("localGuideName")
    private String localGuideName;

    @JsonProperty("isOutdoor")
    private boolean isOutdoor;

    // No-args constructor required for Jackson
    public LocalEvents() {}

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

    public void setOutdoor(boolean isOutdoor) {
        this.isOutdoor = isOutdoor;
    }

    @Override
    public String toString() {
        return "LocalEvents{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", date='" + getDate() + '\'' +
                ", availableTickets=" + isAvailableTickets() +
                ", localGuideName='" + localGuideName + '\'' +
                ", isOutdoor=" + isOutdoor +
                ", ticketPrice=" + getTicketPrice() +
                '}';
    }
}
