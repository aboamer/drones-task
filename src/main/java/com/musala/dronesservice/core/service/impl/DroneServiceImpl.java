package com.musala.dronesservice.core.service.impl;

import com.musala.dronesservice.core.domain.droneload.DroneMedicationLoadRequestModel;
import com.musala.dronesservice.core.domain.droneload.DroneMedicationLoadResponseModel;
import com.musala.dronesservice.core.domain.droneregister.DroneRegisterRequestModel;
import com.musala.dronesservice.core.domain.droneregister.DroneRegisterResponseModel;
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

    @Override
    public DroneMedicationLoadResponseModel load(DroneMedicationLoadRequestModel droneMedicationLoadRequestModel) {

        return dronePersistence.load(droneMedicationLoadRequestModel);
    }
}
