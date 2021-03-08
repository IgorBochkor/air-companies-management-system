package com.example.airplanecompanydemo.controller;

import com.example.airplanecompanydemo.model.AirCompany;
import com.example.airplanecompanydemo.model.AirPlane;
import com.example.airplanecompanydemo.model.dto.AirPlaneRequestDto;
import com.example.airplanecompanydemo.service.AirCompanyService;
import com.example.airplanecompanydemo.service.AirPlaneService;
import com.example.airplanecompanydemo.service.mapper.AirPlaneMapper;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping("/airplanes")
@AllArgsConstructor
public class AirPlaneController {
    private AirPlaneService airPlaneService;
    private AirCompanyService airCompanyService;
    private AirPlaneMapper airPlaneMapper;

    @PutMapping
    public ResponseEntity<AirPlane> update(@RequestParam Long id, @RequestParam Long companyId) {
        Optional<AirPlane> airPlaneFromDb = airPlaneService.getById(id);
        Optional<AirCompany> airCompanyFromDb = airCompanyService.getById(companyId);
        if (!airPlaneFromDb.isPresent() || !airCompanyFromDb.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        AirPlane airPlane = airPlaneFromDb.get();
        AirCompany airCompany = airCompanyFromDb.get();
        airPlane.setAirCompany(airCompany);
        airPlaneService.add(airPlane);
        return new ResponseEntity<>(airPlane, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AirPlane> create(@RequestBody @Valid AirPlaneRequestDto airPlaneRequestDto) {
        AirPlane airPlane = airPlaneMapper.mapDtoToAirPlane(airPlaneRequestDto);
        airPlaneService.add(airPlane);
        return new ResponseEntity<>(airPlane, HttpStatus.CREATED);
    }
}
