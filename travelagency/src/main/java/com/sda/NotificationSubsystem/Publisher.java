package com.sda.NotificationSubsystem;

import java.util.ArrayList;
import java.util.List;

public class Publisher {

    private List<Subscriber> subscribers = new ArrayList<>();

    // Add a subscriber
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    // Notify all subscribers
    public void notifySubscribers() {
        for (Subscriber subscriber : subscribers) {
            subscriber.update();
        }
    }
}
