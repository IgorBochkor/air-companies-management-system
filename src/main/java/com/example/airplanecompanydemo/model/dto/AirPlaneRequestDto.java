package com.example.airplanecompanydemo.model.dto;

import lombok.Data;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class AirPlaneRequestDto {
    @NotNull
    private String name;
    @NotNull
    private String serialNumber;
    private Long airCompanyId;
    @Min(1)
    private int numberOfFlight;
    private int flightDistance;
    private int fuelCapacity;
    @NotNull
    private String typeOfAirPlane;
    private String createdAt;
}
