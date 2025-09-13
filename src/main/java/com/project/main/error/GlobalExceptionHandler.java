package com.project.main.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> RuntimeExceptionHandler(Exception e) {

        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("message", e.getLocalizedMessage());
        errorResponse.put("status", HttpStatus.BAD_REQUEST.value());

        return ResponseEntity.badRequest().body(errorResponse);

    }


}
