package com.musala.dronesservice.core.persistence;

import com.musala.dronesservice.core.domain.droneload.DroneMedicationLoadRequestModel;
import com.musala.dronesservice.core.domain.droneload.DroneMedicationLoadResponseModel;
import com.musala.dronesservice.core.domain.droneregister.DroneRegisterRequestModel;
import com.musala.dronesservice.core.domain.droneregister.DroneRegisterResponseModel;

public interface DronePersistence {

    /**
     *
     * @param droneRegisterRequestModel
     * @return
     */
    DroneRegisterResponseModel register(DroneRegisterRequestModel droneRegisterRequestModel);

    DroneMedicationLoadResponseModel load(DroneMedicationLoadRequestModel droneMedicationLoadRequestModel);

    DroneMedicationLoadResponseModel checkLoadedMedicationsForDrone(String serialNumber);
}
