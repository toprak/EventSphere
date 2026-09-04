package com.example.biletixdenemevol2.dto;

import java.time.LocalDate;

public class CustomerDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private LocalDate birthDate;
    private Long cityId;
    private Long districtId;

    public CustomerDTO() {}

    public CustomerDTO(Long id, String name, String surname, String email, LocalDate birthDate, String phoneNumber, Long cityId, Long districtId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.cityId = cityId;
        this.districtId = districtId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }
}
