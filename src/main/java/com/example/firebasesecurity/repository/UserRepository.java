package com.example.firebasesecurity.repository;

import com.example.firebasesecurity.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {
    Optional<User> findByIdpId(String idpId);
}
