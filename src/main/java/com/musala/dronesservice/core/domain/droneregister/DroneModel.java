package com.musala.dronesservice.core.domain.droneregister;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public final class DroneModel {

    private String serialNumber;
    private String model;
    private double weightLimit;
    private BigDecimal battery;
    private String state;
}
