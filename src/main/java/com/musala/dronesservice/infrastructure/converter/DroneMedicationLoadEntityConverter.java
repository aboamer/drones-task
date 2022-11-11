package com.musala.dronesservice.infrastructure.converter;

import com.musala.dronesservice.core.domain.droneload.DroneMedicationLoadRequestModel;
import com.musala.dronesservice.core.domain.droneload.DroneMedicationLoadResponseModel;
import com.musala.dronesservice.core.domain.droneload.MedicationModel;
import com.musala.dronesservice.infrastructure.entity.DroneMedicationLoadEntity;
import com.musala.dronesservice.infrastructure.entity.MedicationEntity;
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
        droneMedicationLoadResponseModel.setMedicationModel(toMedicationModel(droneMedicationLoadEntity.getMedicationEntity()));

        return droneMedicationLoadResponseModel;
    }

    private static MedicationModel toMedicationModel(MedicationEntity medicationEntity) {

        return MedicationModel.builder()
                .code(medicationEntity.getCode())
                .name(medicationEntity.getName())
                .weight(medicationEntity.getWeight())
                .image(medicationEntity.getImage())
                .build();
    }
}
