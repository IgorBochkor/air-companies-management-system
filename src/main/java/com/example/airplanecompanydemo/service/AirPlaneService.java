package com.example.airplanecompanydemo.service;

import com.example.airplanecompanydemo.model.AirPlane;
import java.util.Optional;

public interface AirPlaneService {
    AirPlane add(AirPlane airPlane);

    Optional<AirPlane> getById(Long id);
}
