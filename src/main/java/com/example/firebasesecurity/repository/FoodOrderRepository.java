package com.example.firebasesecurity.repository;

import com.example.firebasesecurity.domain.FoodOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface FoodOrderRepository extends CrudRepository<FoodOrder, String> {
    public List<FoodOrder> findByUser_Id(UUID userId);
}
