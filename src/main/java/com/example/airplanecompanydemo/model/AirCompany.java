package com.example.airplanecompanydemo.model;

import java.time.LocalDate;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "air_companies")
public class AirCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String companyType;
    private LocalDate foundedAt;
}
