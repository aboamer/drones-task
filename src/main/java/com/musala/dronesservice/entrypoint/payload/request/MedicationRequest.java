package com.musala.dronesservice.entrypoint.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicationRequest {

    @NotNull
    @NotBlank
    @Pattern(regexp = "^[A-Z_-]*$", message = "code must be CAPITAL letters or -_")
    private String code;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9_-]*$", message = "name must be letters, numbers or -_")
    private String name;

    @NotNull
    @Positive(message = "weight should be positive")
    private Double weight;

    @NotNull
    @NotBlank
    private String image;
}
