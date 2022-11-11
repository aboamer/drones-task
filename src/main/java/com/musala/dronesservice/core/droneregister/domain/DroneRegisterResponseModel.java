package com.musala.dronesservice.core.droneregister.domain;

import lombok.Data;

@Data
public class DroneRegisterResponseModel {

    private String result;
    private String serialNumber;
    private String message;
}
