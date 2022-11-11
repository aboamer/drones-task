package com.musala.dronesservice.infrastructure.converter;

import com.musala.dronesservice.core.domain.droneload.MedicationRequestModel;
import com.musala.dronesservice.infrastructure.entity.MedicationEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MedicationEntityConverter {

    public static MedicationEntity toEntity(MedicationRequestModel medicationRequestModel) {

        final MedicationEntity medicationEntity = new MedicationEntity();

        medicationEntity.setCode(medicationRequestModel.getCode());
        medicationEntity.setImage(medicationRequestModel.getImage());
        medicationEntity.setName(medicationRequestModel.getName());
        medicationEntity.setWeight(medicationRequestModel.getWeight());

        return medicationEntity;
    }
}
