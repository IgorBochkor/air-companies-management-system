package com.example.airplanecompanydemo.service.mapper;

import com.example.airplanecompanydemo.model.AirPlane;
import com.example.airplanecompanydemo.model.dto.AirPlaneRequestDto;
import com.example.airplanecompanydemo.model.dto.AirPlaneResponseDto;
import com.example.airplanecompanydemo.service.AirCompanyService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AirPlaneMapper {
    private AirCompanyService airCompanyService;
    private static final String DATE_FORMAT = "dd.MM.yyyy";

    public AirPlane mapDtoToAirPlane(AirPlaneRequestDto dto) {
        AirPlane airPlane = new AirPlane();
        airPlane.setName(dto.getName());
        airPlane.setSerialNumber(dto.getSerialNumber());
        LocalDate dateTime = LocalDate.parse(dto.getCreatedAt(),
                DateTimeFormatter.ofPattern(DATE_FORMAT));
        airPlane.setCreatedAt(dateTime);
        airPlane.setFlightDistance(dto.getFlightDistance());
        airPlane.setFuelCapacity(dto.getFuelCapacity());
        airPlane.setNumberOfFlight(dto.getNumberOfFlight());
        airPlane.setTypeOfAirPlane(dto.getTypeOfAirPlane());
        if (dto.getAirCompanyId() != null) {
            airPlane.setAirCompany(airCompanyService.getById(dto.getAirCompanyId()).get());
        }
        return airPlane;
    }

    public AirPlaneResponseDto mapAirPlaneToDto(AirPlane airPlane) {
        AirPlaneResponseDto dto = new AirPlaneResponseDto();
        dto.setId(airPlane.getId());
        dto.setAirCompanyId(airPlane.getAirCompany().getId());
        dto.setName(airPlane.getName());
        dto.setSerialNumber(airPlane.getSerialNumber());
        dto.setCreatedAt(airPlane.getCreatedAt().format(DateTimeFormatter
                .ofPattern(DATE_FORMAT)));
        dto.setFlightDistance(airPlane.getFlightDistance());
        dto.setFuelCapacity(airPlane.getFuelCapacity());
        dto.setNumberOfFlight(airPlane.getNumberOfFlight());
        dto.setTypeOfAirPlane(airPlane.getTypeOfAirPlane());
        return dto;
    }
}
