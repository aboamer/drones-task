package com.musala.dronesservice.infrastructure.repository;

import com.musala.dronesservice.core.domain.droneload.DroneMedicationLoadRequestModel;
import com.musala.dronesservice.core.domain.droneload.DroneMedicationLoadResponseModel;
import com.musala.dronesservice.core.domain.droneregister.DroneModel;
import com.musala.dronesservice.core.domain.droneregister.DroneRegisterResponseModel;
import com.musala.dronesservice.core.persistence.DronePersistence;
import com.musala.dronesservice.infrastructure.converter.DroneEntityConverter;
import com.musala.dronesservice.infrastructure.converter.DroneMedicationLoadEntityConverter;
import com.musala.dronesservice.infrastructure.converter.MedicationEntityConverter;
import com.musala.dronesservice.infrastructure.entity.DroneEntity;
import com.musala.dronesservice.infrastructure.entity.DroneMedicationLoadEntity;
import com.musala.dronesservice.infrastructure.entity.MedicationEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Component
@RequiredArgsConstructor
public class DronePersistenceImpl implements DronePersistence {

    private final DroneRepository droneRepository;
    private final MedicationRepository medicationRepository;
    private final DroneMedicationLoadRepository droneMedicationLoadRepository;

    @Override
    public DroneRegisterResponseModel register(DroneModel droneModel) {

        final DroneEntity droneEntity = DroneEntityConverter.toEntity(droneModel);

        return DroneEntityConverter.toDroneRegisterResponseModel(droneRepository.save(droneEntity));
    }

    @Override
    public DroneMedicationLoadResponseModel load(DroneMedicationLoadRequestModel droneMedicationLoadRequestModel, DroneModel droneModel) {

        final DroneMedicationLoadEntity droneMedicationLoadEntity = DroneMedicationLoadEntityConverter.toEntity(droneMedicationLoadRequestModel);

        final MedicationEntity medicationEntity = medicationRepository.save(MedicationEntityConverter.toEntity(droneMedicationLoadRequestModel.getMedicationModel()));

        droneRepository.updateDroneStatus("LOADING", droneMedicationLoadRequestModel.getSerialNumber());

        droneMedicationLoadEntity.setMedicationEntity(medicationEntity);

        droneMedicationLoadEntity.setDroneEntity(droneRepository.findBySerialNumber(droneModel.getSerialNumber()));

        return DroneMedicationLoadEntityConverter.toResponseModel(droneMedicationLoadRepository.save(droneMedicationLoadEntity));
    }

    public DroneMedicationLoadResponseModel getDroneMedicationLoadEntity(DroneMedicationLoadRequestModel droneMedicationLoadRequestModel) {

        return DroneMedicationLoadEntityConverter.toResponseModel(
                droneMedicationLoadRepository.findByCode(droneMedicationLoadRequestModel.getMedicationModel().getCode())
        );
    }

    @Override
    public DroneMedicationLoadResponseModel checkLoadedMedicationsForDrone(String serialNumber) {

        return DroneMedicationLoadEntityConverter.toResponseModel(droneMedicationLoadRepository.findByDrone(serialNumber));
    }

    @Override
    public List<DroneModel> getAvailableDroneForLoading() {

        return droneRepository.findAllByState("IDLE").stream().map(DroneEntityConverter::toDroneResponseModel).collect(Collectors.toList());
    }

    @Override
    public DroneModel getDroneBySerialNumber(String serialNumber) {

        return DroneEntityConverter.toDroneResponseModel(droneRepository.findBySerialNumber(serialNumber));
    }

    @Override
    public List<DroneModel> getDrones() {

        return droneRepository.findAll().stream().map(DroneEntityConverter::toDroneResponseModel).collect(Collectors.toList());
    }
}
