package com.example.airplanecompanydemo.repository;

import com.example.airplanecompanydemo.model.AirCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirCompanyRepository extends JpaRepository<AirCompany, Long> {
    AirCompany findAirCompanyByName(String name);
}
