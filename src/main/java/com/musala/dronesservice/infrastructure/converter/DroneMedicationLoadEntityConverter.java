package com.musala.dronesservice.infrastructure.converter;

import com.musala.dronesservice.core.domain.droneload.DroneMedicationLoadRequestModel;
import com.musala.dronesservice.core.domain.droneload.DroneMedicationLoadResponseModel;
import com.musala.dronesservice.infrastructure.entity.DroneMedicationLoadEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DroneMedicationLoadEntityConverter {

    public static DroneMedicationLoadEntity toEntity(final DroneMedicationLoadRequestModel droneMedicationLoadRequestModel) {

        DroneMedicationLoadEntity droneMedicationLoadEntity = new DroneMedicationLoadEntity();

        droneMedicationLoadEntity.setSource(droneMedicationLoadRequestModel.getSource());
        droneMedicationLoadEntity.setDestination(droneMedicationLoadRequestModel.getDestination());

        return droneMedicationLoadEntity;
    }

    public static DroneMedicationLoadResponseModel toResponseModel(final DroneMedicationLoadEntity droneMedicationLoadEntity) {

        DroneMedicationLoadResponseModel droneMedicationLoadResponseModel = new DroneMedicationLoadResponseModel();

        droneMedicationLoadResponseModel.setSerialNumber(droneMedicationLoadEntity.getDroneEntity().getSerialNumber());
        droneMedicationLoadResponseModel.setResult("SUCCESS");
        droneMedicationLoadResponseModel.setMessage("Drone loaded successfully");

        return droneMedicationLoadResponseModel;
    }
}
