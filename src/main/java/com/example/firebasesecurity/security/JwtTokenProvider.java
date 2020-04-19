package com.example.firebasesecurity.security;

import com.example.firebasesecurity.domain.User;
import com.example.firebasesecurity.exception.InvalidJwtException;
import com.example.firebasesecurity.service.UserService;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Component
public class JwtTokenProvider {

    private final UserService userService;

    public JwtTokenProvider(UserService userService) {
        this.userService = userService;
    }

    public Optional<String> getToken(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return Optional.of(authorizationHeader.substring(7));
        }
        return Optional.empty();
    }

    public Optional<Authentication> getAuthentication(String token) {
        try {
            FirebaseToken firebaseToken = FirebaseAuth.getInstance().verifyIdToken(token);
            User user = userService.getUserBy(firebaseToken.getUid());
            return Optional.of(new UsernamePasswordAuthenticationToken(user, "", user.getAuthorities()));
        } catch (FirebaseAuthException e) {
            return Optional.empty();
        }
    }
}
