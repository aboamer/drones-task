package com.musala.dronesservice.core.service.impl;

import com.musala.dronesservice.core.domain.droneload.DroneMedicationLoadRequestModel;
import com.musala.dronesservice.core.domain.droneload.DroneMedicationLoadResponseModel;
import com.musala.dronesservice.core.domain.droneregister.DroneModel;
import com.musala.dronesservice.core.domain.droneregister.DroneRegisterResponseModel;
import com.musala.dronesservice.core.persistence.DronePersistence;
import com.musala.dronesservice.core.service.DroneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DroneServiceImpl implements DroneService {

    private final DronePersistence dronePersistence;

    @Override
    public DroneRegisterResponseModel register(DroneModel droneModel) {

        return dronePersistence.register(droneModel);
    }

    @Override
    public DroneMedicationLoadResponseModel load(DroneMedicationLoadRequestModel droneMedicationLoadRequestModel) {

        return dronePersistence.load(droneMedicationLoadRequestModel);
    }

    @Override
    public DroneMedicationLoadResponseModel checkLoadedMedicationsForDrone(String serialNumber) {

        return dronePersistence.checkLoadedMedicationsForDrone(serialNumber);
    }

    @Override
    public List<DroneModel> getAvailableDroneForLoading() {

        return dronePersistence.getAvailableDroneForLoading();
    }

    @Override
    public String getBatteryLevel(String serialNumber) {

        return dronePersistence.getBatteryLevel(serialNumber);
    }
}
