package com.musala.dronesservice.entrypoint.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicationRequest {

    @NotNull
    @NotBlank
    private String code;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private Double weight;

    @NotNull
    @NotBlank
    private String image;
}
