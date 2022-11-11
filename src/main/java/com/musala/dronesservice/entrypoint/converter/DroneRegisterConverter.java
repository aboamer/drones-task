package com.musala.dronesservice.entrypoint.converter;

import com.musala.dronesservice.core.domain.droneregister.DroneRegisterRequestModel;
import com.musala.dronesservice.core.domain.droneregister.DroneRegisterResponseModel;
import com.musala.dronesservice.entrypoint.payload.request.DroneRegisterRequest;
import com.musala.dronesservice.entrypoint.payload.response.DroneRegisterResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class DroneRegisterConverter {

    public static DroneRegisterRequestModel toModel(final DroneRegisterRequest droneRegisterRequest) {

        return DroneRegisterRequestModel.builder()
                .serialNumber(droneRegisterRequest.getSerialNumber())
                .weightLimit(droneRegisterRequest.getWeightLimit())
                .model(droneRegisterRequest.getModel())
                .state(droneRegisterRequest.getState())
                .battery(droneRegisterRequest.getBattery())
                .build();
    }

    public static DroneRegisterResponse toResponse(final DroneRegisterResponseModel droneRegisterResponseModel) {

        return DroneRegisterResponse.builder()
                .serialNumber(droneRegisterResponseModel.getSerialNumber())
                .message(droneRegisterResponseModel.getMessage())
                .result(droneRegisterResponseModel.getResult())
                .build();
    }
}
