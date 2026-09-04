package com.example.biletixdenemevol2.service;

import com.example.biletixdenemevol2.exception.ResourceNotFoundException;

import com.example.biletixdenemevol2.dto.CityDTO;
import com.example.biletixdenemevol2.dto.DistrictDTO;
import com.example.biletixdenemevol2.entity.City;
import com.example.biletixdenemevol2.entity.District;
import com.example.biletixdenemevol2.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@org.springframework.transaction.annotation.Transactional
public class CityServiceImpl implements CityService {
    @Autowired
    CityRepository cityRepository;

    @Override
    public CityDTO createCity(CityDTO dto) {
        City city = prepareIlEntity(dto);

        City savedIl = cityRepository.save(city);

        dto.setId(savedIl.getId());
        return dto;
    }

    @Override
    public CityDTO getCity(Long id) {
        City city = cityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("City not found."));

        return prepareIlDTO(city);

    }

    @Override
    public CityDTO updateCity(Long id, CityDTO dto) {
        City city = cityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("City not found."));

        city.setName(dto.getName());

        city.setDistrictList(prepareIlceEntity(dto.getIlceDTOList() , city));

        City updatedCity = cityRepository.save(city);

        return prepareIlDTO(updatedCity);
    }

    @Override
    public java.util.List<CityDTO> getAllCitys() {
        return cityRepository.findAll().stream().map(this::prepareIlDTO).collect(java.util.stream.Collectors.toList());
    }

    @Override
    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }

    private City prepareIlEntity(CityDTO dto) {
        City city = new City();
        if (dto.getId() != null && dto.getId() != 0) {
            city.setId(dto.getId());
        }
        city.setName(dto.getName());
        city.setDistrictList(prepareIlceEntity(dto.getIlceDTOList(), city));

        return city;
    }

    private CityDTO prepareIlDTO(City city) {
        CityDTO ildto = new CityDTO();
        ildto.setId(city.getId());
        ildto.setName(city.getName());

        List<DistrictDTO> ilceDTOList = new ArrayList<>();
        if (city.getDistrictList() != null){
            for (District district : city.getDistrictList()) {
                DistrictDTO ilceDTO = new DistrictDTO();
                ilceDTO.setId(district.getId());
                ilceDTO.setName(district.getName());
                ilceDTOList.add(ilceDTO);
            }
        }
        ildto.setIlceDTOList(ilceDTOList);
        return ildto;
    }

    private List<District> prepareIlceEntity(List<DistrictDTO> ilceDTOList, City city) {
        List<District> districtList = new ArrayList<District>();

        if (ilceDTOList == null) {
            return districtList;
        }
        for (DistrictDTO ilceDTO : ilceDTOList) {
            District district = new District();
            district.setId(ilceDTO.getId());
            district.setName(ilceDTO.getName());
            district.setCity(city);
            districtList.add(district);
        }
        return districtList;
    }
}
