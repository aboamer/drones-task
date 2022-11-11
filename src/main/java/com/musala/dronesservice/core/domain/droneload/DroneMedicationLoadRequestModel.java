package com.musala.dronesservice.core.domain.droneload;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DroneMedicationLoadRequestModel {

    private String serialNumber;
    private String source;
    private String destination;
    private MedicationRequestModel medicationRequestModel;
}
