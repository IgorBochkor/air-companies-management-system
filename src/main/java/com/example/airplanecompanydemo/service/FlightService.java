package com.example.airplanecompanydemo.service;

import com.example.airplanecompanydemo.model.Flight;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FlightService {
    Flight add(Flight flight);

    List<Flight> getAllActiveByDay(LocalDateTime time, Flight.FlightStatus flightStatus);

    List<Flight> findAllByCompanyName(String name);

    Optional<Flight> getById(Long id);

    List<Flight> findAllByFlightStatus(Flight.FlightStatus flightStatus);
}
