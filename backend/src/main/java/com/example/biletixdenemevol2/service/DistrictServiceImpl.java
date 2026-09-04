package com.example.biletixdenemevol2.service;

import com.example.biletixdenemevol2.exception.ResourceNotFoundException;

import com.example.biletixdenemevol2.dto.CityDTO;
import com.example.biletixdenemevol2.dto.DistrictDTO;
import com.example.biletixdenemevol2.entity.City;
import com.example.biletixdenemevol2.entity.District;
import com.example.biletixdenemevol2.repository.CityRepository;
import com.example.biletixdenemevol2.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@org.springframework.transaction.annotation.Transactional
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private CityRepository cityRepository;

    @Override
    public DistrictDTO createDistrict(DistrictDTO dto) {
        District district = prepareIlceEntity(dto);

        District savedIlce = districtRepository.save(district);

        return prepareIlceDTO(savedIlce);
    }

    @Override
    public DistrictDTO getDistrict(Long id) {
        District district = districtRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("İlce bulunamadı"));
       /* DistrictDTO dto = new DistrictDTO();
        dto.setId(district.getId());
        dto.setName(district.getName());*/

        return prepareIlceDTO(district);
    }

    @Override
    public DistrictDTO updateDistrict(Long id, DistrictDTO dto) {
        District district = districtRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("İlce Bulunamadı"));

        District updatedDistrict = districtRepository.save(prepareIlceEntity(dto));

        return prepareIlceDTO(updatedDistrict);
    }

    @Override
    public java.util.List<DistrictDTO> getAllDistricts() {
        return districtRepository.findAll().stream().map(this::prepareIlceDTO).collect(java.util.stream.Collectors.toList());
    }

    @Override
    public void deleteDistrict(Long id) {
        districtRepository.deleteById(id);
    }

    private District prepareIlceEntity(DistrictDTO dto) {
        District district = new District();
        district.setId(dto.getId());
        district.setName(dto.getName());

        CityDTO ilDTO = dto.getCity();
        if (ilDTO != null) {
            City ilEntity = new City();
            ilEntity.setId(ilDTO.getId());
            ilEntity.setName(ilDTO.getName());
            district.setCity(ilEntity);
        }

        return district;
    }

    private DistrictDTO prepareIlceDTO(District district) {
        DistrictDTO ilceDTO = new DistrictDTO();
        ilceDTO.setId(district.getId());
        ilceDTO.setName(district.getName());

        if (district.getCity() != null) {
            CityDTO ilDTO = new CityDTO();
            ilDTO.setId(district.getCity().getId());
            ilDTO.setName(district.getCity().getName());
            ilceDTO.setCity(ilDTO); // tam oturmadı şu kısım
        }
        return ilceDTO;
    }
}






