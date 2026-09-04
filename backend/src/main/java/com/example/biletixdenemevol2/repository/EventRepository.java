package com.example.biletixdenemevol2.repository;

import com.example.biletixdenemevol2.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface EventRepository extends JpaRepository<Event, Long> {

}
