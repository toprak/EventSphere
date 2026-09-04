package com.example.biletixdenemevol2.service;

import com.example.biletixdenemevol2.exception.ResourceNotFoundException;

import com.example.biletixdenemevol2.dto.CustomerDTO;
import com.example.biletixdenemevol2.entity.City;
import com.example.biletixdenemevol2.entity.District;
import com.example.biletixdenemevol2.entity.Customer;
import com.example.biletixdenemevol2.repository.CityRepository;
import com.example.biletixdenemevol2.repository.DistrictRepository;
import com.example.biletixdenemevol2.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@org.springframework.transaction.annotation.Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private DistrictRepository districtRepository;


    @Override
    public CustomerDTO createCustomer(CustomerDTO dto) {
       Customer newCustomer = prepareDTOToEntity(null , dto);
       return prepareEntityToDTO(customerRepository.save(newCustomer));
    }

    @Override
    public CustomerDTO getCustomer(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found!"));
        return prepareEntityToDTO(customer);
    }

    /**
     * process update customer
     * @param id
     * @param dto
     * @return
     */
    @Override
    public CustomerDTO updateCustomer(long id, CustomerDTO dto){
        Customer updatedCustomer = customerRepository.save(prepareDTOToEntity(id, dto));
        return prepareEntityToDTO(updatedCustomer);
    }

    private CustomerDTO prepareEntityToDTO(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setSurname(customer.getSurname());
        dto.setEmail(customer.getEmail());
        dto.setPhoneNumber(customer.getPhoneNumber());
        dto.setBirthDate(customer.getBirthDate());

        // İlişki varsa DTO'ya ID'lerini yaz
        if (customer.getCity() != null) {
            dto.setCityId(customer.getCity().getId());
        }
        if (customer.getDistrict() != null) {
            dto.setDistrictId(customer.getDistrict().getId());
        }

        return dto;
    }

    private Customer prepareDTOToEntity(Long id, CustomerDTO dto) {
        Customer customer;
        if (id != null){
            customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        } else {
            customer = new Customer();
        }

        customer.setName(dto.getName());
        customer.setSurname(dto.getSurname());
        customer.setEmail(dto.getEmail());
        customer.setPhoneNumber(dto.getPhoneNumber());
        customer.setBirthDate(dto.getBirthDate());

        // YENİ EKLENEN KISIM: İL ve İLÇE BAĞLAMA
        if (dto.getCityId() != null) {
            City city = cityRepository.findById(dto.getCityId()).orElseThrow(() -> new ResourceNotFoundException("City not found ID: " + dto.getCityId()));
            customer.setCity(city);
        }

        if (dto.getDistrictId() != null) {
            District district = districtRepository.findById(dto.getDistrictId())
                    .orElseThrow(() -> new ResourceNotFoundException("District not found ID: " + dto.getDistrictId()));
            customer.setDistrict(district);
        }

        return customer;
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream().map(this::prepareEntityToDTO).collect(Collectors.toList());
    }
}
