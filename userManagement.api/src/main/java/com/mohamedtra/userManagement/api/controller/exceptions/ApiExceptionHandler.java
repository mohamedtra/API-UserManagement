package com.mohamedtra.userManagement.api.controller.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = { ApiException.class })
    protected ResponseEntity<ErrorResource> convertException(ApiException ex, WebRequest request) {
        return new ResponseEntity<ErrorResource>(ex.getErrorResource(), ex.getErrorResource().getStatus());
    }

}
