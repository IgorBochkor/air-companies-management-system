package com.example.airplanecompanydemo.model.dto;

import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class AirCompanyRequestDto {
    @NotNull
    private String name;
    @NotNull
    private String companyType;
    private String foundedAt;
}
