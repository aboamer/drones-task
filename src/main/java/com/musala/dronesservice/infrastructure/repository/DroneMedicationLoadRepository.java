package com.musala.dronesservice.infrastructure.repository;

import com.musala.dronesservice.infrastructure.entity.DroneMedicationLoadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface DroneMedicationLoadRepository extends JpaRepository<DroneMedicationLoadEntity, Integer> {

    @Query(value = "SELECT e from DroneMedicationLoadEntity e where e.medicationEntity.code =:code ")
    DroneMedicationLoadEntity findByCode(@Param("code") String code);
}
