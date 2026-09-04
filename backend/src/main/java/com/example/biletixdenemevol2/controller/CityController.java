package com.example.biletixdenemevol2.controller;


import com.example.biletixdenemevol2.dto.CityDTO;
import com.example.biletixdenemevol2.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/city")
@CrossOrigin(origins = "http://localhost:4200")
public class CityController {
    @GetMapping
    public java.util.List<CityDTO> getAllCitys() {
        return cityService.getAllCitys();
    }


    @Autowired
    private CityService cityService;

    @PostMapping("/createCity")
    public CityDTO createCity(@RequestBody CityDTO dto) {
        return cityService.createCity(dto);
    }

    @GetMapping("/{id}")
    public CityDTO getCity(@PathVariable Long id) {
        return cityService.getCity(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CityDTO> updateCity(
            @PathVariable Long id,
            @RequestBody CityDTO dto) {

        CityDTO updated = cityService.updateCity(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable Long id){
        cityService.deleteCity(id);
    }
}
