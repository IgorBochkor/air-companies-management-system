package com.example.airplanecompanydemo.model.dto;

import lombok.Data;

@Data
public class AirPlaneResponseDto {
    private Long id;
    private String name;
    private String serialNumber;
    private Long airCompanyId;
    private int numberOfFlight;
    private int flightDistance;
    private int fuelCapacity;
    private String typeOfAirPlane;
    private String createdAt;
}
