package com.example.firebasesecurity.exception;

import org.springframework.security.core.AuthenticationException;

public class InvalidJwtException extends AuthenticationException {
    public InvalidJwtException(String e) {
        super(e);
    }
}
