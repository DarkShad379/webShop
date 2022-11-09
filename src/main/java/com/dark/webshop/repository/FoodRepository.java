package com.dark.webshop.repository;

import com.dark.webshop.entity.food.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Integer> {
    @Query("select f from Food where f.deleted =?1")
    public List<Food> findAllByOrderByNameAsc(boolean deleted);
}