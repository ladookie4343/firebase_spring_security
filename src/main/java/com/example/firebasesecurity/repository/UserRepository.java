package com.example.firebasesecurity.repository;

import com.example.firebasesecurity.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {
    Optional<User> findByIdpId(String idpId);
}
