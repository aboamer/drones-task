package com.musala.dronesservice.core.exceptions;

import lombok.Getter;

@Getter
public class DomainNotExistException extends RuntimeException {

    public DomainNotExistException(final String message) {

        super(message);
    }
}