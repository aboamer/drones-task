package com.musala.dronesservice.infrastructure.converter;

import com.musala.dronesservice.core.domain.droneload.MedicationModel;
import com.musala.dronesservice.infrastructure.entity.MedicationEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MedicationEntityConverter {

    public static MedicationEntity toEntity(MedicationModel medicationModel) {

        final MedicationEntity medicationEntity = new MedicationEntity();

        medicationEntity.setCode(medicationModel.getCode());
        medicationEntity.setImage(medicationModel.getImage());
        medicationEntity.setName(medicationModel.getName());
        medicationEntity.setWeight(medicationModel.getWeight());

        return medicationEntity;
    }
}
