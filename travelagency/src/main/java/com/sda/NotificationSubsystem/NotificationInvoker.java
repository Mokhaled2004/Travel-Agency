package com.sda.NotificationSubsystem;
import java.util.LinkedList;
import java.util.Queue;

public class NotificationInvoker implements Publisher {

    private Queue<Command> notificationsQueue = new LinkedList<>();

    public NotificationInvoker(Subscriber[] subscribers) {
        this.subscribers = subscribers;
    }

    public void addCommand(Command command) {
        notificationsQueue.add(command);
    }

    @Override
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
            subscriber.update("Notification executed");
        }
    }
}
