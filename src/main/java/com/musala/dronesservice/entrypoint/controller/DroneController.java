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

    @PostMapping(path = "/register", consumes = "application/json", produces = "application/json")
    public ResponseEntity<DroneRegisterResponse> registerDrone(
            @Valid @NotNull @RequestBody DroneRegisterRequest droneRequest
    ) {

        DroneRegisterResponseModel newDroneModel = droneService.register(DroneRegisterConverter.toModel(droneRequest));

        return new ResponseEntity<>(DroneRegisterConverter.toResponse(newDroneModel), HttpStatus.CREATED);
    }

    @PostMapping(path = "/load", consumes = "application/json", produces = "application/json")
    public ResponseEntity<DroneMedicationLoadResponse> loadDrone(
            @Valid @NotNull @RequestBody DroneMedicationLoadRequest droneMedicationLoadRequest
    ) {

        final DroneMedicationLoadResponseModel droneMedicationLoadResponseModel = droneService.load(DroneMedicationLoadConverter.toModel(droneMedicationLoadRequest));

        return new ResponseEntity<>(DroneMedicationLoadConverter.toResponse(droneMedicationLoadResponseModel), HttpStatus.CREATED);
    }

    @GetMapping(path = "details/{serialNumber}", produces = "application/json")
    public ResponseEntity<DroneMedicationLoadResponse> checkLoadedMedicationItem(@PathVariable("serialNumber") String serialNumber) {

        final DroneMedicationLoadResponseModel droneMedicationLoadResponseModel = droneService.checkLoadedMedicationsForDrone(serialNumber);

        return new ResponseEntity<>(DroneMedicationLoadConverter.toResponse(droneMedicationLoadResponseModel), HttpStatus.OK);
    }

    @GetMapping(path= "/available", produces = "application/json")
    public ResponseEntity<List<DroneModel>> getAvailableDroneForLoading() {

        return new ResponseEntity<>(droneService.getAvailableDroneForLoading(), HttpStatus.OK);
    }
}
