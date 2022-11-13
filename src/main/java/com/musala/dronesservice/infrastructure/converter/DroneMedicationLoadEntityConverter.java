package com.musala.dronesservice.infrastructure.converter;

import com.musala.dronesservice.core.domain.droneload.DroneMedicationLoadRequestModel;
import com.musala.dronesservice.core.domain.droneload.DroneMedicationLoadResponseModel;
import com.musala.dronesservice.core.domain.droneload.MedicationModel;
import com.musala.dronesservice.core.utils.Constants;
import com.musala.dronesservice.infrastructure.entity.DroneMedicationLoadEntity;
import com.musala.dronesservice.infrastructure.entity.MedicationEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.Objects;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DroneMedicationLoadEntityConverter {

    public static DroneMedicationLoadEntity toEntity(final DroneMedicationLoadRequestModel droneMedicationLoadRequestModel) {

        DroneMedicationLoadEntity droneMedicationLoadEntity = new DroneMedicationLoadEntity();

        droneMedicationLoadEntity.setSource(droneMedicationLoadRequestModel.getSource());
        droneMedicationLoadEntity.setDestination(droneMedicationLoadRequestModel.getDestination());

        return droneMedicationLoadEntity;
    }

    public static DroneMedicationLoadResponseModel toResponseModel(final DroneMedicationLoadEntity droneMedicationLoadEntity) {

        if (Objects.isNull(droneMedicationLoadEntity)) {

            return DroneMedicationLoadResponseModel.builder().result(Constants.NONE).message(Constants.NO_MEDICATION_LOADED).build();
        }

        return DroneMedicationLoadResponseModel.builder()
                .medicationModel(toMedicationModel(droneMedicationLoadEntity.getMedicationEntity()))
                .serialNumber(droneMedicationLoadEntity.getDroneEntity().getSerialNumber())
                .result(Constants.SUCCESS)
                .message(Constants.DRONE_LOADED_SUCCESS)
                .build();
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
