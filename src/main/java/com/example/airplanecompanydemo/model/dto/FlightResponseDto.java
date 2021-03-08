package com.example.airplanecompanydemo.model.dto;

import com.example.airplanecompanydemo.model.Flight;
import lombok.Data;

@Data
public class FlightResponseDto {
    private Long id;
    private Flight.FlightStatus flightStatus;
    private Long airCompanyId;
    private Long airPlaneId;
    private String departureCountry;
    private String destinationCountry;
    private int distance;
    private int estimatedFlightTime;
    private String endedAt;
    private String delayStartedAt;
    private String startedAt;
}
