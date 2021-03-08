package com.example.airplanecompanydemo.repository;

import com.example.airplanecompanydemo.model.Flight;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    @Query(value = "from Flight f where f.airCompany.name = :name")
    List<Flight> findAllByCompanyName(@Param("name") String name);

    @Query(value = "from Flight f where f.startedAt > :beforeDay and f.flightStatus = :status")
    List<Flight> findAllByStatusAndBeforeDay(@Param("beforeDay") LocalDateTime beforeDay,
                                             @Param("status") Flight.FlightStatus status);

    @Query(value = "from Flight f where f.flightStatus =:status")
    List<Flight> findAllByFlightStatus(@Param("status") Flight.FlightStatus status);
}
