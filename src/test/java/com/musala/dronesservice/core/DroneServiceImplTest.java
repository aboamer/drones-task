package com.musala.dronesservice.core;

import com.musala.dronesservice.core.domain.droneload.DroneMedicationLoadRequestModel;
import com.musala.dronesservice.core.domain.droneload.DroneMedicationLoadResponseModel;
import com.musala.dronesservice.core.domain.droneload.MedicationModel;
import com.musala.dronesservice.core.domain.droneregister.DroneModel;
import com.musala.dronesservice.core.domain.droneregister.DroneRegisterResponseModel;
import com.musala.dronesservice.core.exceptions.DomainExistException;
import com.musala.dronesservice.core.exceptions.DomainNotExistException;
import com.musala.dronesservice.core.exceptions.DroneValidationException;
import com.musala.dronesservice.core.persistence.DronePersistence;
import com.musala.dronesservice.core.service.impl.DroneServiceImpl;
import com.musala.dronesservice.core.utils.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class DroneServiceImplTest {

    @Mock
    DronePersistence dronePersistence;

    DroneServiceImpl droneService;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);

        droneService = new DroneServiceImpl(dronePersistence);
    }

    @Test
    void register_whenDroneExist_throwDomainExistException() {

        when(dronePersistence.getDroneBySerialNumber(any())).thenReturn(DroneModel.builder().build());

        assertThrows(DomainExistException.class, () -> droneService.register(DroneModel.builder().build()));
    }

    @Test
    void register_withValidData_returnValidResponse() {

        DroneModel droneModel = DroneModel.builder().model("model").state("state").serialNumber("serial").battery(new BigDecimal("0.28")).build();

        DroneRegisterResponseModel droneRegisterResponseModel = new DroneRegisterResponseModel();
        droneRegisterResponseModel.setSerialNumber(droneModel.getSerialNumber());
        droneRegisterResponseModel.setResult(Constants.SUCCESS);
        droneRegisterResponseModel.setMessage(Constants.NEW_DRONE_CREATED_SUCCESSFULLY);

        when(dronePersistence.getDroneBySerialNumber(any())).thenReturn(null);

        when(dronePersistence.register(any())).thenReturn(droneRegisterResponseModel);

        DroneRegisterResponseModel createdDroneModel = droneService.register(droneModel);

        assertAll(
                () -> assertNotNull(createdDroneModel),
                () -> assertThat(createdDroneModel.getSerialNumber()).isEqualTo(droneModel.getSerialNumber()),
                () -> assertThat(createdDroneModel.getMessage()).isEqualTo(droneRegisterResponseModel.getMessage()),
                () -> assertThat(createdDroneModel.getResult()).isEqualTo(droneRegisterResponseModel.getResult())
        );
    }

    @Test
    void load_whenDroneMedicationLoadExists_throwDroneValidationException() {

        when(dronePersistence.getDroneMedicationLoadEntity(any())).thenReturn(DroneMedicationLoadResponseModel.builder().medicationModel(
                MedicationModel.builder().build()
        ).build());

        assertThrows(DroneValidationException.class, () -> droneService.load(DroneMedicationLoadRequestModel.builder().build()));
    }

    @Test
    void load_whenDroneNotExist_throwDroneValidationException() {

        when(dronePersistence.getDroneMedicationLoadEntity(any())).thenReturn(DroneMedicationLoadResponseModel.builder().medicationModel(null).build());

        when(dronePersistence.getDroneBySerialNumber(any())).thenReturn(null);

        assertThrows(DomainNotExistException.class, () -> droneService.load(DroneMedicationLoadRequestModel.builder().build()));
    }

    @Test
    void load_whenDroneWeightLimitLessThanMedicationWeight_throwDroneValidationException() {

        DroneMedicationLoadRequestModel droneMedicationLoadRequestModel = DroneMedicationLoadRequestModel.builder()
                .serialNumber("x")
                .medicationModel(MedicationModel.builder().weight(50d).build())
                .build();

        when(dronePersistence.getDroneMedicationLoadEntity(any())).thenReturn(DroneMedicationLoadResponseModel.builder().medicationModel(null).build());

        when(dronePersistence.getDroneBySerialNumber(anyString())).thenReturn(DroneModel.builder().weightLimit(10d).build());

        assertThrows(DroneValidationException.class, () -> droneService.load(droneMedicationLoadRequestModel));
    }

    @Test
    void load_whenDroneBatteryLevelLessThan25_throwDroneValidationException() {

        DroneMedicationLoadRequestModel droneMedicationLoadRequestModel = DroneMedicationLoadRequestModel.builder()
                .serialNumber("x")
                .medicationModel(MedicationModel.builder().weight(50d).build())
                .build();

        when(dronePersistence.getDroneMedicationLoadEntity(any())).thenReturn(DroneMedicationLoadResponseModel.builder().medicationModel(null).build());

        when(dronePersistence.getDroneBySerialNumber(anyString())).thenReturn(DroneModel.builder().weightLimit(1000d).battery(new BigDecimal("0.20")).build());

        assertThrows(DroneValidationException.class, () -> droneService.load(droneMedicationLoadRequestModel));
    }

    @Test
    void load_whenDataIsValid_medicationLoadedSuccess() {

        DroneMedicationLoadRequestModel droneMedicationLoadRequestModel = DroneMedicationLoadRequestModel.builder()
                .serialNumber("x")
                .medicationModel(MedicationModel.builder().weight(50d).build())
                .build();

        DroneMedicationLoadResponseModel droneMedicationLoadResponseModel = DroneMedicationLoadResponseModel.builder()
                .serialNumber(droneMedicationLoadRequestModel.getSerialNumber())
                .build();

        when(dronePersistence.getDroneMedicationLoadEntity(any())).thenReturn(DroneMedicationLoadResponseModel.builder().medicationModel(null).build());

        DroneModel droneModel = getDroneModel();

        when(dronePersistence.getDroneBySerialNumber(anyString())).thenReturn(droneModel);

        when(dronePersistence.load(droneMedicationLoadRequestModel, droneModel)).thenReturn(droneMedicationLoadResponseModel);

        droneService.load(droneMedicationLoadRequestModel);

        verify(dronePersistence, times(1)).load(droneMedicationLoadRequestModel, droneModel);
    }

    @Test
    void getBatteryLevel_whenDroneModelIsNotFound_returnNoDroneFound() {

        when(dronePersistence.getDroneBySerialNumber(anyString())).thenReturn(null);

        String result = droneService.getBatteryLevel("x");

        assertEquals(Constants.NO_DRONE_FOUND, result);
    }

    @Test
    void getBatteryLevel_whenDroneModelExist_returnBatteryLevel() {

        when(dronePersistence.getDroneBySerialNumber(anyString())).thenReturn(getDroneModel());

        DecimalFormat decFormat = new DecimalFormat("#%");

        String result = droneService.getBatteryLevel("x");

        assertEquals(result, decFormat.format(getDroneModel().getBattery()));
    }

    private DroneModel getDroneModel() {

        return DroneModel.builder().weightLimit(1000d).battery(new BigDecimal("0.26")).build();
    }
}
