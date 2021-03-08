package com.example.airplanecompanydemo.service.mapper;

import com.example.airplanecompanydemo.model.AirCompany;
import com.example.airplanecompanydemo.model.AirPlane;
import com.example.airplanecompanydemo.model.dto.AirCompanyRequestDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class AirCompanyMapper {
    private static final String DATE_FORMAT = "dd.MM.yyyy";

    public AirCompany mapDtoToAirCompany(AirCompanyRequestDto dto) {
        AirCompany airCompany = new AirCompany();
        airCompany.setName(dto.getName());
        airCompany.setCompanyType(dto.getCompanyType());
        LocalDate dateTime = LocalDate.parse(dto.getFoundedAt(),
                DateTimeFormatter.ofPattern(DATE_FORMAT));
        airCompany.setFoundedAt(dateTime);
        return airCompany;
    }
}
