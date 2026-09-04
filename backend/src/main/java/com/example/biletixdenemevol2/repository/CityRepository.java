package com.example.biletixdenemevol2.repository;

import com.example.biletixdenemevol2.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CityRepository extends JpaRepository<City, Long> {
}
