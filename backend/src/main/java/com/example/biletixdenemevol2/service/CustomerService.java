package com.example.biletixdenemevol2.service;

import com.example.biletixdenemevol2.dto.CustomerDTO;
import com.example.biletixdenemevol2.entity.Customer;

import java.util.List;


public interface CustomerService {
    CustomerDTO createCustomer(CustomerDTO dto);
    CustomerDTO updateCustomer(long id, CustomerDTO dto);
    CustomerDTO getCustomer(Long id);
    void deleteCustomer(Long id);
    List<CustomerDTO> getAllCustomers();

}
