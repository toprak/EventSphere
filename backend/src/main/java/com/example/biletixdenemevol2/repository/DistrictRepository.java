package com.example.biletixdenemevol2.repository;

import com.example.biletixdenemevol2.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface DistrictRepository extends JpaRepository<District, Long> {
}
