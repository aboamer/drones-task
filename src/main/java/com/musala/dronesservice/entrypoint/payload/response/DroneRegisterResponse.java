package com.musala.dronesservice.entrypoint.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DroneRegisterResponse {

    private String result;
    private String serialNumber;
    private String message;
}
