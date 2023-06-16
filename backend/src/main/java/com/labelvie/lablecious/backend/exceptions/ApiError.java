package com.labelvie.lablecious.backend.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class ApiError {
    private final LocalDateTime timestamp;
    private final HttpStatus status;
    private final String message;
    private List<String> errors;

    public ApiError(LocalDateTime timestamp, HttpStatus status, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
