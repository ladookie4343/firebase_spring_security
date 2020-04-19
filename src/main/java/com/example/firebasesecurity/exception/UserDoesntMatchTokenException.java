package com.example.firebasesecurity.exception;

import org.springframework.security.core.AuthenticationException;

public class UserDoesntMatchTokenException extends AuthenticationException {
    public UserDoesntMatchTokenException(String e) {
        super(e);
    }
}
