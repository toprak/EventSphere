package com.example.biletixdenemevol2.controller;

import com.example.biletixdenemevol2.dto.DistrictDTO;
import com.example.biletixdenemevol2.service.DistrictService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/district")
@CrossOrigin(origins = "http://localhost:4200")
public class DistrictController {
    @GetMapping
    public java.util.List<DistrictDTO> getAllDistricts() {
        return districtService.getAllDistricts();
    }


    private final DistrictService districtService;

    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }

    @PostMapping("/createDistrict")
    public DistrictDTO createDistrict(@RequestBody DistrictDTO ilceDTO) {
        return districtService.createDistrict(ilceDTO);
    }

    @GetMapping("/{id}")
    public DistrictDTO getDistrict(@PathVariable Long id) {
        return districtService.getDistrict(id);
    }

    @PutMapping("/{id}")
    public DistrictDTO updateDistrict(@PathVariable Long id, @RequestBody DistrictDTO ilceDTO) {
        return districtService.updateDistrict(id , ilceDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteDistrict(@PathVariable Long id) {
        districtService.deleteDistrict(id);
    }

}
