package com.musala.dronesservice.core.service;

import com.musala.dronesservice.core.droneregister.domain.DroneRegisterRequestModel;
import com.musala.dronesservice.core.droneregister.domain.DroneRegisterResponseModel;

public interface DroneService {

    /**
     *
     * @param droneRegisterRequestModel
     * @return
     */
    DroneRegisterResponseModel register(DroneRegisterRequestModel droneRegisterRequestModel);
}
