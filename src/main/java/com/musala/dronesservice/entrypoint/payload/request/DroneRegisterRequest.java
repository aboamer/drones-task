package com.musala.dronesservice.entrypoint.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DroneRegisterRequest {

    @NotBlank
    @NotNull
    private String serialNumber;

    @NotBlank
    @NotNull
    private String model;

    @NotNull
    private double weightLimit;

    @NotNull
    private BigDecimal battery;

    @NotBlank
    @NotNull
    private String state;
}
