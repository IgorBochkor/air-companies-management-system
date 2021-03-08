package com.example.airplanecompanydemo.controller;

import com.example.airplanecompanydemo.model.AirCompany;
import com.example.airplanecompanydemo.model.AirPlane;
import com.example.airplanecompanydemo.model.Flight;
import com.example.airplanecompanydemo.service.AirCompanyService;
import com.example.airplanecompanydemo.service.AirPlaneService;
import com.example.airplanecompanydemo.service.FlightService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
@AllArgsConstructor
public class InjectData {
    private AirCompanyService airCompanyService;
    private AirPlaneService airPlaneService;
    private FlightService flightService;

    @PostConstruct
    public void addData() {
        AirCompany airCompany = new AirCompany();
        airCompany.setName("United_AirLines");
        airCompany.setCompanyType("AirCompany");
        airCompany.setFoundedAt(LocalDate.of(1926,4,26));
        airCompanyService.add(airCompany);
        AirCompany airCompany2 = new AirCompany();
        airCompany2.setName("Turkish_AirLines");
        airCompany2.setCompanyType("AirCompany&Business");
        airCompany2.setFoundedAt(LocalDate.of(1933,5,20));
        airCompanyService.add(airCompany2);

        AirPlane airPlane = new AirPlane();
        airPlane.setAirCompany(airCompany);
        airPlane.setName("Boeing 737");
        airPlane.setSerialNumber("SERIAL135");
        airPlane.setNumberOfFlight(315);
        airPlane.setFlightDistance(3400);
        airPlane.setFuelCapacity(10707);
        airPlane.setTypeOfAirPlane("Passenger");
        airPlane.setCreatedAt(LocalDate.of(1990,10,10));
        airPlaneService.add(airPlane);

        Flight flight = new Flight();
        flight.setAirCompany(airCompany);
        flight.setAirPlane(airPlane);
        flight.setDistance(3500);
        flight.setDepartureCountry("Toronto");
        flight.setDestinationCountry("Berlin");
        flight.setFlightStatus(Flight.FlightStatus.PENDING);
        flight.setEstimatedFlightTime(100);
        flight.setDelayStartedAt(LocalDateTime.of(10,10,10,10,0));
        flight.setEndedAt(LocalDateTime.of(2021,3,6,12,12));
        flight.setStartedAt(LocalDateTime.of(2021,3,5,14,10));
        flightService.add(flight);
    }
}
