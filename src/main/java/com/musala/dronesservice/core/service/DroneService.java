package com.musala.dronesservice.core.service;

import com.musala.dronesservice.core.domain.droneload.DroneMedicationLoadRequestModel;
import com.musala.dronesservice.core.domain.droneload.DroneMedicationLoadResponseModel;
import com.musala.dronesservice.core.domain.droneregister.DroneModel;
import com.musala.dronesservice.core.domain.droneregister.DroneRegisterResponseModel;

import java.util.List;

public interface DroneService {

    /**
     *
     * @param droneModel
     * @return
     */
    DroneRegisterResponseModel register(DroneModel droneModel);

    /**
     *
     * @param droneMedicationLoadRequestModel
     * @return
     */
    DroneMedicationLoadResponseModel load(DroneMedicationLoadRequestModel droneMedicationLoadRequestModel);

    /**
     *
     * @param serialNumber
     * @return
     */
    DroneMedicationLoadResponseModel checkLoadedMedicationsForDrone(String serialNumber);

    List<DroneModel> getAvailableDroneForLoading();

    String getBatteryLevel(String serialNumber);
}
