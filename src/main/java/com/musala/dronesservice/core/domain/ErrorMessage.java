package com.musala.dronesservice.core.domain;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Builder
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank
    private final String message;

    @NotBlank
    private final String timestamp;

}