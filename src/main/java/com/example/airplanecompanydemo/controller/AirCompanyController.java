package com.example.airplanecompanydemo.controller;

import com.example.airplanecompanydemo.model.AirCompany;
import com.example.airplanecompanydemo.model.dto.AirCompanyRequestDto;
import com.example.airplanecompanydemo.service.AirCompanyService;
import com.example.airplanecompanydemo.service.mapper.AirCompanyMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping("/air-companies")
@AllArgsConstructor
public class AirCompanyController {
    private AirCompanyService airCompanyService;
    private AirCompanyMapper airCompanyMapper;

    @PostMapping
    public ResponseEntity<AirCompany> create(@RequestBody @Valid AirCompanyRequestDto airCompanyRequestDto) {
        AirCompany airCompany = airCompanyMapper.mapDtoToAirCompany(airCompanyRequestDto);
        airCompanyService.add(airCompany);
        return new ResponseEntity<>(airCompany, HttpStatus.CREATED);
    }
}
