package com.musala.dronesservice.entrypoint.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DroneMedicationLoadResponse {

    private String result;
    private String serialNumber;
    private String message;
}
