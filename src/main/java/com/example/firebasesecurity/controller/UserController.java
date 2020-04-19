package com.example.firebasesecurity.controller;

import com.example.firebasesecurity.domain.FoodOrder;
import com.example.firebasesecurity.domain.User;
import com.example.firebasesecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}/foodOrders")
    public List<FoodOrder> getUserOrders(@PathVariable String userId, @AuthenticationPrincipal User user) {
        return userService.getOrderFor(userId);
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
