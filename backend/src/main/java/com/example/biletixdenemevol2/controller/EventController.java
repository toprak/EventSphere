package com.example.biletixdenemevol2.controller;

import com.example.biletixdenemevol2.dto.EventDTO;
import com.example.biletixdenemevol2.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/event")
@CrossOrigin(origins = "http://localhost:4200")
public class EventController{

    @Autowired
    private EventService eventService;

    @GetMapping
    public java.util.List<EventDTO> getAllEvents() {
        return eventService.getAllEvents();
    }



    @PostMapping("/createEvent")
    public EventDTO createEvent(@RequestBody EventDTO dto) {
        return eventService.createEvent(dto);
    }

    @GetMapping("/{id}")
    public EventDTO getEvent(@PathVariable Long id) {
        return eventService.getEvent(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventDTO> updateEvent(
            @PathVariable Long id,
            @RequestBody EventDTO dto){

        EventDTO updateDTO = eventService.updateEvent(id, dto);
        return ResponseEntity.ok(updateDTO);

    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
    }
}
