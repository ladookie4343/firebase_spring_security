package com.example.firebasesecurity.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static org.springframework.http.ResponseEntity.status;

@ControllerAdvice
public class AppExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {InvalidJwtException.class})
    public ResponseEntity invalidJwt(InvalidJwtException ex) {
        return status(UNAUTHORIZED).build();
    }


    @org.springframework.web.bind.annotation.ExceptionHandler(value = {UserDoesntMatchTokenException.class})
    public ResponseEntity userDoesntMatchToken(UserDoesntMatchTokenException ex) {
        return status(UNAUTHORIZED).build();
    }
}
