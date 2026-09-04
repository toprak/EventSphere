package com.example.biletixdenemevol2.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "event")

public class Event {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "event_name")
    private String eventName;

    @Column (name = "event_location")
    private String eventLocation;

    @Column (name = "event_date")
    private LocalDate eventDate;

    @OneToMany(mappedBy = "event" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<City> cityList = new ArrayList<City>();


    public Event() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", eventName='" + eventName + '\'' + ", eventLocation='" + eventLocation + '\'' + ", eventDate='" + eventDate + '\'' + '}';
    }
}
