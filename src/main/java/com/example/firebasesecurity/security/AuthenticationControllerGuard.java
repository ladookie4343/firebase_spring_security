package com.example.firebasesecurity.security;

import com.example.firebasesecurity.domain.User;
import com.example.firebasesecurity.exception.UserDoesntMatchTokenException;

import java.util.UUID;

public class AuthenticationControllerGuard {

    public static void assertUserIdMatchesUserIdFromToken(String userId, User userFromToken) {
        if (! UUID.fromString(userId).equals(userFromToken.getId())) {
            throw new UserDoesntMatchTokenException("");
        }
    }
}
