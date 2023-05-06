package com.pinapp.challenge.challenge.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RestControllerAdvice
public class ApplicationExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Set<String> handleInvalidArgument(MethodArgumentNotValidException ex) {
        Set<String> errorSet = new HashSet<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            if (error.getField().equals("birthDate")) {
                errorSet.add("Fecha de Nacimiento faltante o no valida");
            } else {
                errorSet.add(error.getDefaultMessage());
            }
        });

        return errorSet;
    }

}
