package com.example.firebasesecurity;

import com.example.firebasesecurity.domain.FoodOrder;
import com.example.firebasesecurity.domain.User;
import com.example.firebasesecurity.repository.FoodOrderRepository;
import com.example.firebasesecurity.repository.UserRepository;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;

@Component
public class DataInitializer {

    private final FoodOrderRepository foodOrderRepository;
    private final UserRepository userRepository;

    public DataInitializer(FoodOrderRepository foodOrderRepository, UserRepository userRepository) {
        this.foodOrderRepository = foodOrderRepository;
        this.userRepository = userRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void populateDb() {
        System.out.println("hello");
        Arrays.asList("9Ee7RDVv52VzHhLhKgY7IECMDHA3", "XmJBNXlZGme5jPRhKgvtvydaz1R2").forEach(uid -> userRepository.save(User.builder().idpId(uid).roles(Arrays.asList("ROLE_USER")).build()));
        Arrays.asList(34, 22, 19).forEach(amount -> this.foodOrderRepository.save(FoodOrder.builder().amount(amount).user(userRepository.findByIdpId("9Ee7RDVv52VzHhLhKgY7IECMDHA3").orElseThrow()).build()));
        Arrays.asList(18, 32).forEach(amount -> this.foodOrderRepository.save(FoodOrder.builder().amount(amount).user(userRepository.findByIdpId("XmJBNXlZGme5jPRhKgvtvydaz1R2").orElseThrow()).build()));


        try {
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.getApplicationDefault())
                    .setDatabaseUrl("https://hangry-84310.firebaseio.com")
                    .build();
            FirebaseApp.initializeApp(options);
            System.out.println("Firebase initialization complete");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
