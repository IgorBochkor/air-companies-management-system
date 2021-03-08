package com.example.airplanecompanydemo.model;

import java.time.LocalDateTime;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "flight_status")
    private FlightStatus flightStatus;
    @ManyToOne
    private AirCompany airCompany;
    @ManyToOne
    private AirPlane airPlane;
    private String departureCountry;
    private String destinationCountry;
    private int distance;
    private int estimatedFlightTime;
    private LocalDateTime endedAt;
    private LocalDateTime delayStartedAt;
    private LocalDateTime startedAt;

    public enum FlightStatus {
        ACTIVE, COMPLETED, DELAYED, PENDING;
    }
}
