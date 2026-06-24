package org.motopart.cloud.config;

import org.motopart.cloud.common.ApiBaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.CREATED) // keep 201 so the client parses the envelope
    public ApiBaseResponse<Object> handleAll(Exception ex) {
        return ApiBaseResponse.error("Something went wrong: " + ex.getMessage());
    }
}
