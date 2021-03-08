package com.example.airplanecompanydemo.model.dto;

import com.example.airplanecompanydemo.model.Flight;
import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class FlightRequestDto {
    private Flight.FlightStatus flightStatus;
    @NotNull
    private Long airCompanyId;
    @NotNull
    private Long airPlaneId;
    @NotNull
    private String departureCountry;
    @NotNull
    private String destinationCountry;
    private int distance;
    private int estimatedFlightTime;
    private String endedAt;
    private String delayStartedAt;
    private String startedAt;
}
