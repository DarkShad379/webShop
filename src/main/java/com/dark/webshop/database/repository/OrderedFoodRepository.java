package com.dark.webshop.database.repository;

import com.dark.webshop.database.entity.food.OrderedFood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedFoodRepository extends JpaRepository<OrderedFood, Integer> {
}