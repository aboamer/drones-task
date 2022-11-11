package com.musala.dronesservice.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "drone_medication_load")
public class DroneMedicationLoadEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "source", columnDefinition = "VARCHAR(30) NOT NULL")
    private String source;

    @Column(name = "destination", columnDefinition = "VARCHAR(30) NOT NULL")
    private String destination;

    @Column(name = "created_on", columnDefinition = "VARCHAR(30) NOT NULL")
    private LocalDateTime createdOn;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_serial_no", referencedColumnName = "serial_no")
    private DroneEntity droneEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_code", referencedColumnName = "code", unique = true)
    private MedicationEntity medicationEntity;
}
