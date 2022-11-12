package com.musala.dronesservice.core.utils;

import com.musala.dronesservice.core.domain.ErrorMessage;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class ErrorMessageFactory {

    private static final String DATE_PATTERN = "yyyy-MM-dd'T'hh:mm:ss";

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

    public static ErrorMessage create(final String message) {

        return ErrorMessage.builder()
                .message(message)
                .timestamp(LocalDateTime.now().format(DATE_TIME_FORMATTER))
                .build();
    }
}
