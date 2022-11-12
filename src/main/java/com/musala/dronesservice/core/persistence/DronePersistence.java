package com.musala.dronesservice.core.persistence;

import com.musala.dronesservice.core.domain.droneload.DroneMedicationLoadRequestModel;
import com.musala.dronesservice.core.domain.droneload.DroneMedicationLoadResponseModel;
import com.musala.dronesservice.core.domain.droneregister.DroneModel;
import com.musala.dronesservice.core.domain.droneregister.DroneRegisterResponseModel;

import java.util.List;

public interface DronePersistence {

    /**
     *
     * @param droneModel
     * @return
     */
    DroneRegisterResponseModel register(DroneModel droneModel);

    DroneMedicationLoadResponseModel load(DroneMedicationLoadRequestModel droneMedicationLoadRequestModel, DroneModel droneModel);

    DroneMedicationLoadResponseModel getDroneMedicationLoadEntity(DroneMedicationLoadRequestModel droneMedicationLoadRequestModel);

    DroneMedicationLoadResponseModel checkLoadedMedicationsForDrone(String serialNumber);

    List<DroneModel> getAvailableDroneForLoading();

    DroneModel getDroneBySerialNumber(String serialNumber);

    List<DroneModel> getDrones();
}
