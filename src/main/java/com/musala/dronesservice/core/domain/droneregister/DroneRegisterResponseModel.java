package com.musala.dronesservice.core.domain.droneregister;

import lombok.Data;

@Data
public class DroneRegisterResponseModel {

    private String result;
    private String serialNumber;
    private String message;
}
