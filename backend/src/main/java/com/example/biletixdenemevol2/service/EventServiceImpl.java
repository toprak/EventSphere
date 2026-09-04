package com.example.biletixdenemevol2.service;

import com.example.biletixdenemevol2.exception.ResourceNotFoundException;

import com.example.biletixdenemevol2.dto.EventDTO;
import com.example.biletixdenemevol2.dto.CityDTO;
import com.example.biletixdenemevol2.dto.DistrictDTO;
import com.example.biletixdenemevol2.entity.Event;
import com.example.biletixdenemevol2.entity.City;
import com.example.biletixdenemevol2.entity.District;
import com.example.biletixdenemevol2.repository.EventRepository;
import com.example.biletixdenemevol2.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@org.springframework.transaction.annotation.Transactional
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private CityRepository cityRepository;



    @Override
    public EventDTO createEvent(EventDTO dto) {
        Event newEvent = prepareDTOToEntity(dto);

        return prepareEntityToDTO(eventRepository.save(newEvent));
    }

    @Override
    public EventDTO getEvent(Long id) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event not found."));
        return  prepareEntityToDTO(event);
    }

    @Override
    public EventDTO updateEvent(Long id, EventDTO dto) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event not found."));

        Event updatedEvent = prepareDTOToEntity(dto);
        updatedEvent.setId(event.getId());
        Event savedEtkinlik = eventRepository.save(updatedEvent);

        return prepareEntityToDTO(savedEtkinlik);
    }

    private EventDTO prepareEntityToDTO(Event event) {
        EventDTO dto = new EventDTO();
        dto.setId(event.getId());
        dto.setEventName(event.getEventName());
        dto.setEventDate(event.getEventDate());
        dto.setEventLocation(event.getEventLocation());

        if (event.getCityList() != null) {
            List<CityDTO> ilDTOList = event.getCityList().stream().map(city -> {
                        CityDTO ilDTO = new CityDTO();
                        ilDTO.setId(city.getId());
                        ilDTO.setName(city.getName());

                        // ilceDTOList'i doldur
                        if (city.getDistrictList() != null) {
                            List<DistrictDTO> ilceDTOs = city.getDistrictList().stream().map(district ->
                                    new DistrictDTO(district.getId(), district.getName(), null)).toList();
                            ilDTO.setIlceDTOList(ilceDTOs);
                        }
                        return ilDTO;
                    })
                    .toList();
            dto.setCityList(ilDTOList);
        }

        return dto;
    }

    private Event prepareDTOToEntity(EventDTO dto) {
        Event event = new Event();

        if (dto.getId() != 0) {
            event.setId(dto.getId());
        }
        event.setEventName(dto.getEventName());
        event.setEventDate(dto.getEventDate());
        event.setEventLocation(dto.getEventLocation());

        List<City> ilEntities = new ArrayList<>();
        if (dto.getCityList() != null) {
            for (CityDTO ilDTO : dto.getCityList()) {
                City ilEntity = cityRepository.findById(ilDTO.getId())
                        .orElseThrow(() -> new ResourceNotFoundException("İl bulunamadı: " + ilDTO.getId()));
                // Var olan ili etkinliğe bağla
                ilEntity.setEtkinlikler(event);
                ilEntities.add(ilEntity);
            }
            event.setCityList(ilEntities);
        }
        return event;
    }

    @Override
    public java.util.List<EventDTO> getAllEvents() {
        return eventRepository.findAll().stream().map(this::prepareEntityToDTO).collect(java.util.stream.Collectors.toList());
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
