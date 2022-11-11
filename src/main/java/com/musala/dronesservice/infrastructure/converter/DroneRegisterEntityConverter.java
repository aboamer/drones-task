package com.musala.dronesservice.infrastructure.converter;

import com.musala.dronesservice.core.droneregister.domain.DroneRegisterRequestModel;
import com.musala.dronesservice.core.droneregister.domain.DroneRegisterResponseModel;
import com.musala.dronesservice.infrastructure.entity.DroneEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class DroneRegisterEntityConverter {

    public static DroneEntity toEntity(final DroneRegisterRequestModel droneRegisterRequestModel) {

        DroneEntity newDrone = new DroneEntity();

        newDrone.setSerialNumber(droneRegisterRequestModel.getSerialNumber());
        newDrone.setModel(droneRegisterRequestModel.getModel());
        newDrone.setWeightLimit(droneRegisterRequestModel.getWeightLimit());
        newDrone.setBattery(droneRegisterRequestModel.getBattery());
        newDrone.setState(droneRegisterRequestModel.getState());

        return newDrone;
    }

    public static DroneRegisterResponseModel toResponseModel(final DroneEntity droneEntity) {

        DroneRegisterResponseModel droneRegisterResponseModel = new DroneRegisterResponseModel();

        droneRegisterResponseModel.setSerialNumber(droneEntity.getSerialNumber());
        droneRegisterResponseModel.setResult("SUCCESS");
        droneRegisterResponseModel.setMessage("New Drone created successfully");

        return droneRegisterResponseModel;
    }
}
