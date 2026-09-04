package com.example.biletixdenemevol2.controller;

import com.example.biletixdenemevol2.dto.CustomerDTO;
import com.example.biletixdenemevol2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        // Servis katmanında bu metodun (getAllCustomers) olması lazım!
        // Eğer hata verirse Service dosyanı kontrol edeceğiz.
        return customerService.getAllCustomers();
    }
    // ----------------------------------

    @PostMapping
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.createCustomer(customerDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(
            @PathVariable Long id,
            @RequestBody CustomerDTO customerDTO) {
        CustomerDTO updatedMusteriDTO = customerService.updateCustomer(id, customerDTO);
        return ResponseEntity.ok(updatedMusteriDTO);
    }

    @GetMapping("/{id}")
    public CustomerDTO getCustomerById(@PathVariable Long id) {
        return customerService.getCustomer(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}