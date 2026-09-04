package com.example.biletixdenemevol2.repository;

import com.example.biletixdenemevol2.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
