package com.example.airplanecompanydemo.service.impl;

import com.example.airplanecompanydemo.model.AirPlane;
import com.example.airplanecompanydemo.repository.AirPlaneRepository;
import com.example.airplanecompanydemo.service.AirPlaneService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AirPlaneServiceImpl implements AirPlaneService {
    private AirPlaneRepository airPlaneRepository;

    @Override
    public AirPlane add(AirPlane airPlane) {
        return airPlaneRepository.save(airPlane);
    }

    @Override
    public Optional<AirPlane> getById(Long id) {
        return airPlaneRepository.findById(id);
    }
}
