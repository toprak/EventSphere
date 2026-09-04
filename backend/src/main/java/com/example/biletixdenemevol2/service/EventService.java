package com.example.biletixdenemevol2.service;

import com.example.biletixdenemevol2.dto.EventDTO;

public interface EventService {

    EventDTO createEvent(EventDTO dto);
    EventDTO getEvent(Long id);
    EventDTO updateEvent(Long id, EventDTO dto);
    void deleteEvent(Long id);
    java.util.List<EventDTO> getAllEvents();
}
