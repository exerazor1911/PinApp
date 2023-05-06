package com.pinapp.challenge.challenge.advice;

import com.pinapp.challenge.challenge.exception.RegisterException;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashSet;
import java.util.Set;

@RestControllerAdvice
@Hidden
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

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(RegisterException.class)
    @ResponseBody
    public String handleRegisterException(RegisterException ex) {
        return ex.getMessage();
    }

}
