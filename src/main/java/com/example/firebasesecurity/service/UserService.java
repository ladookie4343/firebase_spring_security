package com.example.firebasesecurity.service;

import com.example.firebasesecurity.domain.FoodOrder;
import com.example.firebasesecurity.domain.User;
import com.example.firebasesecurity.repository.FoodOrderRepository;
import com.example.firebasesecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class UserService {

    private final FoodOrderRepository orders;
    private final UserRepository users;

    @Autowired
    public UserService(FoodOrderRepository orders, UserRepository users) {
        this.orders = orders;
        this.users = users;
    }

    public List<FoodOrder> getOrderFor(String userId) {
        return this.orders.findByUser_Id(UUID.fromString(userId));
    }

    public User getUserBy(String idpId) {
        return this.users.findByIdpId(idpId)
                .orElseThrow(() -> new UsernameNotFoundException("user " + idpId + " not found"));
    }
}
