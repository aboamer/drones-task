package com.musala.dronesservice.core.exceptions;

import lombok.Getter;

@Getter
public class DroneValidationException extends RuntimeException {

    public DroneValidationException(final String message) {

        super(message);
    }
}