package com.example.airplanecompanydemo.service.impl;

import com.example.airplanecompanydemo.model.Flight;
import com.example.airplanecompanydemo.repository.FlightRepository;
import com.example.airplanecompanydemo.service.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FlightServiceImpl implements FlightService {
    private FlightRepository flightRepository;

    @Override
    public Flight add(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public List<Flight> getAllActiveByDay(LocalDateTime time, Flight.FlightStatus flightStatus) {
        return flightRepository.findAllByStatusAndBeforeDay(time,flightStatus);
    }

    @Override
    public List<Flight> findAllByCompanyName(String name) {
        return flightRepository.findAllByCompanyName(name);
    }

    @Override
    public Optional<Flight> getById(Long id) {
        return flightRepository.findById(id);
    }

    @Override
    public List<Flight> findAllByFlightStatus(Flight.FlightStatus flightStatus) {
        return flightRepository.findAllByFlightStatus(flightStatus);
    }
}
