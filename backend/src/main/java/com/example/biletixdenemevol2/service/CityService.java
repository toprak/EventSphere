package com.example.biletixdenemevol2.service;

import com.example.biletixdenemevol2.dto.CityDTO;

public interface CityService {
    CityDTO createCity(CityDTO dto);
    CityDTO getCity(Long id);
    CityDTO updateCity(Long id, CityDTO dto);
    void deleteCity(Long id);
    java.util.List<CityDTO> getAllCitys();
}
