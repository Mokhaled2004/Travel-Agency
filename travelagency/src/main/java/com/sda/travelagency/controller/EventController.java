package com.sda.travelagency.controller;

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

    @PostMapping("/addEvent")
    public ResponseEntity<String> addEvent(@RequestBody Event event) {
        String result = eventService.addEvent(event);
        if ("Event added successfully".equals(result)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        if (events.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(events);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable long id, @RequestBody Event event) {
        Event updatedEvent = eventService.updateEvent(id, event);
        if (updatedEvent == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(updatedEvent);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable long id) {
        Event event = eventService.getEventById(id);
        if (event == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event not found");
        }
        boolean deleted = eventService.deleteEvent(event);
        if (deleted) {
            return ResponseEntity.ok("Event deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete event");
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable long id) {
        Event event = eventService.getEventById(id);
        if (event == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(event);
    }

    @GetMapping("/searchByName/{name}")
    public ResponseEntity<Event> searchEventByName(@PathVariable String name) {
        Event event = eventService.searchEventByName(name);
        if (event == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(event);
    }
}