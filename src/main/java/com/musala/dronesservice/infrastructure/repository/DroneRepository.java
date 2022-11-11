package com.musala.dronesservice.infrastructure.repository;

import com.musala.dronesservice.infrastructure.entity.DroneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface DroneRepository extends JpaRepository<DroneEntity, String> {

}