package com.musala.dronesservice.core.domain.droneregister.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum State {

    IDLE, LOADING, LOADED, DELIVERING, DELIVERED, RETURNING
}
