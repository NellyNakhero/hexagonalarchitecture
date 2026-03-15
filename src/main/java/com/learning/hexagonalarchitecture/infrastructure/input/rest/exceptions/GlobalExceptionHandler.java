package com.learning.hexagonalarchitecture.infrastructure.input.rest.exceptions;

import com.learning.hexagonalarchitecture.domain.exception.GrafittiNotFoundException;
import com.learning.hexagonalarchitecture.domain.exception.InvalidGrafittiException;
import com.learning.hexagonalarchitecture.infrastructure.input.rest.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GrafittiNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleGrafittiNotFoundException(GrafittiNotFoundException exception) {
        ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(InvalidGrafittiException.class)
    public ResponseEntity<ErrorResponse> handleInvalidGrafittiException(InvalidGrafittiException exception) {
        ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception exception) {
        ErrorResponse error = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "An unexpected error occurred: "+exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
