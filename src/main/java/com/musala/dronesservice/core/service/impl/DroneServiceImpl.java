package com.musala.dronesservice.core.service.impl;

import com.musala.dronesservice.core.domain.droneload.DroneMedicationLoadRequestModel;
import com.musala.dronesservice.core.domain.droneload.DroneMedicationLoadResponseModel;
import com.musala.dronesservice.core.domain.droneregister.DroneModel;
import com.musala.dronesservice.core.domain.droneregister.DroneRegisterResponseModel;
import com.musala.dronesservice.core.exceptions.DomainExistException;
import com.musala.dronesservice.core.exceptions.DomainNotExistException;
import com.musala.dronesservice.core.exceptions.DroneValidationException;
import com.musala.dronesservice.core.persistence.DronePersistence;
import com.musala.dronesservice.core.service.DroneService;
import com.musala.dronesservice.core.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class DroneServiceImpl implements DroneService {

    private final DronePersistence dronePersistence;

    @Override
    public DroneRegisterResponseModel register(DroneModel droneModel) {

        if (Objects.nonNull(dronePersistence.getDroneBySerialNumber(droneModel.getSerialNumber())))
            throw new DomainExistException(String.format("Drone already exists with serial number %s", droneModel.getSerialNumber()));

        return dronePersistence.register(droneModel);
    }

    @Override
    public DroneMedicationLoadResponseModel load(DroneMedicationLoadRequestModel droneMedicationLoadRequestModel) {

        DroneMedicationLoadResponseModel existingDroneMedicationLoad = dronePersistence.getDroneMedicationLoadEntity(droneMedicationLoadRequestModel);

        if (Objects.nonNull(existingDroneMedicationLoad.getMedicationModel())) {

            throw new DroneValidationException("Medication code has already been loaded, try another one");
        }

        final DroneModel droneModel = dronePersistence.getDroneBySerialNumber(droneMedicationLoadRequestModel.getSerialNumber());

        if (droneModel == null) {

            throw new DomainNotExistException("Drone specified does not exist");
        }

        if (droneModel.getWeightLimit() < droneMedicationLoadRequestModel.getMedicationModel().getWeight()) {

            throw new DroneValidationException("The Drone cannot load more than the weight limit");
        }

        if (droneModel.getBattery().compareTo(new BigDecimal("0.25")) < 0) {

            throw new DroneValidationException("The Drone cannot be loaded as battery is below 25%");
        }

        return dronePersistence.load(droneMedicationLoadRequestModel, droneModel);
    }

    @Override
    public DroneMedicationLoadResponseModel checkLoadedMedicationsForDrone(String serialNumber) {

        return dronePersistence.checkLoadedMedicationsForDrone(serialNumber);
    }

    @Override
    public List<DroneModel> getAvailableDroneForLoading() {

        return dronePersistence.getAvailableDroneForLoading();
    }

    @Override
    public String getBatteryLevel(String serialNumber) {

        DroneModel droneModel = dronePersistence.getDroneBySerialNumber(serialNumber);

        DecimalFormat decFormat = new DecimalFormat("#%");

        return Objects.isNull(droneModel) ? Constants.NO_DRONE_FOUND : decFormat.format(droneModel.getBattery());
    }
}
