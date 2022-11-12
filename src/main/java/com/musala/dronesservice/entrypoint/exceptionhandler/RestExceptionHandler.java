package com.musala.dronesservice.entrypoint.exceptionhandler;

import com.musala.dronesservice.core.domain.ErrorMessage;
import com.musala.dronesservice.core.exceptions.DomainExistException;
import com.musala.dronesservice.core.exceptions.DomainNotExistException;
import com.musala.dronesservice.core.utils.ErrorMessageFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = DomainExistException.class)
    public ResponseEntity<Object> handleDomainExistException(final DomainExistException ex) {

        return buildResponseEntity(
                createErrorResponse(ex.getMessage(), ex),
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(value = DomainNotExistException.class)
    public ResponseEntity<Object> handleDomainNotExistException(final DomainNotExistException ex) {

        return buildResponseEntity(
                createErrorResponse(ex.getMessage(), ex),
                HttpStatus.BAD_REQUEST
        );
    }

    private static ResponseEntity<Object> buildResponseEntity(final Object response, final HttpStatus httpStatus) {

        return new ResponseEntity<>(response, httpStatus);
    }

    private ErrorMessage createErrorResponse(final String message, final Exception ex) {

        return ErrorMessageFactory.create(message);
    }
}
