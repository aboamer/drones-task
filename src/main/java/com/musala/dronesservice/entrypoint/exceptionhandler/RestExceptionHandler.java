package com.musala.dronesservice.entrypoint.exceptionhandler;

import com.musala.dronesservice.core.domain.ErrorMessage;
import com.musala.dronesservice.core.exceptions.DomainExistException;
import com.musala.dronesservice.core.exceptions.DomainNotExistException;
import com.musala.dronesservice.core.exceptions.DroneValidationException;
import com.musala.dronesservice.core.utils.ErrorMessageFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = DomainExistException.class)
    public ResponseEntity<Object> handleDomainExistException(final DomainExistException ex) {

        return buildResponseEntity(
                createErrorResponse(ex.getMessage()),
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(value = DomainNotExistException.class)
    public ResponseEntity<Object> handleDomainNotExistException(final DomainNotExistException ex) {

        return buildResponseEntity(
                createErrorResponse(ex.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(value = DroneValidationException.class)
    public ResponseEntity<Object> handleDroneValidationException(final DroneValidationException ex) {

        return buildResponseEntity(
                createErrorResponse(ex.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            final MethodArgumentNotValidException ex,
            final HttpHeaders headers,
            final HttpStatus status,
            final WebRequest request
    ) {

        return buildResponseEntity(
                createErrorResponse(ex.getBindingResult().getFieldErrors().stream().map(err -> err.getField() + " : " + err.getDefaultMessage())
                        .collect(java.util.stream.Collectors.joining(", "))),
                HttpStatus.BAD_REQUEST
        );
    }

    private static ResponseEntity<Object> buildResponseEntity(final Object response, final HttpStatus httpStatus) {

        return new ResponseEntity<>(response, httpStatus);
    }

    private ErrorMessage createErrorResponse(final String message) {

        return ErrorMessageFactory.create(message);
    }
}
