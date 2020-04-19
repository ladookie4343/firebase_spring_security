package com.example.firebasesecurity.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FoodOrder {

    @Id
    @GeneratedValue
    private UUID id;

    private int amount;

    @ManyToOne
    @JsonBackReference
    private User user;
}
