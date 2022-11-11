package com.musala.dronesservice.infrastructure.repository;

import com.musala.dronesservice.infrastructure.entity.MedicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository<MedicationEntity, Integer> {

}
