package com.musala.dronesservice.infrastructure.converter;

import com.musala.dronesservice.core.domain.droneregister.DroneModel;
import com.musala.dronesservice.core.domain.droneregister.DroneRegisterResponseModel;
import com.musala.dronesservice.core.utils.Constants;
import com.musala.dronesservice.infrastructure.entity.DroneEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.Objects;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class DroneEntityConverter {

    public static DroneEntity toEntity(final DroneModel droneModel) {

        DroneEntity newDrone = new DroneEntity();

        newDrone.setSerialNumber(droneModel.getSerialNumber());
        newDrone.setModel(droneModel.getModel());
        newDrone.setWeightLimit(droneModel.getWeightLimit());
        newDrone.setBattery(droneModel.getBattery());
        newDrone.setState(droneModel.getState());

        return newDrone;
    }

    public static DroneRegisterResponseModel toDroneRegisterResponseModel(final DroneEntity droneEntity) {

        DroneRegisterResponseModel droneRegisterResponseModel = new DroneRegisterResponseModel();

        droneRegisterResponseModel.setSerialNumber(droneEntity.getSerialNumber());
        droneRegisterResponseModel.setResult(Constants.SUCCESS);
        droneRegisterResponseModel.setMessage(Constants.NEW_DRONE_CREATED_SUCCESSFULLY);

        return droneRegisterResponseModel;
    }

    public static DroneModel toDroneResponseModel(final DroneEntity droneEntity) {

        return Objects.isNull(droneEntity) ? null : getDroneModel(droneEntity);
    }

    private static DroneModel getDroneModel(DroneEntity droneEntity) {

        return DroneModel.builder()
                .model(droneEntity.getModel())
                .battery(droneEntity.getBattery())
                .serialNumber(droneEntity.getSerialNumber())
                .weightLimit(droneEntity.getWeightLimit())
                .state(droneEntity.getState())
                .build();
    }
}
