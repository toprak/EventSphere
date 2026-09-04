package com.example.biletixdenemevol2.dto;

import com.example.biletixdenemevol2.entity.City;

import java.util.List;

public class CityDTO {
    private Long id;
    private String name;
    private List<DistrictDTO> ilceDTOList;


    public CityDTO(){}

    public CityDTO(Long id, String name, List<DistrictDTO> ilceDTOList) {
        this.id = id;
        this.name = name;
        this.ilceDTOList = ilceDTOList;
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

    public List<DistrictDTO> getIlceDTOList() {
        return ilceDTOList;
    }

    public void setIlceDTOList(List<DistrictDTO> ilceDTOList) {
        this.ilceDTOList = ilceDTOList;
    }
}
