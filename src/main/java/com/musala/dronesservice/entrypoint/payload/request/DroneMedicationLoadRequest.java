package com.musala.dronesservice.entrypoint.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DroneMedicationLoadRequest {

    @NotNull
    @NotBlank
    private String serialNumber;

    @NotNull
    @NotBlank
    private String source;

    @NotNull
    @NotBlank
    private String destination;

    @NotNull
    private MedicationRequest medicationRequest;
}
