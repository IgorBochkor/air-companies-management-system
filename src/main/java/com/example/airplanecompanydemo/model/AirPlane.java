package com.example.airplanecompanydemo.model;

import java.time.LocalDate;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "air_planes")
public class AirPlane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String serialNumber;
    @ManyToOne
    private AirCompany airCompany;
    private int numberOfFlight;
    private int flightDistance;
    private int fuelCapacity;
    private String typeOfAirPlane;
    private LocalDate createdAt;
}
