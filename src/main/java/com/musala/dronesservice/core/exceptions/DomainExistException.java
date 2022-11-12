package com.musala.dronesservice.core.exceptions;

import lombok.Getter;

@Getter
public class DomainExistException extends RuntimeException {

    public DomainExistException(final String message) {

        super(message);
    }
}
