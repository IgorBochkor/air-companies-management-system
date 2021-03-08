package com.example.airplanecompanydemo.repository;

import com.example.airplanecompanydemo.model.AirPlane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirPlaneRepository extends JpaRepository<AirPlane, Long> {
}
