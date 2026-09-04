package com.example.biletixdenemevol2.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "city")

public class City{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "city_name")
    private String name;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<District> districtList = new ArrayList<District>();

    @ManyToOne
    @JoinColumn (name = "event_id")
    private Event event;


    public City() {}


    public City(String name) {
        this.name = name;
    }

    public List<District> getDistrictList() {
        return districtList;
    }

    public void setDistrictList(List<District> districtList) {
        this.districtList = districtList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Event getEvent() {
        return event;
    }

    public void setEtkinlikler(Event event) {
        this.event = event;
    }


    @Override
    public String toString() {
        return "City{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
