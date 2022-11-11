package com.musala.dronesservice.infrastructure.repository;

import com.musala.dronesservice.infrastructure.entity.DroneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface DroneRepository extends JpaRepository<DroneEntity, Integer> {

    @Query(value = "SELECT e from DroneEntity e where e.serialNumber =:serialNumber ") // using @query with native
    DroneEntity findBySerialNumber(@Param("serialNumber") String serialNumber);

    @Modifying
    @Query(value = "update DroneEntity d set d.state = :state where  d.serialNumber= :serialno") //using query
    void updateDroneStatus (@Param("state") String status, @Param("serialno") String serialno);
}