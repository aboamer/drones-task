package com.musala.dronesservice.infrastructure.repository;

import com.musala.dronesservice.core.droneregister.domain.DroneRegisterRequestModel;
import com.musala.dronesservice.core.droneregister.domain.DroneRegisterResponseModel;
import com.musala.dronesservice.core.persistence.DronePersistence;
import com.musala.dronesservice.infrastructure.converter.DroneRegisterEntityConverter;
import com.musala.dronesservice.infrastructure.entity.DroneEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class DronePersistenceImpl implements DronePersistence {

    private final DroneRepository droneRepository;

    @Override
    public DroneRegisterResponseModel register(DroneRegisterRequestModel droneRegisterRequestModel) {

        final DroneEntity droneEntity = DroneRegisterEntityConverter.toEntity(droneRegisterRequestModel);

        return DroneRegisterEntityConverter.toResponseModel(droneRepository.save(droneEntity));
    }
}
