package com.example.biletixdenemevol2.dto;

import com.example.biletixdenemevol2.entity.City;
import com.example.biletixdenemevol2.entity.District;


public class DistrictDTO {
    private Long id;
    private String name;
    private CityDTO city;

    public DistrictDTO() {}

    public DistrictDTO(Long id, String name, CityDTO city) {
        this.id = id;
        this.name = name;
        this.city = city;
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
    public CityDTO getCity() {
        return city;
    }

    public void setCity(CityDTO city) {
        this.city = city;
    }
}
