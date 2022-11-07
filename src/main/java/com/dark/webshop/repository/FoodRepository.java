package com.dark.webshop.repository;

import com.dark.webshop.entity.food.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Integer> {
}