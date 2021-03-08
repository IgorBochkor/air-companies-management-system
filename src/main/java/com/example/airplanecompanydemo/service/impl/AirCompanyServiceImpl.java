package com.example.airplanecompanydemo.service.impl;

import com.example.airplanecompanydemo.model.AirCompany;
import com.example.airplanecompanydemo.repository.AirCompanyRepository;
import com.example.airplanecompanydemo.service.AirCompanyService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AirCompanyServiceImpl implements AirCompanyService {
    private final AirCompanyRepository airCompanyRepository;

    public AirCompanyServiceImpl(AirCompanyRepository airCompanyRepository) {
        this.airCompanyRepository = airCompanyRepository;
    }

    @Override
    public AirCompany add(AirCompany airCompany) {
        return airCompanyRepository.save(airCompany);
    }

    @Override
    public void remove(Long id) {
        airCompanyRepository.deleteById(id);
    }

    @Override
    public Optional<AirCompany> getById(Long id) {
        return airCompanyRepository.findById(id);
    }

    @Override
    public List<AirCompany> getAll() {
        return airCompanyRepository.findAll();
    }

    @Override
    public AirCompany findByName(String name) {
        return airCompanyRepository.findAirCompanyByName(name);
    }
}
