package com.example.airplanecompanydemo.service;

import com.example.airplanecompanydemo.model.AirCompany;
import java.util.List;
import java.util.Optional;

public interface AirCompanyService {
    AirCompany add(AirCompany airCompany);

    void remove(Long id);

    Optional<AirCompany> getById(Long id);

    List<AirCompany> getAll();

    AirCompany findByName(String name);
}
