package com.example.biletixdenemevol2.dto;

import com.example.biletixdenemevol2.entity.City;

import java.time.LocalDate;
import java.util.List;

public class EventDTO {
    private long id;
    private String eventName;
    private String eventLocation;
    private LocalDate eventDate;
    private List<CityDTO> cityList;

    public EventDTO() {}

    public EventDTO(String eventName, long id, String eventLocation, LocalDate eventDate, List<CityDTO> cityList) {
        this.eventName = eventName;
        this.id = id;
        this.eventLocation = eventLocation;
        this.eventDate = eventDate;
        this.cityList = cityList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public List<CityDTO> getCityList() {
        return cityList;
    }

    public void setCityList(List<CityDTO> cityList) {
        this.cityList = cityList;
    }
}
