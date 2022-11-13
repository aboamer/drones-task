package com.musala.dronesservice.entrypoint.controller;

import com.musala.dronesservice.core.domain.droneload.DroneMedicationLoadResponseModel;
import com.musala.dronesservice.core.domain.droneregister.DroneModel;
import com.musala.dronesservice.core.domain.droneregister.DroneRegisterResponseModel;
import com.musala.dronesservice.core.service.DroneService;
import com.musala.dronesservice.entrypoint.converter.DroneMedicationLoadConverter;
import com.musala.dronesservice.entrypoint.converter.DroneRegisterConverter;
import com.musala.dronesservice.entrypoint.payload.request.DroneMedicationLoadRequest;
import com.musala.dronesservice.entrypoint.payload.request.DroneRegisterRequest;
import com.musala.dronesservice.entrypoint.payload.response.DroneMedicationLoadResponse;
import com.musala.dronesservice.entrypoint.payload.response.DroneRegisterResponse;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(path = "/api/drone")
@RequiredArgsConstructor
@Validated
public class DroneController {

    private final DroneService droneService;

    @ApiOperation(value = "register drone inside database")
    @PostMapping(path = "/register", consumes = "application/json", produces = "application/json")
    public ResponseEntity<DroneRegisterResponse> registerDrone(
            @Valid @NotNull @RequestBody DroneRegisterRequest droneRequest
    ) {

        DroneRegisterResponseModel newDroneModel = droneService.register(DroneRegisterConverter.toModel(droneRequest));

        return new ResponseEntity<>(DroneRegisterConverter.toResponse(newDroneModel), HttpStatus.CREATED);
    }

    @ApiOperation(value = "load drone with a given medication")
    @PostMapping(path = "/load", consumes = "application/json", produces = "application/json")
    public ResponseEntity<DroneMedicationLoadResponse> loadDrone(
            @Valid @NotNull @RequestBody DroneMedicationLoadRequest droneMedicationLoadRequest
    ) {

        final DroneMedicationLoadResponseModel droneMedicationLoadResponseModel = droneService.load(DroneMedicationLoadConverter.toModel(droneMedicationLoadRequest));

        return new ResponseEntity<>(DroneMedicationLoadConverter.toResponse(droneMedicationLoadResponseModel), HttpStatus.CREATED);
    }

    @ApiOperation(value = "getting medication load for a given drone serial number")
    @GetMapping(path = "{serialNumber}/details", produces = "application/json")
    public ResponseEntity<DroneMedicationLoadResponse> checkLoadedMedicationItem(@PathVariable("serialNumber") String serialNumber) {

        final DroneMedicationLoadResponseModel droneMedicationLoadResponseModel = droneService.checkLoadedMedicationsForDrone(serialNumber);

        return new ResponseEntity<>(DroneMedicationLoadConverter.toResponse(droneMedicationLoadResponseModel), HttpStatus.OK);
    }

    @ApiOperation(value = "getting available drone for loading")
    @GetMapping(path= "/available", produces = "application/json")
    public ResponseEntity<List<DroneModel>> getAvailableDroneForLoading() {

        return new ResponseEntity<>(droneService.getAvailableDroneForLoading(), HttpStatus.OK);
    }

    @ApiOperation(value = "getting battery level for a given drone serial number")
    @GetMapping(path ="{serialNumber}/battery", produces = "application/json")
    public ResponseEntity<String> checkDroneBatteryLevel(@PathVariable("serialNumber") String serialNumber) {

        return new ResponseEntity<>(droneService.getBatteryLevel(serialNumber), HttpStatus.OK);
    }
}
