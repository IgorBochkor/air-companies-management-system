package com.example.airplanecompanydemo.service.mapper;

import com.example.airplanecompanydemo.model.Flight;
import com.example.airplanecompanydemo.model.dto.FlightRequestDto;
import com.example.airplanecompanydemo.model.dto.FlightResponseDto;
import com.example.airplanecompanydemo.service.AirCompanyService;
import com.example.airplanecompanydemo.service.AirPlaneService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@AllArgsConstructor
public class FlightMapper {
    private static final String TIME_FORMAT = "dd.MM.yyyy HH:mm";
    private AirPlaneService airPlaneService;
    private AirCompanyService airCompanyService;

    public FlightResponseDto mapFlightToDto(Flight flight) {
        FlightResponseDto dto = new FlightResponseDto();
        dto.setId(flight.getId());
        dto.setAirCompanyId(flight.getAirCompany().getId());
        dto.setAirPlaneId(flight.getAirPlane().getId());
        dto.setDepartureCountry(flight.getDepartureCountry());
        dto.setDistance(dto.getDistance());
        dto.setDestinationCountry(flight.getDestinationCountry());
        dto.setEndedAt(flight.getEndedAt().format(DateTimeFormatter.ofPattern(TIME_FORMAT)));
        dto.setEstimatedFlightTime(flight.getEstimatedFlightTime());
        dto.setFlightStatus(flight.getFlightStatus());
        dto.setDelayStartedAt(flight.getDelayStartedAt()
                .format(DateTimeFormatter.ofPattern(TIME_FORMAT)));
        dto.setStartedAt(flight.getStartedAt().format(DateTimeFormatter.ofPattern(TIME_FORMAT)));
        return dto;
    }

    public Flight mapDtoToFlight(FlightRequestDto dto) {
        Flight flight = new Flight();
        flight.setFlightStatus(Flight.FlightStatus.PENDING);
        flight.setStartedAt(LocalDateTime.parse(dto.getStartedAt(),
                DateTimeFormatter.ofPattern(TIME_FORMAT)));
        flight.setDelayStartedAt(LocalDateTime.parse(dto.getDelayStartedAt(),
                DateTimeFormatter.ofPattern(TIME_FORMAT)));
        flight.setEndedAt(LocalDateTime.parse(dto.getEndedAt(),
                DateTimeFormatter.ofPattern(TIME_FORMAT)));
        flight.setEstimatedFlightTime(dto.getEstimatedFlightTime());
        flight.setDistance(dto.getDistance());
        flight.setDestinationCountry(dto.getDestinationCountry());
        flight.setDepartureCountry(dto.getDepartureCountry());
        flight.setAirPlane(airPlaneService.getById(dto.getAirCompanyId()).get());
        flight.setAirCompany(airCompanyService.getById(dto.getAirCompanyId()).get());
        return flight;
    }
}
