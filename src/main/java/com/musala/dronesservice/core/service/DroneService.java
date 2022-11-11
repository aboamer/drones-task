package com.musala.dronesservice.core.service;

import com.musala.dronesservice.core.domain.droneload.DroneMedicationLoadRequestModel;
import com.musala.dronesservice.core.domain.droneload.DroneMedicationLoadResponseModel;
import com.musala.dronesservice.core.domain.droneregister.DroneRegisterRequestModel;
import com.musala.dronesservice.core.domain.droneregister.DroneRegisterResponseModel;

public interface DroneService {

    /**
     *
     * @param droneRegisterRequestModel
     * @return
     */
    DroneRegisterResponseModel register(DroneRegisterRequestModel droneRegisterRequestModel);

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
}
