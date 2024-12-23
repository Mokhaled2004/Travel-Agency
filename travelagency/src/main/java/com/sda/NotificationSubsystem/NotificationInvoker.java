package com.sda.NotificationSubsystem;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.sda.NotificationSubsystem.Commands.Command;

public class NotificationInvoker extends  Publisher {

    private Queue<Command> notificationsQueue = new LinkedList<>();
    private Subscriber[] subscribers;

    public NotificationInvoker(Subscriber[] subscribers) {
        this.subscribers = subscribers;
    }

    public void addCommand(Command command) {
        notificationsQueue.add(command);
    }

    public void execute() {
        while (!notificationsQueue.isEmpty()) {
            Command command = notificationsQueue.poll();
            command.execute(List.of("User", "BookingDetails")); // Example placeholders
            notifySubscribers();
        }
    }

    @Override
    public void notifySubscribers() {
        for (Subscriber subscriber : subscribers) {
            subscriber.update();
        }
    }
}
