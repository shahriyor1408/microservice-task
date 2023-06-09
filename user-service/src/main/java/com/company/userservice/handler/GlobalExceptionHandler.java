package com.company.userservice.handler;

import com.company.userservice.response.AppErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @author "Sohidjonov Shahriyor"
 * @since 05/06/23 18:36
 * microservie-task
 */

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            String field = fieldError.getField();
            String defaultMessage = fieldError.getDefaultMessage();
            errors.put(field, defaultMessage);
        }
        String path = ((ServletWebRequest) request).getRequest().getRequestURI();
        AppErrorResponse errorResponse = AppErrorResponse.builder()
                .friendlyMessage("Invalid input!")
                .developerMessage("Invalid input!")
                .code(status.value())
                .path(path)
                .fields(errors)
                .build();
        return new ResponseEntity<>(errorResponse, status);
    }
}
