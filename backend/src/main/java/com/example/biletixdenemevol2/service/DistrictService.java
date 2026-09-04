package com.example.biletixdenemevol2.service;

import com.example.biletixdenemevol2.dto.DistrictDTO;

public interface DistrictService {
    DistrictDTO createDistrict(DistrictDTO dto);
    DistrictDTO getDistrict(Long id);
    DistrictDTO updateDistrict(Long id, DistrictDTO dto);
    void deleteDistrict(Long id);
    java.util.List<DistrictDTO> getAllDistricts();

}
