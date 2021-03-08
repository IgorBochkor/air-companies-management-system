package com.example.airplanecompanydemo.controller;

import com.example.airplanecompanydemo.model.Flight;
import com.example.airplanecompanydemo.model.dto.FlightRequestDto;
import com.example.airplanecompanydemo.model.dto.FlightResponseDto;
import com.example.airplanecompanydemo.service.FlightService;
import com.example.airplanecompanydemo.service.mapper.FlightMapper;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping("/flights")
@AllArgsConstructor
public class FlightController {
    private static final String TIME_FORMAT = "dd.MM.yyyy HH:mm";
    private FlightService flightService;
    private FlightMapper flightMapper;

    @GetMapping
    List<FlightResponseDto> getAllByAirCompanyName(@RequestParam String airCompanyName) {
        return flightService.findAllByCompanyName(airCompanyName).stream()
                .map(flightMapper::mapFlightToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/active24")
    List<FlightResponseDto> getAllActive24() {
        return flightService.getAllActiveByDay(LocalDateTime.now().minusHours(24L),
                Flight.FlightStatus.ACTIVE).stream()
                .map(flightMapper::mapFlightToDto).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<Flight> create(@RequestBody @Valid FlightRequestDto flightRequestDto) {
        Flight flight = flightMapper.mapDtoToFlight(flightRequestDto);
        flightService.add(flight);
        return new ResponseEntity<>(flight, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Flight> changeStatus(@PathVariable Long id, @RequestParam String status) {
        Optional<Flight> flightFromDb = flightService.getById(id);
        if (!flightFromDb.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Flight flight = flightFromDb.get();
        if (status.equals(Flight.FlightStatus.ACTIVE.name())) {
            flight.setFlightStatus(Flight.FlightStatus.ACTIVE);
            flight.setStartedAt(LocalDateTime.now());
        } else if (status.equals(Flight.FlightStatus.COMPLETED.name())) {
            flight.setFlightStatus(Flight.FlightStatus.COMPLETED);
            flight.setEndedAt(LocalDateTime.now());
        } else if (status.equals(Flight.FlightStatus.DELAYED.name())) {
            flight.setFlightStatus(Flight.FlightStatus.DELAYED);
            flight.setDelayStartedAt(LocalDateTime.now());
        }
        flightService.add(flight);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    @GetMapping("/completed")
    List<FlightResponseDto> getAllCompletedBiggerThanEstimatedTime() {
        return flightService.findAllByFlightStatus(Flight.FlightStatus.COMPLETED)
                .stream()
                .map(flightMapper::mapFlightToDto)
                .filter(t -> (Duration.between(LocalDateTime
                                .parse(t.getStartedAt(),DateTimeFormatter.ofPattern(TIME_FORMAT)),
                        LocalDateTime.parse(t.getEndedAt(),DateTimeFormatter
                                .ofPattern(TIME_FORMAT)))).toMinutes() > t.getEstimatedFlightTime())
                .collect(Collectors.toList());
    }
}
