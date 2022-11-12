package com.musala.dronesservice.entrypoint.payload.request;

import com.musala.dronesservice.core.domain.droneregister.enums.Model;
import com.musala.dronesservice.core.domain.droneregister.enums.State;
import com.musala.dronesservice.core.utils.validators.EnumValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DroneRegisterRequest {

    @NotBlank
    @NotNull
    @Size(max = 100, message = "cannot exceed 100 characters for serial number")
    private String serialNumber;

    @NotBlank
    @NotNull
    @EnumValidator(enumClazz = Model.class)
    private String model;

    @NotNull
    @Max(value = 500, message = "value cannot exceed 500")
    private double weightLimit;

    @NotNull
    private BigDecimal battery;

    @NotBlank
    @NotNull
    @EnumValidator(enumClazz = State.class)
    private String state;
}
