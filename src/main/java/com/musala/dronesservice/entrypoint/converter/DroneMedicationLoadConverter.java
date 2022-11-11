package com.musala.dronesservice.entrypoint.converter;

import com.musala.dronesservice.core.domain.droneload.DroneMedicationLoadRequestModel;
import com.musala.dronesservice.core.domain.droneload.DroneMedicationLoadResponseModel;
import com.musala.dronesservice.core.domain.droneload.MedicationModel;
import com.musala.dronesservice.entrypoint.payload.request.DroneMedicationLoadRequest;
import com.musala.dronesservice.entrypoint.payload.request.MedicationRequest;
import com.musala.dronesservice.entrypoint.payload.response.DroneMedicationLoadResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class DroneMedicationLoadConverter {

    public static DroneMedicationLoadRequestModel toModel(final DroneMedicationLoadRequest droneMedicationLoadRequest) {

        return DroneMedicationLoadRequestModel.builder()
                .serialNumber(droneMedicationLoadRequest.getSerialNumber())
                .source(droneMedicationLoadRequest.getSource())
                .destination(droneMedicationLoadRequest.getDestination())
                .medicationModel(toMedicationRequestModel(droneMedicationLoadRequest.getMedicationRequest()))
                .build();
    }

    private static MedicationModel toMedicationRequestModel(MedicationRequest medicationRequest) {

        return MedicationModel.builder()
                .code(medicationRequest.getCode())
                .image(medicationRequest.getImage())
                .name(medicationRequest.getName())
                .weight(medicationRequest.getWeight())
                .build();
    }

    public static DroneMedicationLoadResponse toResponse(final DroneMedicationLoadResponseModel droneMedicationLoadResponseModel) {

        return DroneMedicationLoadResponse.builder()
                .serialNumber(droneMedicationLoadResponseModel.getSerialNumber())
                .message(droneMedicationLoadResponseModel.getMessage())
                .result(droneMedicationLoadResponseModel.getResult())
                .medicationModel(droneMedicationLoadResponseModel.getMedicationModel())
                .build();
    }
}
