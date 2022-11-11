package com.musala.dronesservice.core.service.impl;

import com.musala.dronesservice.core.droneregister.domain.DroneRegisterRequestModel;
import com.musala.dronesservice.core.droneregister.domain.DroneRegisterResponseModel;
import com.musala.dronesservice.core.persistence.DronePersistence;
import com.musala.dronesservice.core.service.DroneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DroneServiceImpl implements DroneService {

    private final DronePersistence dronePersistence;

    @Override
    public DroneRegisterResponseModel register(DroneRegisterRequestModel droneRegisterRequestModel) {

        return dronePersistence.register(droneRegisterRequestModel);
    }
}
