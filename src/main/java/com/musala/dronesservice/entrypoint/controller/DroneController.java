package com.musala.dronesservice.entrypoint.controller;

import com.musala.dronesservice.core.droneregister.domain.DroneRegisterResponseModel;
import com.musala.dronesservice.core.service.DroneService;
import com.musala.dronesservice.entrypoint.converter.droneregister.DroneRegisterConverter;
import com.musala.dronesservice.entrypoint.payload.request.DroneRegisterRequest;
import com.musala.dronesservice.entrypoint.payload.response.DroneRegisterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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
}
