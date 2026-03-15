package com.learning.hexagonalarchitecture.infrastructure.input.rest.response;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Getter
public class ErrorResponse {
    private final int status;
    private final String message;
    private final ZonedDateTime timestamp;

    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = ZonedDateTime.now();
    }
}
