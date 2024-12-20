/*package com.sda.travelagency.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sda.travelagency.model.Event;
import com.sda.travelagency.service.EventService;

@RestController
@RequestMapping("/EventController")
public class EventController {

    @Autowired
    private EventService eventService;

    // Add a new event
    @PostMapping("/add")
    public ResponseEntity<String> addEvent(@RequestBody Event event) {
        eventService.addEvent(event);
        return ResponseEntity.status(HttpStatus.CREATED).body("Event added successfully");
    }

    // Get an event by id
    @GetMapping("/get/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable int id) {
        List<Event> events = eventService.getAllEvents();
        Event event = events.stream()
                            .filter(e -> e.getId().equalsIgnoreCase(id))
                            .findFirst()
                            .orElse(null);
        if (event == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(event);
    }

    // Update an event by id
    @PutMapping("/update/{id}")
    public ResponseEntity<Event> updateEventById(@PathVariable int id, @RequestBody Event updatedEvent) {
        List<Event> events = eventService.getAllEvents();
        Event existingEvent = events.stream()
                                    .filter(e -> e.getId().equalsIgnoreCase(id))
                                    .findFirst()
                                    .orElse(null);

        if (existingEvent == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        Event updated = eventService.updateEvent(existingEvent.getId(), updatedEvent);
        return ResponseEntity.ok(updated);
    }

    // Delete an event by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEventById(@PathVariable int id) {
        List<Event> events = eventService.getAllEvents();
        Event event = events.stream()
                            .filter(e -> e.getId().equalsIgnoreCase(id))
                            .findFirst()
                            .orElse(null);

        if (event == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event not found");
        }

        eventService.deleteEvent(event.getId());
        return ResponseEntity.ok("Event deleted successfully");
    }
}
*/
