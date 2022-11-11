package com.musala.dronesservice.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "drone")
public class Drone {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "serial_no", columnDefinition = "VARCHAR(16) NOT NULL")
    private String serialNumber;

    @Column(name = "model", columnDefinition = "VARCHAR(50) NOT NULL")
    private String model;

    @Column(name = "weight_limit", columnDefinition = "VARCHAR(10) NOT NULL")
    private double weightLimit;

    @Column(name = "battery",precision = 3, scale = 2)
    private BigDecimal battery;

    @Column(name = "drone_state", columnDefinition = "VARCHAR(20) NOT NULL")
    private String state;
}
