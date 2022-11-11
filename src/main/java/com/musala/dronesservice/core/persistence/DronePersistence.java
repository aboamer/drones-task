package com.musala.dronesservice.core.persistence;

import com.musala.dronesservice.core.droneregister.domain.DroneRegisterRequestModel;
import com.musala.dronesservice.core.droneregister.domain.DroneRegisterResponseModel;

import java.util.Optional;

public interface DronePersistence {

    /**
     *
     * @param droneRegisterRequestModel
     * @return
     */
    DroneRegisterResponseModel register(DroneRegisterRequestModel droneRegisterRequestModel);
}
