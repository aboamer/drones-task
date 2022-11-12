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

    DroneMedicationLoadResponseModel load(DroneMedicationLoadRequestModel droneMedicationLoadRequestModel);

    DroneMedicationLoadResponseModel checkLoadedMedicationsForDrone(String serialNumber);

    List<DroneModel> getAvailableDroneForLoading();

    String getBatteryLevel(String serialNumber);

    DroneModel getDroneBySerialNumber(String serialNumber);

    List<DroneModel> getDrones();
}
